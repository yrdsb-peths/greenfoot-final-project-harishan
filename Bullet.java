import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 2)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Bullet(){
        //scale image of arrow 
        GreenfootImage arrow = new GreenfootImage("images/arrow.png");
        arrow.scale(90, 25);
        setImage(arrow);
    }
    public void act()
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        move(world.arrowSpeed);
        
        if(world.arrowSpeed == 4){
            if(isTouching(Snake.class)){
                world.fastArrowCounter +=1; 
            }
        }
        if(world.fastArrowCounter == 3){
            world.arrowSpeed = 2; 
            world.fastArrowCounter = 0;
        }
        
        if(world.playerSpeed == 4){
            if(isTouching(Snake.class)){
                world.superSpeedCounter +=1; 
            }
        }
        if(world.superSpeedCounter == 4){
            world.playerSpeed = 2; 
            world.superSpeedCounter = 0;
        }
        
        //if the arrow hits the end of the world, it removes itself
        if(getX() > getWorld().getWidth() -5){  
            world.attackStatus = false;
            getWorld().removeObject(this);
        }
    }
}
