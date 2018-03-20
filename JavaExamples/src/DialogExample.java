import java.awt.*;
import java.awt.event.*;
class Dial extends Dialog implements ActionListener
{
	TextField tf;
	Button b1;
	DialogExample obj;
	Dial(DialogExample obj){
		
		super(obj, "Dialog Box", Dialog.ModalityType.DOCUMENT_MODAL);
		this.obj = obj;
		tf = new TextField(10);
		b1 = new Button("Check");
		b1.addActionListener(this);
		setLayout(new FlowLayout());
		add(tf);
		add(b1);
		setSize(300,100);

	}
	public void actionPerformed(ActionEvent e){
		obj.verify(tf.getText());
	}

}



class DialogExample extends Frame implements ActionListener
{
	Button b;
	Label l;
	Dial d;
	
	DialogExample(){
		d = new Dial(this);
		b = new Button("Password");
		l = new Label();
		l.setBackground(Color.yellow);
		l.setForeground(Color.red);
		l.setText("Enter Password");
		b.addActionListener(this);
		add(b, BorderLayout.NORTH);
		add(l, BorderLayout.SOUTH);
		setSize(500,500);
		setVisible(true);

	}
	public void actionPerformed(ActionEvent e){

		d.setVisible(true);
	}
	public void verify(String ar){
		if(ar.equals("oop")){
			l.setText("Valid Password");
			d.setVisible(false);
		}
		else
		{
			l.setText("InValid Password");
			d.tf.setText("");
		}
	}
	public static void main(String arg[]){
		new DialogExample();

	}







}
