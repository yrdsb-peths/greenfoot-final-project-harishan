import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * MyWorld class, where player plays game 
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 1)
 */
public class MyWorld extends World
{
    public int x;
    public int y;
    public int level = 1; 
    public int score = 0; 
    public int lives=3; 
    public ArrayList<Heart> hearts; //array containing hearts
    
    public float playerSpeed = 2; //default speed of player
    public float arrowSpeed = 2; //default speed of arrow
    
    public boolean powerupStatus = true; //checks to see if player has a powerup
    //activated or not 
    //timer for attacks
    public SimpleTimer attackTimer = new SimpleTimer();
    //labels
    Label scoreLabel;
    //sound effects
    GreenfootSound arrowHitSound = new GreenfootSound("hitArrow.mp3");
    GreenfootSound equipPowerupSound = new GreenfootSound("equipPowerup.mp3");
    GreenfootSound startGameSound = new GreenfootSound("gameStartSound.mp3");    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        //scale background to size of world
        GreenfootImage bg = new GreenfootImage("images/background.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        startGameSound.play();
        
        
        //spawn player road and snake   
        spawnRoad();
        //spawn labels for score and lives
        scoreLabel = new Label("Score: "+0,40);
        addObject(scoreLabel, 110,40);
        
        hearts = new ArrayList<Heart>();
        addHearts();
        
        spawnPlayer();
        spawnSnake();
    }
    /**
     * method for spawning player in world 
     */
    private void spawnPlayer(){
        Player player = new Player();
        addObject(player, 100, 350);
    }
    /**
     * method for spawning snake 
     */
    public void spawnSnake(){
        int x = 600;
        int y = Greenfoot.getRandomNumber(350);
        
        Snake snake = new Snake();
        snake.setSpeed(level);
        addObject(snake,x,y);
    }
    /**
     * spawn border that snake cannot touch
     */
    private void spawnRoad(){
        Road road = new Road();
        addObject(road,25, 200);
    }
    /**
     * method for spawning Medkit
     */
    public void spawnMedkit(){ 
        Medkit medkit = new Medkit();
        addObject(medkit, Greenfoot.getRandomNumber(200), Greenfoot.getRandomNumber(180)); 
    }
    /**
     * method for spawning fast arrow powerup
     */
    public void spawnFastArrow(){ 
        FastArrow fastArrow = new FastArrow();
        addObject(fastArrow, Greenfoot.getRandomNumber(200), Greenfoot.getRandomNumber(180));
    }
    /**
     * method for spawning super speed powerup
     */
    public void spawnSuperSpeed(){ 
        SuperSpeed superSpeed = new SuperSpeed();
        addObject(superSpeed, Greenfoot.getRandomNumber(200), Greenfoot.getRandomNumber(180));
    }
    
    /**
     * increases score 
     */
    public void increaseScore(){ 
        score++;
        scoreLabel.setValue("Score: "+score);
        if(score%5==0){
            level+=1;
        }
    }
    /**
     * adds display for hearts 
     */
    public void addHearts(){
        for (int i = 0; i < lives; i++) {
            Heart heart = new Heart();
            hearts.add(heart);
            addObject(heart, 70 + i * 40, 70);
        }
    }
}
