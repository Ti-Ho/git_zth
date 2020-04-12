package gui;

import javax.swing.*;
import java.io.*;
//SavingPositionThread.java
public class SavingPositionThread extends Thread {
    private JFrame f;
    File file = new File("D:/IDEAProjects/JAVAGUI/location.txt");
    SavingPositionThread(JFrame f){
        this.f = f;
    }
    public void run(){
        while(true){
            int x = f.getX();
            int y = f.getY();

            try(FileOutputStream fos = new FileOutputStream(file);
                DataOutputStream dos = new DataOutputStream(fos);
            ){
                dos.writeInt(x);
                dos.writeInt(y);
            }catch (Exception e){
                e.printStackTrace();
            }

            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
