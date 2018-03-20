import java.awt.*;
import java.awt.event.*;
class PanelExample extends Frame implements ActionListener{
	Panel p1, p2;
	PanelExample(){
	
		p1 = new Panel();
		p2 = new Panel();
		//p2.setVisible(false);
		p1.setBackground(Color.yellow);
		Button  b1 = new Button("Panel1");
		Button  b2 = new Button("Panel2");
		Button  b3 = new Button("Panel3");

		p1.add(b1);p1.add(b2);p1.add(b3);
		b1.addActionListener(this);
		Button  b4 = new Button("Panel4");
		Button  b5 = new Button("Panel5");
		Button  b6 = new Button("Panel6");
	
		p2.setLayout(new GridLayout());
		p2.add(b4);p2.add(b5);p2.add(b6);
		
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.SOUTH);
		//setExtendedState(ICONIFIED);
// Maximize window
		//setExtendedState(MAXIMIZED_BOTH);
		setSize(500,500);
		setVisible(true);		


	}
	public void actionPerformed(ActionEvent e){
		
		dispose();
		
		
	}

	public static void main(String ar[])
	{
		new PanelExample();
	}

}
