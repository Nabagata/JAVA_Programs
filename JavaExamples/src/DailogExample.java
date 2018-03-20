import java.awt.*;
import java.awt.event.*;

class Dail extends Dialog implements ActionListener{
	TextField tf;
	Button b1;
	DailogExample obj;

	Dail(Frame f)
	{
		super(f,"Password Verify",Dialog.ModalityType.DOCUMENT_MODAL);
		b1 = new Button("Check");
		tf = new TextField(10);
		b1.addActionListener(this);
		setLayout(new FlowLayout());
		add(tf);
		add(b1);
		setSize(300, 100);		
	}
	public void pause(){
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		
		obj.verify(tf.getText());
	}
	public void obje(DailogExample obj){
		this.obj = obj;
	}

}

class DailogExample extends Frame implements ActionListener
{
	Dail d;
	Label l;
	DailogExample(){

		d = new Dail(this);
		
		Button b = new Button("Password");
		l = new Label();
		l.setBackground(Color.yellow);
		l.setForeground(Color.red);
		l.setText("Enter");
		b.addActionListener(this);	
		add(b, BorderLayout.NORTH);
		add(l, BorderLayout.SOUTH);
		setSize(500,500);
		setTitle("Dialog Example");
		setVisible(true);
	
	}
	public void actionPerformed(ActionEvent e){
		d.obje(this);
		d.pause();
	}
	
	public static void main(String ar[]){

		new DailogExample();
	}
	public void verify(String pw){

		if(pw.equals("oop")){
			l.setText("Valid Password");
			d.setVisible(false);
			setVisible(true);
		}
		else{
			l.setText("InValid Password");
			setVisible(true);
			
		}
	}

}
