/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NABAGATA SAHA
 */
public class CurrentThreadDemo {
    public static void main(String args[]){
        Thread t = Thread.currentThread();
        System.out.println("Current thread : "+ t);
        
        t.setName("My Thread");
        System.out.println("New thread : "+ t);
    }
}
