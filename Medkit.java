import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Medkit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Medkit extends Actor
{
    /**
     * Act - do whatever the Medkit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(isTouching(Player.class)){
            MyWorld world = (MyWorld) getWorld();
            world.lives += 1; 
            world.livesLabel.setValue(world.lives); 
            world.removeObject(this);
        }
    }
}
