/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
/**
 *
 * @author NABAGATA SAHA
 */
public class SwingDemo {
    SwingDemo(){
        JFrame jfrm = new JFrame("A simple JAVA Swing application.");
        jfrm.setSize(275,100);
        jfrm.setDefaultCloseOperation(jfrm.EXIT_ON_CLOSE);
        
        JLabel jlab = new JLabel("Swing means powerful GUIs.");
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }
    
    public static void main(String args[]){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new SwingDemo();
            }
        });
    }
}
