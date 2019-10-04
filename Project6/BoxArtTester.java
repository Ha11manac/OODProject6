/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project6;

import java.net.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author pokem
 */
public class BoxArtTester {
    GameBoxParts gameBoxParts;
    JFrame frame = new JFrame("Box Art Library");
    JMenuBar menuBar;
    JMenu menu;
    Hashtable<String, String> games = new Hashtable<String, String>();
    
    URL getGameUrl(String name){
        try{
            return new URL((String)games.get(name));
        }
        catch (MalformedURLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public BoxArtTester() throws Exception{
        //place to add new games
        games.put("Super Smash Bros", "https://m.media-amazon.com/images/I/81aJ-R4E6gL._AC_UY218_ML3_.jpg");
        games.put("Mario Kart 8 Deluxe", "https://m.media-amazon.com/images/I/91KQmjDxj-L._AC_UY218_ML3_.jpg");
        games.put("Breath of the Wild", "https://m.media-amazon.com/images/I/511M6ML2t7L._AC_UY218_ML3_.jpg");
        
        
        URL initialURL = new URL((String)games.get("Mario Kart 8 Deluxe"));
        menuBar = new JMenuBar();
        menu = new JMenu("Game Library");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        
        for (Enumeration<String> e = games.keys(); e.hasMoreElements();) {
            String name = (String)e.nextElement();
            JMenuItem menuItem = new JMenuItem(name);
            menu.add(menuItem); 
            menuItem.addActionListener(event -> {
                gameBoxParts.setCover(new GameBoxProxy(getGameUrl(event.getActionCommand())));
                frame.repaint();
            });
        }

        // set up frame and menus

        Icon icon = new GameBoxProxy(initialURL);
        gameBoxParts = new GameBoxParts(icon);
        frame.getContentPane().add(gameBoxParts);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets size of window
        frame.setSize(600,400);
        frame.setVisible(true);
        
    }
    
    public static void main(String[] args) throws Exception {
        BoxArtTester test = new BoxArtTester();
    }
    
}
