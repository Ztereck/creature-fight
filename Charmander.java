import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * Write a description of class Charmander here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Charmander extends Creature
{
    public Charmander( World w )
    {
        super(500,true, "Fire");
        getImage(). scale( 150, 100);
        w.addObject(getHealthBar(), 300, w.getHeight() - 50 );
    }
    
    /**
     * attack does the creatures attack
     * 
     * @param idx is the buttons in the switch and the fight menus
     * @return nothing is returned
     */
    public void attack( int idx )
    {
        CreatureWorld world = (CreatureWorld)getWorld();
        Creature enemy = world.getPlayerTwo();
        String enemyType = enemy.getType();
        attackAnimation();
        if( idx == 0 )
        {
            enemy.getHealthBar().add(-25);
        }
        else
        {
            if( enemyType.equalsIgnoreCase ("Water"))
            {
                enemy.getHealthBar().add(-70/2);
                getWorld().showText( "Its not very effective...", getWorld().getWidth()/2, getWorld().getHeight()/2 + 26 );
                Greenfoot.delay(30);
            }
            else
            {
                enemy.getHealthBar().add(-70);
            }
        }
        world.setTurnNumber(false);
    }
    
    /**
     * attack animation makes the attack animation
     * 
     * @param there are no parameters
     * @return nothing is returned
     */
    private void attackAnimation()
    {
        int originalX;
        int originalY;
        
        originalX = getX();
        originalY = getY();
        
        for( int i = 0; i < 15; i++)
        {
            setLocation( getX() + 1, getY() - 2 );
            Greenfoot.delay(1);
        }
        setLocation( originalX, originalY );
    }
    
    /**
     * switchCreature switches out your creature to one of your choice
     * 
     * @param idx is the buttons in the switch and the fight menus
     * @return nothing is returned
     */
    public void switchCreature( int idx )
    {
        CreatureWorld world = (CreatureWorld)getWorld();
        Creature switchCreature;
        if( idx == 0 )
        {
            switchCreature = world.getNewOneCreature(1);
        }
        else
        {
            switchCreature = world.getNewOneCreature(2);
        }
        
        if( switchCreature.getHealthBar().getCurrent() <= 0 )
        {
            JOptionPane.showMessageDialog( null, "This creature has fainted! Please select a different creature." );
        }
        else
        {
            while( getX() > 0 )
            {
                setLocation( getX() - 5, getY() );
                Greenfoot.delay(2);
            }
            getImage().setTransparency(0);
            getHealthBar().getImage().setTransparency(0);
            if( idx == 0 )
            {
               world.changePlayerOne( "Golem" );
            }
            else
            {
                world.changePlayerOne( "Ivysaur" );
            }
            switchCreature.switchedIn();
            world.setTurnNumber(false);
        }
    }
    
    /**
     * gets the image and sets the location of your current creature
     * 
     * @param there are no parameters
     * @return nothingh is returned
     */
    public void switchedIn()
    {
        getImage().setTransparency(255);
        getHealthBar().getImage().setTransparency(255);
        while( getX() < 75 )
        {
            setLocation( getX() + 5, getY() );
            Greenfoot.delay(2);
        }
    }
    
    /**
     * Act - do whatever the Charmander wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        if( getHealthBar().getCurrent() <= 0 )
        {
            getWorld().showText("Charmander Has Fainted",getWorld().getWidth()/2,getWorld().getHeight()/2 + 26);
            Greenfoot.delay(30);
            if( playerWorld.getNewOneCreature(1).getHealthBar().getCurrent() > 0 )
            {
                switchCreature(0);
                playerWorld.setTurnNumber(true);
                getWorld().showText("",getWorld().getWidth()/2,getWorld().getHeight()/2 + 26);
                getWorld().removeObject(this);
            }
            else if( playerWorld.getNewOneCreature(2).getHealthBar().getCurrent() > 0 )
            {
                switchCreature(1);
                playerWorld.setTurnNumber(true);
                getWorld().showText("",getWorld().getWidth()/2,getWorld().getHeight()/2 + 26);
                getWorld().removeObject(this);
            }
        }
    }
}