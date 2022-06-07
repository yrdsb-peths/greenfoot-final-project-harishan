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
    public Bullet(){
        GreenfootImage arrow = new GreenfootImage("images/arrow.png");
        arrow.scale(90, 25);
        setImage(arrow);
    }
    public void act()
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        move(world.arrowSpeed);
        //How would i refer to the attack status variable from the 
        //player code
        if(getX() > getWorld().getWidth() -5){  
            world.attackStatus = false;
            getWorld().removeObject(this);
        }
    }
}
