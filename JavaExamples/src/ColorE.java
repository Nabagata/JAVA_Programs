import java.awt.*;
import java.awt.event.*;

class ColorE extends Frame{

	TextField colorDesc;
	Panel colorField;
	Scrollbar redbar;
	Scrollbar greenbar;
	Scrollbar bluebar;
	Color current;

	ColorE(){
		colorDesc = new TextField();
		colorField = new Panel();
		redbar = new ColorBar(Color.red);
		greenbar = new ColorBar(Color.green);
		bluebar = new ColorBar(Color.blue);
		current = Color.black;	
	}
	public void disp(){
		setTitle("Color Test");
		setSize(400, 600);
		add(colorDesc, BorderLayout.NORTH);
		add(makeColorButtons(), BorderLayout.EAST);
		add(colorField, BorderLayout.CENTER);
		add(makeScrollBars(), BorderLayout.WEST);
		setFormColor(current);
		setVisible(true);
	
	}

	private void setFormColor (Color c)
	{

		current = c; 
		colorField.setBackground (current);
		redbar.setValue(c.getRed());
		greenbar.setValue(c.getGreen());
		bluebar.setValue(c.getBlue());
		colorDesc.setText(c.toString());
	}

	private void setFromBar(){

		int r = redbar.getValue();
		int g = greenbar.getValue();
		int b = bluebar.getValue();
		setFormColor(new Color(r, g, b));
	}

	private Panel makeColorButtons(){
		Panel p = new Panel();
		p.setLayout (new GridLayout(4, 4, 3, 3));
		p.add (new ColorButton(Color.blue,"Blue"));
		p.add (new ColorButton(Color.black,"Black"));
		p.add (new ColorButton(Color.cyan,"Cyan"));
		p.add (new ColorButton(Color.gray,"Gray"));
		p.add (new ColorButton(Color.yellow,"Yellow"));
		p.add (new ColorButton(Color.lightGray,"LightGray"));
		p.add (new ColorButton(Color.red,"Red"));
		p.add (new ColorButton(Color.green,"Green"));
		p.add (new ColorButton(Color.darkGray,"Dark Gray"));
		p.add (new ColorButton(Color.pink,"Pink"));
		p.add (new ColorButton(Color.white,"White"));
		p.add (new ColorButton(Color.orange,"Orange"));
		p.add (new ColorButton(Color.magenta,"Magenta"));
		return p;
		

	}
	private Panel makeScrollBars(){
		Panel p = new Panel();
		p.setLayout(new GridLayout());
		p.add(redbar);
		p.add(greenbar);
		p.add(bluebar);
		return p;
	}
	
	private class ColorBar extends Scrollbar implements AdjustmentListener{
		public ColorBar (Color c){

			super(Scrollbar.VERTICAL, 40, 0, 0, 255);
			setBackground(c);
			addAdjustmentListener (this);
		}
		public void adjustmentValueChanged (AdjustmentEvent e){
			setFromBar();
		
		}
	}
	private class ColorButton extends Button implements ActionListener
	{
		private Color ourColor;
		public ColorButton (Color c, String name){
			super(name);
			ourColor = c;
			addActionListener(this);	
		}
		public void actionPerformed (ActionEvent e){
			setFormColor (ourColor);
		}
	}
	public static void main(String ar[])
	{
		ColorE obj = new ColorE();
		obj.disp();
	}

}
