import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * projectile class
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 2)
 */
public class Arrow extends SmoothMover
{
    /**
     * Constructor
     */
    public Arrow(){
        //scale image of arrow 
        GreenfootImage arrow = new GreenfootImage("images/arrow.png");
        arrow.scale(90, 25);
        setImage(arrow);
    }
    /**
     * move the arrow by world.arrowSpeed, which changes depending on fast arrow powerup
     */
    public void act(){
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        move(world.arrowSpeed);
        
        //if the arrow hits the end of the world, it removes itself
        if(getX() > getWorld().getWidth() -5){  
            getWorld().removeObject(this);
        }
    }
}
