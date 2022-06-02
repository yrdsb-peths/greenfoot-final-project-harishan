import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 1)
 */
public class MyWorld extends World
{
    public int x;
    public int y;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        getX(100);
        getY(350);
        spawnPlayer();
        
    }
    
    public int getX(int theX){
        x = theX;
        return x;
    }
    public int getY(int theY){
        y=theY;
        return y;
    }
    public void spawnPlayer(){ 
        Player player = new Player();
        addObject(player, x,y);
    }
    
}
