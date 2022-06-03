import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 2)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        move(2);
        shootSnake();
        //super.attackStatus = false;
        //How would i refer to the attack status variable from the player code
        if(getX() > getWorld().getWidth() -5){
            getWorld().removeObject(this);
        }
    }
    public void shootSnake(){
        if(isTouching(Snake.class)){
            removeTouching(Snake.class);
            MyWorld world = (MyWorld) getWorld();
            //increaseScore method 
            world.spawnSnake();
            world.removeObject(this);
            
        }
    }
    
}
