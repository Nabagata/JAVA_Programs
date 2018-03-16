/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author NABAGATA SAHA
 */
public class EventDemo {
    JLabel jlab;
    EventDemo(){
        
        JFrame jfrm = new JFrame("An Event Example");
        jfrm.setSize(220,90);
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(jfrm.EXIT_ON_CLOSE);
        
        JButton alpha = new JButton("Alpha");
        JButton beta = new JButton("Beta");
        
        alpha.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jlab.setText("Alpha is pressed.");
            }
        });
        
        beta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jlab.setText("Beta is pressed.");
            }
        });
        
        jlab = new JLabel("Press a button.");
        jfrm.add(alpha);
        jfrm.add(beta);
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }
    
    public static void main(String arg[]){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new EventDemo();
            }
        });
    }
}
