import java.awt.*;
import java.awt.event.*;

class GridBag 
{
	GridBagLayout grid;
	GridBagConstraints gbc;
	Frame f;
	GridBag()
	{
		f = new Frame();
		grid = new GridBagLayout();
		gbc = new GridBagConstraints();
		f.setLayout(grid);
		Button b1 = new Button("First");
		Button b2 = new Button("Second");
		Button b3 = new Button("Third");
		Button b4 = new Button("Four");
		Button b5 = new Button("Five");
		
		gbc.gridx = 0;
		gbc.gridy = 0;	
		gbc.gridheight = 4;
		//gbc.fill = GridBagConstraints.VERTICAL;
		f.add(b1, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;	
		
		f.add(b2, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;	
		
		f.add(b3, gbc);
		gbc.gridx = 3;
		gbc.gridy = 3;	
		
		f.add(b4, gbc);
	
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 4;	
		
		f.add(b5, gbc);
		
		

		f.setSize(500,500);
		f.setTitle("Card Layout Example");
		f.setVisible(true);
	}
	public static void main(String arg[]){
		new GridBag();
	}
}
