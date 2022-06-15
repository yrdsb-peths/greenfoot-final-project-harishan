import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Border here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Road extends Actor
{
    /**
     * Constructor 
     */
    public Road(){
        //scale road image
        GreenfootImage roadImg = new GreenfootImage("images/border.jpg");
        roadImg.scale(50,400);
        setImage(roadImg);
    }
    /**
     * Act - do whatever the Border wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
