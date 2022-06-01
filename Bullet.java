import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    public int attackX;
    public int vel;
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        move(2);
    }
    
    public void fireBullet(){
        attackX = getX(); 
        //need attackX to be equal to the player's x coordinate
        //ask mr chan how to globalize x to use in bullet 
        vel +=10; //velocity of bullet
        int attackCalc = (attackX+=vel);//will add to the x value so 
        //bullet moves
    }
}
