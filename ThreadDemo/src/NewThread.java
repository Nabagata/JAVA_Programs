/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NABAGATA SAHA
 */
public class NewThread implements Runnable  {
    
    Thread t;
    
    NewThread(){
        t = new Thread(this,"Demo Thread");
        System.out.println("Child Thread");
        t.start();
    }
    
    public void run(){
        try{
            for(int i=5;i>0;i--){
            System.out.println("Child Thread "+ i);
            Thread.sleep(500);
            }
        }
        catch(InterruptedException e){
            System.out.println("Child Thread Interrupted");
        }
        System.out.println("Child Thread terminated");
    }
    
    public static void main(String args[]){
        
    }
}
