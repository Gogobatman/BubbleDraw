package sliski.joe.industry;

import javax.swing.*;

public class Main2 extends JFrame {
    Funkcjonalnosc f=new Funkcjonalnosc();
    public Main(){
        add(f);
        setSize(600,600);
        setVisible(true);
    }
    public static void main(String[] args) {
    Main m = new Main();
    }
}
