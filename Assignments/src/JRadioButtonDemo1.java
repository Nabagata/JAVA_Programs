/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author c167140
 */
public class JRadioButtonDemo1 extends JFrame implements ActionListener {
    
    JLabel jlab;
    JRadioButtonDemo1(){
        JFrame jfrm = new JFrame();
        jfrm.setLayout(new FlowLayout());
        JRadioButton b1 = new JRadioButton("Nabagata");
        b1.addActionListener(this);
        JRadioButton b2 = new JRadioButton("Saleel");
        b2.addActionListener(this);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(b1);
        bg.add(b2);
        
        jlab = new JLabel("Select any one.");
        
        jfrm.add(b1);
        jfrm.add(b2);
        jfrm.add(jlab);
        jfrm.setVisible(true);
        jfrm.setSize(300,300);
    }
    public void actionPerformed( ActionEvent ae){
          
                JOptionPane.showMessageDialog(this,ae.getActionCommand()+" is the best.");     
    }
    
    public static void main(String args[]){
        new JRadioButtonDemo1();
    }
         
}
