import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SuperSpeed here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SuperSpeed extends Actor
{
    /**
     * Act - do whatever the SuperSpeed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(isTouching(Player.class)){
            MyWorld world = (MyWorld) getWorld();
            world.playerSpeed = 4;
            world.removeObject(this);
        }
    }
}
