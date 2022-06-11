import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Opening title screen with basic instructions on key inputs 
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 9)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Snake Hunter", 100);
    Label movementLabel = new Label("Use WASD to move around", 40);
    Label attackLabel = new Label("Press E to shoot an arrow", 40);
    Label changeWorldLabel = new Label ("Press SPACE to Continue", 50);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage introBg = new GreenfootImage("images/introbackground.jpg");
        introBg.scale(getWidth(), getHeight());
        setBackground(introBg);

        addObject(titleLabel, getWidth()/2, 150);
        addObject(movementLabel, getWidth()/2, 220);
        addObject(attackLabel, getWidth()/2, 260);
        addObject(changeWorldLabel, getWidth()/2,320);
        prepare();
    }

    /**
     * act method
     */
    boolean flag = false;
    public void act(){
        //start game if user presses space
        if(!Greenfoot.isKeyDown("space")){
            flag = true;
        }
        if(flag && Greenfoot.isKeyDown("space")){
            InstructionScreen instructions = new InstructionScreen();
            Greenfoot.setWorld(instructions); 
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        IntroSnake introSnake = new IntroSnake();
        addObject(introSnake,420,35);
        introSnake.setLocation(449,83);
        IntroSnake introSnake2 = new IntroSnake();
        addObject(introSnake2,449,83);
        IntroSnake introSnake3 = new IntroSnake();
        addObject(introSnake3,243,72);
        introSnake3.setLocation(286,42);
        IntroSnake introSnake4 = new IntroSnake();
        addObject(introSnake4,142,75);
        introSnake4.setLocation(216,101);
    }
}
