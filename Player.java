import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 2)
 */
public class Player extends Actor
{
    String facing = "idle";
    
    public int attackX;
    public int attackY;
    public int randPwr; 
    
    GreenfootImage idle = new GreenfootImage("images/idle.png");
    GreenfootImage[] up = new GreenfootImage[8];
    GreenfootImage[] down = new GreenfootImage[8];
    GreenfootImage[] left = new GreenfootImage[8];
    GreenfootImage[] right = new GreenfootImage[8];
    //Constructor
    public Player(){
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
        // Add your action code here.
        facing = "idle";
        if(Greenfoot.isKeyDown("a")){
            facing = "left";
            setLocation(getX()-2, getY());
        }
        if(Greenfoot.isKeyDown("d")){
            facing = "right";
            setLocation(getX()+2, getY());
        }
        if(Greenfoot.isKeyDown("w")){
            facing = "up";
            setLocation(getX(), getY()-2);
        }
        if(Greenfoot.isKeyDown("s")){
            facing = "down";
            setLocation(getX(), getY()+2);
        }
        if(Greenfoot.isKeyDown("e")){
            MyWorld world = (MyWorld) getWorld();
            if(world.attackStatus==false){
                fire();
            }
        }
        
        animateExp();
        
        hitSnake();
        
        MyWorld world = (MyWorld) getWorld();
        if(world.score%5 == 0){
            if(world.powerupStatus == true){
                randPwr = Greenfoot.getRandomNumber(2);
                if(randPwr == 0){
                    world.spawnMedkit();
                }
                else if(randPwr == 1){
                    world.spawnFastArrow();
                }
                world.powerupStatus = false; 
            }
        }
        else if (world.score%5 != 0){
            world.powerupStatus = true; 
        }
        
    }    
    
    public void fire(){
        MyWorld world = (MyWorld) getWorld();
        world.attackStatus = true;
        attackX = getX(); 
        attackY = getY();
        world.addObject(new Bullet(), attackX, attackY);
    }
    public void hitSnake(){
        if(isTouching(Snake.class)){
            removeTouching(Snake.class);
            MyWorld world = (MyWorld) getWorld();
            world.lives -=1; 
            if(world.lives == 0){
                world.gameOverDead();
            }
            world.livesLabel.setValue(world.lives); 
            world.spawnSnake();
       } 
    }
}
