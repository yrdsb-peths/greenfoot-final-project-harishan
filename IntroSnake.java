import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * IntroSnake just makes a static object of the snakes in game that do not move for the intro screen
 * If I used the actual snake objects, they would move across the screen and bunch up at the end which does not look good
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 9)
 */
public class IntroSnake extends Actor
{
    /**
     * Constructor
     */
    public IntroSnake(){ 
        GreenfootImage snakeImg = new GreenfootImage("images/snake.png");
        snakeImg.scale(110, 30);
        setImage(snakeImg);
    }
    public void act()
    {
        // Add your action code here.
    }
}
