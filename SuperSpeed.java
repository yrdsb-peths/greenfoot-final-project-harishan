import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Super Speed Powerup
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 6)
 */
public class SuperSpeed extends Actor
{
    public SuperSpeed(){
        //scale speedboost image
        GreenfootImage speedBoostImg = new GreenfootImage("images/speedboost.png");
        speedBoostImg.scale(50, 50);
        setImage(speedBoostImg);
    }
    /**
     * Act - do whatever the SuperSpeed wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     *  if player touches powerup, player speed is 0.5x faster permanently
     */
    public void act()
    {
        if(isTouching(Player.class)){
            MyWorld world = (MyWorld) getWorld();
            world.equipPowerupSound.play();
            world.playerSpeed +=0.5;
            world.removeObject(this);
        }
    }
}
