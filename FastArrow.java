import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *fast arrow powerup 
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 3)
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
        //if the player touches the powerup, arrow speed is 0.5x faster permanently
        if(isTouching(Player.class)){
            MyWorld world = (MyWorld) getWorld();
            world.arrowSpeed +=0.5;
            world.removeObject(this);
        }
    }
}
