import java.awt.*;
import javax.swing.*;

public class JLabelDemo extends JApplet {
  public void init(){
    try{
      SwingUtilities.invokeAndWait(
        new Runnable(){
          public void run(){
            makeGUI();
          }
        }
      );
    }
    catch(Exception exc){
      System.out.println("Can't create because of "+exc);
    }
  }
  public void makeGUI(){

    ImageIcon ii = new ImageIcon("download.png");
    JLabel jl = new JLabel("Nabagata",ii,JLabel.CENTER);
    add(jl);
  }
}
