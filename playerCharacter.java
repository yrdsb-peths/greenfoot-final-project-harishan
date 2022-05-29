import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playerCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playerCharacter extends Actor
{
    
    /**
     * Act - do whatever the playerCharacter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        int x = getX();
        int y = getY();
        setLocation (x,y);
        
        if(Greenfoot.isKeyDown("a")){
            x -=2;
        }
        if(Greenfoot.isKeyDown("d")){
            x+=2;
        }
        if(Greenfoot.isKeyDown("w")){
            y-=2;
        }
        if(Greenfoot.isKeyDown("s")){
            y+=2;
        }
        
        MyWorld world = (MyWorld) getWorld();
    }
}
