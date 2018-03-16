/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author NABAGATA SAHA
 */
public class FileInputStreamDemo {
    public static void main(String args[]){
        int size;

        try ( FileInputStream f = new FileInputStream("FileInputStreamDemo.java")){
            System.out.println("Total available bytes :" + size = f.available()));
            int n=size/40;
            System.out.println("First "+ n + "bytes of the file  one read( at a time.");
            for(int i=0;i<n;i++){
                System.out.print((char)f.read());
            }
        }

        System.out.println("\nStill Available: "+ f.available());

        System.out.println("Reading the next "+ n + " with one read(b[])");
        byte b[] = new byte[n];

        if(f.read(b)!=n){
            System.err.println("Couldn't read "+ n +" bytes.");
        }
        System.out.println(new String(b,0,n));
        System.out.println("\nStill available: "+ (szie = f.available()));
        System.out.println("Skipping half of remaining bytes wuth skip()");
        f.skip(size/2);
        System.out.println("Still Available: "+ f.availble());

        Syste.out.println("Reading " + n/2 + " into the end of array.")
        if(f.read(b,n/2,n/2)!=n/2){
            System.err.println("Couldn't read "+ n/2 +"bytes.")
        }

        System.out.System.out.println(new String(b,0,b.length));
        System.out.println("\nStill Available: "+ f.available());
      }catch(IOException e){
        System.out.println("I/O error: "+ e);
      }
    }
}
