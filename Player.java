import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 2)
 */
public class Player extends Actor
{
    
    public int attackX;
    public int attackY;
    /**
     * Act - do whatever the playerCharacter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX()-2, getY());
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX()+2, getY());
        }
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY()-2);
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY()+2);
        }
        if(Greenfoot.isKeyDown("e")){
            MyWorld world = (MyWorld) getWorld();
            if(world.attackStatus==false){
                fire();
            }
        }
        hitSnake();
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
                world.gameOver();
            }
            world.livesLabel.setValue(world.lives); 
            world.spawnSnake();
       } 
    }
}
