import java.awt.*;
class Flow extends Frame{
	Flow(){
		Button b1 = new Button("NORTH");
		Button b2 = new Button("WEST");
		Button b3 = new Button("EAST");
		Button b4 = new Button("SOUTH");
		Button b5 = new Button("CENTER");

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		setSize(500, 500);
		setVisible(true);
	}
	public static void main(String arg[]){
		new Flow();
	}
}
