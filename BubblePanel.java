package grazdobadznagrode;
import java.util.Random;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.*;

public class BubblePanel extends JPanel {
    Random random= new Random();
    ArrayList<Bubble> bubbleList;
    int size=25;
    public void paintComponent(Graphics canvas){
        super.paintComponent(canvas);
        for(Bubble b: bubbleList){
            b.draw(canvas);
        }
    }
    public void testBubbles(){
        for(int n=0; n<100; n++){
            int x= random.nextInt(600);
            int y= random.nextInt(400);
            int size = random.nextInt(50);
            bubbleList.add(new Bubble(x,y,size));
        }
        repaint();
    }

    public BubblePanel(){
        bubbleList = new ArrayList<Bubble>();
        setBackground(Color.BLACK);
       // testBubbles();
        addMouseListener(new BubbleListener());
        addMouseMotionListener(new BubbleListener());
    }

    private class Bubble{
        private int x;
        private int y;
        private int size;
        private Color color;
        public Bubble(int newX, int newY, int newSize){
            x=newX;
            y=newY;
            size=newSize;
            color= new Color(random.nextInt(256), random.nextInt(256),random.nextInt(256));
        }
        public void draw(Graphics canvas){
            canvas.setColor(color);
            canvas.fillOval(x-size/2, y-size/2, size, size);
        }
    }
    private class BubbleListener extends  MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
           bubbleList.add(new Bubble(e.getX(),e.getY(),size));
           repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            bubbleList.add(new Bubble(e.getX(),e.getY(),size));
            repaint();
        }
        @Override
        public void mouseClicked(MouseEvent e) {
        }

    }

}
