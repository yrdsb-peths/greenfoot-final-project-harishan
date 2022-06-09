import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class MyWorld here.
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
    public ArrayList<Heart> hearts;
    
    public int playerSpeed = 2;
    public int superSpeedCounter = 0;
    
    public boolean attackStatus = false; //used to see if player is currently
    //attacking. This way, they can't spam bullets until it hits the end of 
    //the world or an animal
    public boolean powerupStatus = true;
    
    public int fastArrowCounter=0; //counts # of fast arrows fired
    //labels
    Label scoreLabel;
    
    public int arrowSpeed = 2; //default speed of arrow
    
    
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
    
    public void spawnSuperSpeed(){
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
    
    public void addHearts() {
        for (int i = 0; i < lives; i++) {
            Heart heart = new Heart();
            hearts.add(heart);
            addObject(heart, 30 + i * 40, 80);
        }
    }
    
    //game over label displayed if player loses all lives
    public void gameOverDead(){
        Label gameOverLabel = new Label("You Died!", 60);
        Label finalScoreLabel = new Label("Your Final Score was "+score, 60);
        addObject(gameOverLabel, 300, 200);
        addObject(finalScoreLabel, 300,250);
    }
    
    //game over label displayed if snakes get treasure
    public void lostTreasure(){
        Label lostTreasureLabel = new Label("The Snakes got the Treasure!", 50);
        Label endScoreLabel = new Label("Your Final Score was "+score,60);
        addObject(lostTreasureLabel,300,200);
        addObject(endScoreLabel, 300,250);
    }
}
