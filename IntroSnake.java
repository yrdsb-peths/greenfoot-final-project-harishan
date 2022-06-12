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
     * Act - do whatever the IntroSnake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public IntroSnake(){ //scale snake image
        GreenfootImage snakeImg = new GreenfootImage("images/snake.png");
        snakeImg.scale(110, 30);
        setImage(snakeImg);
    }
    public void act()
    {
        // Add your action code here.
    }
}
