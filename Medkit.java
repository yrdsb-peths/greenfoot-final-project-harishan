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
     * if player touches powerup, player gains 1 life
     */
    public void act()
    {
        if(isTouching(Player.class)){
            MyWorld world = (MyWorld) getWorld();
            world.equipPowerupSound.play();
            world.lives += 1;
            world.removeObjects(world.hearts);
            //reset the array of hearts to display proper number of hearts
            world.hearts.clear();
            world.addHearts();
            world.removeObject(this);
        }
    }
}
