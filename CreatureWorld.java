import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * Name: (Zachary Tereck)
 * Course: CS20S
 * Teacher:Mr.Hardman
 * Lab #2, Program #1
 * Date Last Modified: (oct.24, 2017)
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreatureWorld extends World
{
    private Creature playerOneCreature; //IN MEMORY OF BRAYDENS ARMS 2002-2002
    private Creature playerTwoCreature;
    private int turnNumber;
    private String playerOneName;
    private String playerTwoName;
    private Menu oneFightMenu;
    private Menu oneSwitchMenu;
    private Menu twoFightMenu;
    private Menu twoSwitchMenu;
    
    /**
     * Default constructor for objects of class MyWorld.
     * 
     * @param There are no parameters
     * @return an object of class MyWorld
     */
    public CreatureWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 750, 1); 
        turnNumber = 0;
        playerOneCreature = new Charmander(this);
        playerTwoCreature = new Pikachu(this);
        
        prepareCreatures();
        Greenfoot.start();
    }
    
    private void prepareCreatures()
    {
        addObject(playerOneCreature, playerOneCreature.getImage().getWidth()/2, getHeight() - playerOneCreature.getImage().getHeight()/2 );
        
        addObject(playerTwoCreature, playerTwoCreature.getImage().getWidth() + 510, getHeight() - playerTwoCreature.getImage().getHeight() + -570 );
    }
    
    public Creature getPlayerOne()
    {
       return playerOneCreature;
    }
    
    public Creature getPlayerTwo()
    {
       return playerTwoCreature;
    }
    
    public int getTurnNumber()
    {
        return turnNumber;
    }
    
    public void setTurnNumber( int turn )
    {
        turnNumber = turn;
    }
    
    /**
     * act will complete actions that the CreatureWorld object should
     * accomplish while the scenario is running
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        if( turnNumber == 0 )
        {
            playerOneName = JOptionPane.showInputDialog( "Player One, please enter your name:", null );
            playerTwoName = JOptionPane.showInputDialog( "Player Two, please enter your name:", null );
            oneFightMenu = new Menu( "Fight","Scratch \nFlamethrower",24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
            oneSwitchMenu = new Menu( "Switch", "Golem\nIvysaur",24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
            addObject( oneFightMenu, 173, getHeight() - 100 );
            addObject( oneSwitchMenu, 241, getHeight() - 100 );
            twoFightMenu = new Menu( "Fight", "Tackel\nThunderbolt", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new FightCommands() );
            twoSwitchMenu = new Menu( "Switch", "Lapras\nPidgeot", 24, Color.BLACK, Color.WHITE, Color.BLACK, Color.WHITE, new SwitchCommands() );
            addObject( twoFightMenu, 131, 75 );
            addObject( twoSwitchMenu, 199, 75 );
            turnNumber = 1;
        }
        else if( turnNumber == 1 )
        {
            showText( playerOneName + " your turn", getWidth()/2, getHeight()/2 );
            showText( "", getWidth()/2, getHeight()/2 + 26 );
        }
        else if( turnNumber == 2 )
        {
            showText( playerTwoName + " your turn", getWidth()/2, getHeight()/2 );
            showText( "", getWidth()/2, getHeight()/2 + 26 );
        }
        
        List allObjects = getObjects(null);
        if( playerOneCreature. getHealthBar().getCurrent() <= 0 )
        {
             removeObjects(allObjects);
             showText( "", getWidth()/2, getHeight()/2 );
             showText("Your Pokemon Sucks",getWidth()/2, getHeight()/2 + 26);
             Greenfoot.stop();
        }
        
        if( playerTwoCreature. getHealthBar().getCurrent() <= 0 )
        {
             removeObjects(allObjects);
             showText( "", getWidth()/2, getHeight()/2 );
             showText("You Killed a Wild Animal",getWidth()/2,getHeight()/2 + 26);
             Greenfoot.stop(); 
        }
    }
}
