import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hearts that are displayed and represent the # of lives the user has
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 9)
 */
public class Heart extends Actor
{
    /**
     * Constructor
     */
    
    public Heart(){
        //scale heart image
        GreenfootImage heartImg = new GreenfootImage("images/heart.png");
        heartImg.scale(40,40);
        setImage(heartImg);
    }
    public void act()
    {
        // Add your action code here.
    }
}
