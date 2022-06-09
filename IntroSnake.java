import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * IntroSnake just makes a static object of the snakes in game that do not move for the intro screen
 * If I used the actual snake objects, they would move across the screen and bunch up at the end which does not look good
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IntroSnake extends Actor
{
    /**
     * Act - do whatever the IntroSnake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public IntroSnake(){
        GreenfootImage snakeImg = new GreenfootImage("images/snake.png");
        snakeImg.scale(160, 120);
        setImage(snakeImg);
    }
    public void act()
    {
        // Add your action code here.
    }
}
