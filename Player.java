import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playerCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public boolean attackStatus = false; //used to see if player is currently
    //attacking. This way, they can't spam bullets until it hits the end of 
    //the world or an animal
    public int attackX;
    public int attackY;
    /**
     * Act - do whatever the playerCharacter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX()-2, getY());
        }
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX()+2, getY());
        }
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY()-2);
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY()+2);
        }
        if(Greenfoot.isKeyDown("e")){
            if(attackStatus==false){
                MyWorld world = (MyWorld) getWorld();
                fire();
                if(attackX==600){
                    attackStatus=false;
                }
            }
        }
        
    }    
    
    public void fire(){
        attackStatus = true; 
        MyWorld world = (MyWorld) getWorld();
        attackX = getX(); 
        attackY = getY();
        world.addObject(new Bullet(), attackX, attackY);
        
        
    }
    
}
