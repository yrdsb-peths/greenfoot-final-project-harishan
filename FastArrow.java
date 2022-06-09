import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FastArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FastArrow extends Actor
{
    public FastArrow(){
        //scale fast arrow image 
        GreenfootImage fastArrowImg = new GreenfootImage("images/fastArrow.png");
        fastArrowImg.scale(50, 50);
        setImage(fastArrowImg);
    }
    /**
     * Act - do whatever the FastArrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //if the player touches the powerup, arrow speed is doubled
        if(isTouching(Player.class)){
            MyWorld world = (MyWorld) getWorld();
            world.fastArrowCounter =0;
            world.arrowSpeed = 4;
            world.removeObject(this);
        }
    }
}
