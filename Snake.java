import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * enemys that try and kill the user
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 3)
 */
public class Snake extends Actor
{
    public Snake(){
        GreenfootImage snakeImg = new GreenfootImage("images/snake.png");
        snakeImg.scale(110, 30);
        setImage(snakeImg);
    }
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
        
        //if snake reaches end, game is over (snake reached border)
        if(getX() == 0){
            MyWorld world = (MyWorld) getWorld();
            GameOverWorld lostTreasure = new GameOverWorld(world.score);
            Greenfoot.setWorld(lostTreasure); 
        }
        
        //if snake is hit by arrow, remove bullet, snake, increase score and spawn 
        //new snake
        if(isTouching(Arrow.class)){
            removeTouching(Arrow.class);
            MyWorld world = (MyWorld) getWorld();
            world.arrowHitSound.play();
            world.spawnSnake();
            world.increaseScore();
            world.removeObject(this);
        }
    }
    /**
     * set speed for snake 
     */
    public void setSpeed(int spd){
        speed = spd;
    }
}
