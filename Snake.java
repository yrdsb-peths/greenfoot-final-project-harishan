import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Actor
{
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 1;
    public void act()
    {
        // Add your action code here.
        int x = getX() - speed;
        int y = getY();
        setLocation(x,y);
        
        //if snake reaches end, game is over (snake reached treasure)
        if(getX() == 0){
            MyWorld world = (MyWorld) getWorld();
            world.lostTreasure();
        }
        
        //if snake is hit by arrow, remove bullet, snake, increase score and spawn 
        //new snake
        if(isTouching(Bullet.class)){
            removeTouching(Bullet.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnSnake();
            world.increaseScore();
            world.attackStatus = false;
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd){
        speed = spd;
    }
}
