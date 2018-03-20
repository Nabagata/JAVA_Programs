package awt1;
import java.awt.*;
import java.awt.event.*;


/* 

    To close the Window :
    btn1.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e)
        {
            dispose();
        }
    });

    All Buttons, Labels, TextFields etc. are sub-class of Component.
    
    -- TextField/ TextArea()
        Constructor : TextField()/ TextArea()
        Methods
            .getText()
            .setText()
    
    -- Label 
        Constructor : Label(), Label(String)
        Methods :
            .setText()
            .setAlignment(Label.CENTER/Label.RIGHT/Label.LEFT)

    -- Button
        Constructor : Button(), Button(String)
        Methods :
            .getLabel()
            .setLabel()

    -- Checkbox
        Constructor : Checkbox(), Checkbox(String Label), Checkbox(String, boolean)
        checkbox1.addItemListener(new ItemListener() {  
             public void itemStateChanged(ItemEvent e) { ... } });

    -- Choice 
        Constructor : Choice()
        Methods :
            .add(String)        
            .addActionListener()


    Methods List :
    -- All of these have correponding .get method
        .setSize(w, h)
        .setForeground(Color.GRAY) // Or WHITE, RED, BLACK ...
        .setBackground(Color.RED)
        .setFont(plainFont)
        .setBounds(x, y, w, h)
            
    -- Font Class
        Constructor : Font(String name, int style, int size)  
            -- style : Font.PLAIN, Font.BOLD, Font.Italic - Can add them (Font.BOLD + Font.Italic)
    
        Font plainFont = new Font("Serif", Font.PLAIN, 24);  

    -- Methods of Frame class
        .add(Component)
        .remove(Component)
        .setTitle(String)
        .setLayout(Layout)
        .setVisible(boolean)
        .setSize(w, h)
            

*/

class BasicOne extends Frame
{
    BasicOne()
    {
        Button b1 = new Button("One"); // "One" is displayed on the button
        b1.setBounds(100, 100, 60, 20);  // Sets x,y,w,h
        TextField tf = new TextField(); 
        tf.setBounds(200, 200, 60, 20);
        
        add(b1);            // Add comp. to Frame
        add(tf);
        setTitle("First"); // Sets title of the Frame
        setSize(500, 500); // Sets size of the Frame
        setLayout(null);
        setVisible(true);
        
        // Methods above belong to class Frame
        // If this class doesn't extend Frame we would do the following
        /*
            Frame obj = new Frame();
            obj.add(b1);
            ...
            obj.setTitle("First");
            obj.setVisible(true);
            ...
        */

    }
}

class BasicTwo extends Frame implements ActionListener 
{
    // ActionListener is an interface which provides event handling
    // To add event use :
    //  button.addActionListener(this);
    // When the button is pressed, the method `actionPerformed(ActionEvent)`
    // is called. We need to define the method in the class.
    /*
        @Override
        public void actionPerformed(ActionEvent e)
        {  ... }
    */
    
    // When you have multiple buttons and want to perform different functions when clicked :
    /*
        bt1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent E){...}
        });
    
        bt2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent E){...}
        });
    */
    
    TextField tf;
    Button bt;
    
    BasicTwo()
    {
        frameSetup();
        create();
    }
    
    public void frameSetup()
    {
        // Can do without `this.`, but autocomplete
        this.setTitle("Two");
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLayout(null);
    }        
   
    public void create()
    {
        tf = new TextField();
        bt = new Button("Click Me");
        tf.setBounds(100, 100, 60, 40);
        bt.setBounds(100, 200, 60, 50);
        bt.addActionListener(this); 
        add(tf);
        add(bt);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        tf.setText("Hey Caveman!");
    }
}

class BasicThree extends Frame implements ActionListener
{
    // Layouts (sub-Frame) specify neat positions on the Frame.
    // Which allows us to not manually set (x, y) - [w,h is normally default]
    // There are different types of Layout
    
    /*
        BorderLayout - divides Frame to NORTH, WEST, SOUTH, EAST, CENTER.
        It's the default. (When you don't specify anything - even null in setLayout()
        Further adding components to it overrides it.
        add(btn1, BorderLayout.NORTH); // NORTH etc. are static, final variables.
        ...
        setLayout(new BorderLayout());
    */

    /*
        GridLayout - Divides Frame into numbers of rectangles specified.
        Constructors : 
            GridLayout(), GridLayout(int noRows, int noCols), GridLayout(int noRows, int noCols, int horizontalGap, int verticalGap)
        The components are added in first-come first-serve basis.
    */

    /*
        FlowLayout - Starts appending components from left->right and aligns them based on the constructor.
        Constructors : 
            FlowLayout(), FlowLayout(int align), FlowLayout(int aligh, int hGap, int vGap)
            Default align : FlowLayout.CENTER 
            Other align   : FlowLayout.LEFT, FlowLayout.RIGHT
        
        The order of buttons is in first-come first-serve basis. On the screen, they are aligned based on the align argument.
        eg. 
            bt1 = new Button("A");
            bt2 = new Button("B");
            bt3 = new Button("C");

            add(btn1);
            add(btn2);
            add(btn3);

    */

    /* CardLayout - Only one of the Components added is viewed at a time. Like a deck of cards.
        Constructors :
            CardLayout(), CardLayout(int hGap, int vGap)
        
        eg. 
            Frame frame = new Frame();
            CardLayout card = new CardLayout();
            frame.setLayout(card);
            card.next(frame); // ETC.

        Methods :
            Replace Frame by Container obj.

            .next(Frame) -> Displays the next object
            .previous(Frame)
            .first(Frame)
            .last(Frame)
            .show(Frame, String name) -> Display the Component w/ that name.

    */ 

    /* 
        GridBagLayout - It's like grid layout, but the user has control over the posision 
        of the Component, no. of celss occupied by it and the way it occupies the cell.

        It consists of 2 classes, `GridBagLayout` and `GridBagConstraints`. The later one alows us to control how Components
        are arranged.

        After setting the layout, the properties of `GridBagConstraints` are changed to affect propetrties.
        
        - You have to change each of the properties below before adding different components.
        - To change position, modify `gc.gridx`, `gc.gridy` before adding.
        - To change no. of cells occupied by Component, change `gc.gridwidth` before adding.
        - To change how it occupies the cell, change `gc.fill` before adding w/ 'GridBagConstraints.VERTICAL/HORIZONTAL'.

        IMP : See example below
    */           
            
    Button b1, b2, b3, b4, b5;
    CardLayout card;
    
    BasicThree()
    {
        frameSetup();
        create();
        gridBagLay();
    }
    public void frameSetup()
    {
        this.setTitle("Three");
        this.setSize(500, 500);
        this.setVisible(true);
    }
    public void create()
    {
        b1 = new Button("One");
        b2 = new Button("Two");
        b3 = new Button("Three");
        b4 = new Button("Four");
        b5 = new Button("Five");
    }
    public void borderLay()
    {
        this.setLayout(new BorderLayout());
        add(b1, BorderLayout.NORTH);
        add(b2, BorderLayout.WEST);
        add(b3, BorderLayout.EAST);
        add(b4, BorderLayout.SOUTH);
        add(b5, BorderLayout.CENTER);
    }
    public void gridLay()
    {
        this.setLayout(new GridLayout(5, 1));
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);    
    }

    public void flowLay()
    {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(b1);
        add(b2);
        add(b3);
    }

    public void cardLay()
    {  
        card = new CardLayout();
        setLayout(card);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }

    public void gridBagLay()
    {
        GridBagLayout gl = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();
        this.setLayout(gl);

        // To change position, modify `gc.gridx`, `gc.gridy` before adding.
        gc.gridx = 1;
        gc.gridy = 1;
        this.add(b1, gc);
        gc.gridx = 2;
        gc.gridy = 2;
        this.add(b2, gc);

        // To change no. of cells occupied by Component, change `gc.gridwidth` before adding.
        gc.gridwidth = 2;
        gc.gridx = 2;
        gc.gridy = 3;
        add(b3, gc);

        // To change how it occupies the cell, change `gc.fill` before adding w/ 'GridBagConstraints.VERTICAL/HORIZONTAL'.
        gc.fill = GridBagConstraints.VERTICAL;
        add(b4, gc);

    }

    public void actionPerformed(ActionEvent e)
    {
        card.next(this);
    }
        
}

class BasicFour extends Frame
{

    /*
        Panel - Like a div, where the Frame is the super div.

        eg.
        Panel p = new Panel();
        p.setVisible(true);
        p.setBackground(Color.GREY);
        p.setLayout(new GridLayout(4, 5));
        p.setBounds(x, y, w, h);
        p.add(btn1);
        this.add(p);

        Dialog Box - Like an alert box.
        Two ways of creation, using a sub class or creating usin an object.
        eg.
            
            Dialog d = new Dialog(Frame, String title);  
            d.setLayout(new GridLayout(1, 2));
            d.add(btn);
            d.setVisible(true)
            ...

            OR 

            class Box extends Dialog implements ActionListener
            {
                Box(Frame owner, __other_args__)
                {
                    super(owner);
                    ....
                    btn.addActionListener(this);
                    this.add(btn);
                }

                @Override
                public void actionPerformed(ActionEvent e)
                { dispose(); }
            }

            ... Frame Subclass :
            Box obj = new Box(this, output);

        Constructors :
            Dialog(Dialog owner, String title)
            Dialog(Frame owner, String title)
            Dialog(Window owner, String title)
            Dialog(Dialog owner)
            Dialog(Frame owner)
            Dialog(Window owner)

        Methods :
            .dispose()
            .getTitle() / .setTitle(String)
            .setLayout()
            .setVisible(boolean)
            .add(Component)

    */

    Button b1, b2, b3, b4, b5;
    Panel p = new Panel();
    
    public void frameSetup()
    {
        this.setTitle("Four");
        this.setSize(500, 500);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        p.setBounds(0, 0, 500, 100);
        p.setBackground(Color.BLACK);
        p.setVisible(true);
        p.setLayout(new GridLayout(1, 3));
        this.add(p, BorderLayout.SOUTH);
    }

    public void create()
    {
        b1 = new Button("One");
        b2 = new Button("Two");
        b3 = new Button("Three");
        b4 = new Button("Four");
        b5 = new Button("Five");
    }

    public void addtoPanel()
    {
        //b1.
        p.add(b1);
        p.add(b2);
        p.add(b3);
    }

    BasicFour()
    {
        frameSetup();
        create();
        addtoPanel();
        //gridLay();
    }
}

/*class BasicFive extends Frame implements ActionListener
{
    /*
        MenuBar : The class for the actual menubar. All `Menu` objects are added to it.
            Methods : 
                .add(Menu)
                .remove(int index) // Removes the Menu item at the index.

            
        Menu : The class which has all the objects which are displayed on the menu bar.
            Constructors :
                Menu(), Menu(String Label)
            Methods :
                .add(MenutItem)
                .add(String label)
                .insert(MenuItem menuitem, int index)
                .insert(String label, int index)
                .remove(int index)
                .remove(MenuComponent item)
                .insertSeparator(int index)
                .getItem(int index) // Returns MenuItem


        MenuItem : The pop-down shit you see when you click the `Menu` object.
            Constructors : 
                MenuItem(), MenuItem(String s), 
            Methods : 
                .addActionListener(ActionListener A)
                .getLabel() / .setLabel()
                .isEnabled() / .setEnabled()
    

/*
    Button b1, b2, b3, b4, b5;
    MenuBar mb;
    Menu f, e;

    public void prepareMenu()*/
   /* {
        mb = new MenuBar();
        f = new Menu();
        e = new Menu();
        mb.add(f);
        mb.add(e);

        f.addActionListener(this);
        f.add(new MenuItem("New"));
        f.add(new MenuItem("BooBoo"));
        e.add(new MenuItem("GooGoo"));
        e.add(new MenuItem("MooMoo"));


    }
    
}*/

public class AWT1 {
    public static void main(String[] args) {
        BasicThree obj = new BasicThree();
    }
    
}
