import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
import java.awt.Color;
/**
 * Write a description of class TextBox here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class TextBox extends Actor
{
    private GreenfootImage img;
    private boolean border = false;
    private String text;
    private int fontSize;
    private Color foreground;
    private Color background;
    
    public TextBox( String message, int fs, boolean hasBorder, Color fg, Color bg )
    {
        fontSize = fs;
        border = hasBorder;
        foreground = fg;
        background = bg;
        text = message;
        
        img = new GreenfootImage( message, fontSize, foreground, background );
        
        display();
    }
    
    /**
     * display sets what the messages displayed will look like
     * 
     * @param there are no parameters
     * @return nothin is returned
     */
    public void display()
    {
        if( border == true )
        {
            img.setColor( Color.BLACK );
            img.drawRect( 0, 0, img.getWidth() - 1,img.getHeight() - 1 );
        }
        setImage( img );
    }
    
    /**
     * getText gets the text
     * 
     * @param there are no parameters
     * @return text that should be displayed at a given moment
     */
    public String getText()
    {
        return text;
    }
    
    /**
     * displays messages on the screen
     * 
     * @param message is equal to text
     * @return nothin is returned
     */
    public void setText( String message )
    {
        text = message;
        img = new GreenfootImage( text, fontSize, foreground, background );
        display();
    }
    
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}

