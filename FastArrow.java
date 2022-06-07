import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FastArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FastArrow extends Actor
{
    /**
     * Act - do whatever the FastArrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(isTouching(Player.class)){
            MyWorld world = (MyWorld) getWorld();
            world.arrowSpeed = 4;
            world.livesLabel.setValue(world.lives); 
            world.removeObject(this);
        }
    }
}
