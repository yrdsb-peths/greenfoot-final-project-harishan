import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Treasure that the user must protect
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 4)
 */
public class Treasure extends Actor
{
    /**
     * Act - do whatever the Treasure wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Treasure(){
        //scale treasure image
        GreenfootImage treasureImg = new GreenfootImage("images/treasure.png");
        treasureImg.scale(75, 75);
        setImage(treasureImg);
    }
    public void act()
    {
        // Add your action code here.
    }
}
