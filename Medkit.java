import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *Medkit powerup
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (june 7)
 */
public class Medkit extends Actor
{
    public Medkit(){
        GreenfootImage medkitImg = new GreenfootImage("images/medkit.png");
        medkitImg.scale(60, 60);
        setImage(medkitImg);
    }
    
    /**
     * Act - do whatever the Medkit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //if player touches powerup, player gains 1 life
        if(isTouching(Player.class)){
            MyWorld world = (MyWorld) getWorld();
            world.lives += 1;
            world.removeObjects(world.hearts);
            world.hearts.clear();
            world.addHearts();
            world.removeObject(this);
        }
    }
}
