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
    public int level = 1; //level
    public int score = 0; //score
    public int lives=3; //lives
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
        //spawn player treasure and snake   
        spawnPlayer();
        spawnSnake();
        spawnTreasure();
        
        //spawn labels for score and lives
        scoreLabel = new Label("Score: "+0,40);
        addObject(scoreLabel, 70,50);
        
        hearts = new ArrayList<Heart>();
        addHearts();
    }
    
    public void spawnPlayer(){
        Player player = new Player();
        addObject(player, 100, 350);
    }
    
    public void spawnSnake(){
        int x = 600;
        int y = Greenfoot.getRandomNumber(350);
        
        Snake snake = new Snake();
        snake.setSpeed(level);
        addObject(snake,x,y);
    }
    
    public void spawnTreasure(){
        Treasure treasure = new Treasure();
        addObject(treasure,15, 200);
    }
    
    public void spawnMedkit(){ //method for spawning a medkit
        Medkit medkit = new Medkit();
        addObject(medkit, Greenfoot.getRandomNumber(300), Greenfoot.getRandomNumber(180)); 
    }
    
    public void spawnFastArrow(){ //method for spawning fast arrow powerup
        FastArrow fastArrow = new FastArrow();
        addObject(fastArrow, Greenfoot.getRandomNumber(300), Greenfoot.getRandomNumber(180));
    }
    
    public void spawnSuperSpeed(){ //method for spawning super speed powerup
        SuperSpeed superSpeed = new SuperSpeed();
        addObject(superSpeed, Greenfoot.getRandomNumber(300), Greenfoot.getRandomNumber(180));
    }
    
    //increases score
    public void increaseScore(){ 
        score++;
        scoreLabel.setValue("Score: "+score);
        if(score%5==0){
            level+=1;
        }
    }
    
    public void addHearts(){//adds display for hearts.
        for (int i = 0; i < lives; i++) {
            Heart heart = new Heart();
            hearts.add(heart);
            addObject(heart, 30 + i * 40, 80);
        }
    }
}
