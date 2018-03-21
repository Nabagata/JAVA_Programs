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
public class JListDemo extends JFrame implements ActionListener  {
    JLabel jlab1,jlab2,jlab3;
    String departments[] = {"CSE","Biotech"};
    String sub1[] = {"OOP","SP"};
    String sub2[] = {"MB","Math"};
    JListDemo(){
        JFrame f = new JFrame();
        final JComboBox l1 = new JComboBox(departments);
        final JComboBox l2 = new JComboBox();
        
        jlab1=new JLabel("Select Department :");
        jlab2=new JLabel("Select Subjects :");
        jlab3=new JLabel("*Loading*");
        f.add(jlab1);
        f.add(l1);
        f.add(jlab2);
        
        l1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(l1.getSelectedItem().equals("CSE")){
                    l2.removeAllItems();
                    l2.addItem("OOP");
                    l2.addItem("SP");
                    
                }
                else if(l1.getSelectedItem().equals("Biotech")){
                     l2.removeAllItems();
                     l2.addItem("MB");
                     l2.addItem("Math");
        }
                //l2.addActionListener(this);
                //jlab3.setText("You're studying in "+l1.getSelectedItem()+" and have taken up "+l2.getSelectedItem()+" course.");
        }
        });
        l2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jlab3.setText("You're studying in "+l1.getSelectedItem()+" and have taken up "+l2.getSelectedItem() +" course.");
            }
        });
            
        f.add(l2);
        f.add(jlab3);
        f.setSize(500,500);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
    }
    /*public void actionPerformed(ActionEvent e){
        if(l1.getSelectedItem().equals("CSE")){
            l2.addItem(sub1);
        }
        if(l1.getSelectedItem().equals("Biotech")){
            l2.addItem(sub2);
        }
    }*/
    
    public static void main(String args[]){
        new JListDemo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
