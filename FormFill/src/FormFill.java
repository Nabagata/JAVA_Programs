/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formfill;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import javax.mail.*;
/**
 *
 * @author c167140
 */
class Dial extends Dialog {
    Label result;
    public Dial(Frame f){
        super(f);

    }
    public void meth(){
        result = new Label("Don't leave any blank text fields!");
        result.setBounds(30,30,170,20);
        add(result);
        setSize(500,200);
        setLayout(null);
        setVisible(true);
        setTitle("ERROR");
    }
}

class Dial2 extends Dialog {
    Label result;
    public Dial2(Frame f){
        super(f);

    }
    public void meth(){
        result = new Label("Thanks for submitting!");
        result.setBounds(30,30,170,20);
        add(result);
        setSize(500,200);
        setLayout(null);
        setVisible(true);
        setTitle("SUCCESS");
    }
}

class Dial3 extends Dialog {
    Label result;
    public Dial3(Frame f){
        super(f);

    }
    public void meth(){
        result = new Label("Enter valid Email Address.");
        result.setBounds(30,30,170,20);
        add(result);
        setSize(500,200);
        setLayout(null);
        setVisible(true);
        setTitle("ERROR");
    }
}

class Dial4 extends Dialog {
    Label result;
    public Dial4(Frame f){
        super(f);

    }
    public void meth(){
        result = new Label("Enter valid Phone number.");
        result.setBounds(30,30,170,20);
        add(result);
        setSize(500,200);
        setLayout(null);
        setVisible(true);
        setTitle("ERROR");
    }
}

public class FormFill extends Frame {
    TextField name,rno,email,sub,ph;
    Button reset,submit;
    Label n,r,e,s,p;
    Dial d; Dial2 d2; Dial3 d3; Dial4 d4;
    FormFill(){
        d=new Dial(this);
        d2=new Dial2(this);
        d3=new Dial3(this);
        d4=new Dial4(this);
        name=new TextField();
        ph=new TextField();
        p=new Label("PHONE NO :");
        rno=new TextField();
        email=new TextField();
        sub=new TextField();
        reset=new Button("RESET");
        submit=new Button("SUBMIT");
        n=new Label("NAME :");
        r=new Label("ROLL NUMBER :");
        e=new Label("EMAIL ID :");
        s=new Label("SUBJECT :");
        n.setBounds(30,40,80,20);
        r.setBounds(30,80,80,20);
        e.setBounds(30,120,80,20);
        s.setBounds(30,160,80,20);
        p.setBounds(30,200,80,20);
        name.setBounds(160,40,80,20);
        rno.setBounds(160,80,80,20);
        email.setBounds(160,120,80,20);
        sub.setBounds(160,160,80,20);
        ph.setBounds(160,200,80,20);
        reset.setBounds(65,240,80,20);
        submit.setBounds(65,280,80,20);
        add(name);
        add(rno);
        add(email);
        add(sub);
        add(reset);
        add(submit);
        add(ph);
        add(n);
        add(r);
        add(e);
        add(s);
        add(p);
        setSize(500,500);
        setLayout(null);
        setVisible(true);


        reset.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                name.setText(" ");
                rno.setText(" ");
                email.setText(" ");
                sub.setText(" ");
                ph.setText(" ");
            }

        });

        submit.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){

                if(checkLabel()){
                    if(!validEmail(email.getText()))
                        d3.meth();
                    if(!validPhone(ph.getText()))
                        d4.meth();
                    else d2.meth();
                }
                else

                    d.meth();
            }
        });

        name.setText(" ");
        sub.setText(" ");
        email.setText(" ");
        sub.setText(" ");
        ph.setText(" ");




    }

    /*public static boolean isValidEmaiID(String em){
        boolean result =true;
        try{
            InternetAddress emailAddr=new InternetAddress(em);
            emailAddr.validate();
        }
        catch(AddressException ex){
            result = false;
        }
        return result;
    }*/

    /*public static boolean isValidEmailID(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                            "^[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z] {2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if(email == null){
            return false;
        }
        return pat.matcher(email).matches();
    }*/

    public boolean validEmail(String em){
        for(int i=0;i<em.length();i++){
            if(em.charAt(i)=='@')
                return true;
        }
        return false;
    }

    public boolean validPhone(String ph){
        boolean flag;
        if(ph.length()==10) flag=true;
        else { flag=false; return flag;}
        for(int i=0;i<ph.length();i++){
            if(ph.charAt(i)>='0' && ph.charAt(i)<='9')
                flag=true;
            else flag=false;
        }
        return flag;
    }

    public boolean checkLabel(){
        //String em = email.getText();
        if((name.getText().isEmpty()) || (sub.getText().isEmpty()) || (rno.getText().isEmpty()) || (email.getText().isEmpty()))
            return false;

            //else if(isValidEmailID(em)) return false;

        else return true;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new FormFill();
    }

}
