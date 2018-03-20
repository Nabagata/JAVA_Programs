/*
FileName:
Purpose:
Date:
Employee ID:
*/

import java.awt.*;
import java.awt.event.*;

class MenuEx extends Frame implements ActionListener
{
	MenuBar mb;
	Menu f, e;  //f file, e edit
	Label l;   //l output

	/*
	Method Name: MenuEx
	Description: initializing Global Variable
	Arguments: no arg
	Return Type: no return
	Date: 12 Feb 2018
	Employee Id: 0001

	*/
	MenuEx(){
		mb = new MenuBar ();
		f = new Menu ("File");
		e = new Menu("Edit");
		l = new Label("No Output");
		setMenuBar(mb);
		mb.add(f);
		mb.add(e);

		f.addActionListener(this);
		f.add(new MenuItem("New"));
		f.add(new MenuItem("Open"));
		f.add(new MenuItem("Save"));

		e.addActionListener(this);
		e.add(new MenuItem("Copy"));
		e.add(new MenuItem("Cut"));
		e.add(new MenuItem("Paste"));

		add(l, BorderLayout.SOUTH);

		addWindowListener(new WindowAdapter(){

			public void windowClosing(WindowEvent e){
				dispose();
			}
		});

		setSize(500,500);
		setVisible(true);

	}

	public void proc()
	{


		

	}
	public void actionPerformed(ActionEvent e){

		l.setText(e.getActionCommand());
		setExtendedState(NORMAL);
		setVisible(true);
	}
	public static void main(String ar[])
	{

		MenuEx obj = new MenuEx();
		//obj.proc();
	}

}
