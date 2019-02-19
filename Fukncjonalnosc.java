package sliski.joe.industry;

import java.util.Random;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.*;


public class Funkcjonalnosc extends JPanel implements MouseListener {
    Random rand = new Random();
    ArrayList<Punkt> listaPunktow;
    public void paintComponent(Graphics canvas){
        super.paintComponent(canvas);
        for(Punkt b: listaPunktow){
            b.draw(canvas);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        listaPunktow.add(new Punkt(e.getX(),e.getY(),Color.BLUE,20));
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }

    public Funkcjonalnosc(){
        listaPunktow = new ArrayList<Punkt>();
        addMouseListener(this);
        addMouseMotionListener(new Listener());

        test();
    }
    private class Listener extends  MouseAdapter{

        @Override
        public void mouseDragged(MouseEvent e) {
            listaPunktow.add(new Punkt(e.getX(),e.getY(),Color.CYAN,20));
            repaint();
        }
        @Override
        public void mouseClicked(MouseEvent e) {
        }

    }
    public void test(){
        for(int i=0;i<100; i++){
            int wspolrzednaIKS=rand.nextInt(400);
            int wspolrzednaIGREK=rand.nextInt(400);
            Color color= new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
            listaPunktow.add(new Punkt(wspolrzednaIKS,wspolrzednaIGREK,color,20));
        }
        repaint();
    }
    public class Punkt{
        private int wspolrzednaX;
        private int wspolrzednaY;
        private int rozmiar;
        private Color color;
        public Punkt(int wspolrzednaX, int wspolrzednaY,Color color,int rozmiar){
            this.wspolrzednaX=wspolrzednaX;
            this.wspolrzednaY=wspolrzednaY;
            this.color=color;
            this.rozmiar=rozmiar;
        }
        public void draw(Graphics canvas){
            canvas.setColor(color);
            canvas.fillRect(wspolrzednaX-rozmiar/2, wspolrzednaY-rozmiar/2,rozmiar, rozmiar);
        }
    }

}
