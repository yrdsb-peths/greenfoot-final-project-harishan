import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * projectile class
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
        //scale image of arrow 
        GreenfootImage arrow = new GreenfootImage("images/arrow.png");
        arrow.scale(90, 25);
        setImage(arrow);
    }
    public void act()
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        move((int)(world.arrowSpeed));
        
        //if the arrow hits the end of the world, it removes itself
        if(getX() > getWorld().getWidth() -5){  
            getWorld().removeObject(this);
        }
    }
}
