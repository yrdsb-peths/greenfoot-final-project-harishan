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
     * Act - do whatever the Heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
