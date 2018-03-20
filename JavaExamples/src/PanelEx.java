import java.awt.*;
import java.awt.event.*;
class PanelEx extends Frame implements ActionListener
{
	TextField tf;
	Label l ;
	Panel p1, p2;
	PanelEx(){

		p1 = new Panel();
		p2 = new Panel();
		Button b1 = new Button("Click me1");
		//Button b2 = new Button("Click me2");
		tf = new TextField(10);
		l = new Label();
		b1.addActionListener(this);
		

		p1.add(tf);
		p1.add(b1);
		
		p2.add(l);
		p1.setVisible(true);
		p2.setVisible(false);
	

		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.SOUTH);
		setSize(500,500);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
	
		l.setText(tf.getText());
		p1.setVisible(false);
		p2.setVisible(true);
		setVisible(true);

	}
	public static void main(String arf[])
	{
		new PanelEx();
	}
}
