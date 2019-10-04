/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project6;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author pokem
 */
public class GameBoxProxy implements Icon{
    volatile ImageIcon gameBox;
    final URL boxURL;
    Thread retrievalThread;
    boolean retrieving = false;
    
    public GameBoxProxy(URL url){
        boxURL = url;
    }
    
    synchronized void setImageIcon(ImageIcon gameBox){
        this.gameBox = gameBox;
    }
    

    @Override
    public void paintIcon(final Component c, Graphics g, int x, int y) {
        if(gameBox != null){
            gameBox.paintIcon(c, g, x, y);
        }
        else{
            //x and y decides wher text in window goes
            g.drawString("Getting Game Box...", x+200, y+190);
                    if(!retrieving){
                        retrieving = true;
                        retrievalThread = new Thread(() -> {
                            try{
                                setImageIcon(new ImageIcon(boxURL, "Box Art"));
                                c.repaint();
                            }
                            catch (Exception e){
                                e.printStackTrace();
                            }
                        });
                        retrievalThread.start();
                    }            
        }
    }

    @Override
    public int getIconWidth() {
        if (gameBox != null){
            return gameBox.getIconWidth();
        }
        else{
            return 800;
        }
    }

    @Override
    public int getIconHeight() {
        if (gameBox != null){
            return gameBox.getIconHeight();
        }
        else{
            return 600;
        }
    }
    
}
