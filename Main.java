package grazdobadznagrode;

import javax.swing.*;

public class Main extends JFrame {

    public Main(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        getContentPane().add(new BubblePanel());
        setVisible(true);

    }
    public static void main(String[] args) {
        Main main = new Main();
     }
}
