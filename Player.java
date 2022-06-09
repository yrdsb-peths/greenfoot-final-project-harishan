import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 2)
 */
public class Player extends Actor
{
    //direction character is facing (set by default to idle/front)
    String facing = "idle";
    
    //x and y for arrow attack 
    public int attackX;
    public int attackY;
    //random number to determine which powerup spawns
    public int randPwr; 
    
    //idle image and image arrays for animation 
    GreenfootImage idle = new GreenfootImage("images/idle.png");
    GreenfootImage[] up = new GreenfootImage[8];
    GreenfootImage[] down = new GreenfootImage[8];
    GreenfootImage[] left = new GreenfootImage[8];
    GreenfootImage[] right = new GreenfootImage[8]; 
    
    SimpleTimer animationTimer = new SimpleTimer();
    //Constructor
    public Player(){
        //animation for up down left right, and sets image by default to idle
        for(int i = 0; i<up.length;i++){
            up[i] = new GreenfootImage("images/explorerUp/up"+i+".png");
        }
        for(int i = 0; i<down.length;i++){
            down[i] = new GreenfootImage("images/explorerDown/down"+i+".png");
        }
        for(int i =0; i<left.length;i++){
            left[i] = new GreenfootImage("images/explorerLeft/left"+i+".png");
        }
        for(int i =0; i<right.length;i++){
            right[i] = new GreenfootImage("images/explorerRight/right"+i+".png");
        }
        
        
        setImage(idle);
    }
    
    //Animate Explorer
    int imageIndex = 0;
    public void animateExp(){
        if(animationTimer.millisElapsed()<30){
            return;
        }
        animationTimer.mark();
        if(facing.equals("up")){
            setImage(up[imageIndex]);
            imageIndex = (imageIndex + 1) %up.length;
        }
        else if(facing.equals("down")){
            setImage(down[imageIndex]);
            imageIndex = (imageIndex + 1)%down.length;
        }
        else if (facing.equals("left")){
            setImage(left[imageIndex]);
            imageIndex = (imageIndex+1)%left.length;
        }
        else if (facing.equals("right")){
            setImage(right[imageIndex]);
            imageIndex = (imageIndex+1)%right.length;
        }
        else if (facing.equals("idle")){
            setImage(idle);
        }
    }
    /**
     * Act - do whatever the playerCharacter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //resets player to 'idle' when not moving, else animates and moves player
        facing = "idle";
        MyWorld world = (MyWorld) getWorld();
        if(Greenfoot.isKeyDown("a")){
            facing = "left";
            setLocation(getX()-world.playerSpeed, getY());
        }
        if(Greenfoot.isKeyDown("d")){
            facing = "right";
            setLocation(getX()+world.playerSpeed, getY());
        }
        if(Greenfoot.isKeyDown("w")){
            facing = "up";
            setLocation(getX(), getY()-world.playerSpeed);
        }
        if(Greenfoot.isKeyDown("s")){
            facing = "down";
            setLocation(getX(), getY()+world.playerSpeed);
        }
        if(Greenfoot.isKeyDown("e")){
            //if the player is not already attacking, then fire
            if(world.attackStatus==false){
                fire();
            }
        }
        
        //animate explorer
        animateExp();
        //if touched by snake method 
        hitSnake();
        
        //powerup spawner and randomizer
        //if new level is advanced, and if powerupstatus is true (not active)
        //activate randomizer
        if(world.score%5 == 0){
            if(world.powerupStatus == true){
                randPwr = Greenfoot.getRandomNumber(3);
                if(randPwr == 0){
                    world.spawnMedkit();
                }
                else if(randPwr == 1){
                    world.spawnFastArrow();
                }
                else if(randPwr == 2){
                    world.spawnSuperSpeed();
                }
                //set powerupstatus to false (powerup active) so no more spawn
                world.powerupStatus = false; 
            }
        }
        /**
         * if score isn't a multiple of 5, then set powerupstatus to true
         * This way, once new level is reached, a powerup is able to spawn
         */
        else if (world.score%5 != 0){
            world.powerupStatus = true; 
        }
    }    
    
    //fire method 
    public void fire(){
        MyWorld world = (MyWorld) getWorld();
        world.attackStatus = true;
        attackX = getX(); 
        attackY = getY();
        world.addObject(new Bullet(), attackX, attackY);
    }
    //if player is hit by snake, remove 1 life, update lives label, and spawn new snake 
    public void hitSnake(){
        if(isTouching(Snake.class)){
            removeTouching(Snake.class);
            MyWorld world = (MyWorld) getWorld();
            world.lives -=1; 
            if(world.lives == 0){
                GameOverWorld playerDead = new GameOverWorld();
                Greenfoot.setWorld(playerDead); 
            }
            world.livesLabel.setValue(world.lives); 
            world.spawnSnake();
       } 
    }
}
