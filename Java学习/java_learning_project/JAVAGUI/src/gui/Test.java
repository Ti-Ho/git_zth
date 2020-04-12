package gui;

import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String args[]){
        HeroTableModel htm = new HeroTableModel();
        JTable t = new JTable(htm);
        final JFrame f = new JFrame("LoL");
        f.setSize(400, 300);
        f.setLocation(200, 200);
        f.setLayout(new BorderLayout());
        t.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane sp = new JScrollPane(t);
        f.add(sp,BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
