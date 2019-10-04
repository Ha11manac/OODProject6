/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project6;

import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JComponent;

/**
 *
 * @author pokem
 */
public class GameBoxParts extends JComponent {
   //not sure why i need this?
    private static final long serialVersionUID = 1L;
    private Icon cover;
    
    public GameBoxParts(Icon cover){
        this.cover = cover;
    }
    
    public void setCover(Icon cover){
        this.cover = cover;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = cover.getIconWidth();
        int h = cover.getIconHeight();
        //used to center image in window
        int x = (600 - w)/2;
        int y = (400 - h)/2;
        cover.paintIcon(this, g, x, y);
    }
    
}
