import java.awt.*;
import java.awt.event.*;

class AEvent extends Frame 
{
	TextField tf;
	AEvent(){
		tf = new TextField();
		tf.setBounds(60,50,170,20);
		add(tf);
		Button b = new Button("Click me");
		b.setBounds(100,120,80,20);
		add(b);
		b.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					tf.setText("Welcome to event handling");
				}}
					);
		setSize(500,500);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String arg[])
	{
		new AEvent();
	}
}
		
