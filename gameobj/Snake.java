package gameobj;
import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList.*;
import java.util.random.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Snake extends JPanel implements ActionListener,KeyListener{
    private class Tile {
    int x;
    int y;
  
    Tile(int x,int y){
      this.x=x;
      this.y=y;
    }
    }
    int boardwint;
    int boardHight;
    int tileSize=25;
    //Snake
    Tile snakeHead;
    ArrayList<Tile> snakebody;
   //Food
     Tile food;
    Random random;

    //Logic 
    Timer gameloop;
    int velocityX;
    int velocityY;
    boolean gameOver=false;

    public Snake(int boardwint,int boardHight){
      this.boardwint=boardwint;
      this.boardHight=boardHight;
      setPreferredSize(new Dimension(this.boardwint,this.boardHight));
      setBackground(Color.BLACK);
     
      addKeyListener(this);
     setFocusable(true);
      //Snake
      snakeHead =new Tile(5, 5);
       snakebody= new ArrayList<>();
      //Food
       food =new Tile(10, 10);
       random=new Random();
       placeFood();
      //Game loop
        velocityX=0;
        velocityY=1;
       gameloop =new Timer(100,this);
       gameloop.start();
    }
    public void paintComponent(Graphics g){
      super.paintComponent(g);
      draw(g);
    }
    public void draw(Graphics g){

        for(int i=0;i<boardwint/tileSize;i++){
            //(x1,y1,x2,y2)
            g.drawLine(i*tileSize,0, i*tileSize, boardHight);
            g.drawLine(0, i*tileSize, boardwint, i*tileSize);
        }
        //Food
        g.setColor(Color.RED);
      g.fillRect(food.x*tileSize, food.y*tileSize,tileSize, tileSize);
        //Snake Haed
      g.setColor(Color.GREEN);
      g.fillRect(snakeHead.x*tileSize, snakeHead.y*tileSize,tileSize, tileSize);

      //Snake body
      for(int i = 0;i<snakebody.size();i++){
        Tile snakePart = snakebody.get(i);
        g.fillRect(snakePart.x*tileSize,snakePart.y*tileSize,tileSize,tileSize);
      }
    }

    public void placeFood(){
        food.x=random.nextInt(boardwint/tileSize);//600/24
        food.y=random.nextInt(boardHight/tileSize);
    }
     public boolean collision(Tile tile1,Tile tile2){
      return tile1.x==tile2.x&&tile1.y==tile2.y;
     }
    public void move(){
      if (collision(snakeHead, food)) {
        snakebody.add(new Tile(food.x, food.y));
        placeFood();
      }
      //Snake Body
      for(int i=snakebody.size()-1;i>=0;i--){
        Tile snakePart = snakebody.get(i);
        if (i==0){
          snakePart.x=snakeHead.x;
          snakePart.y=snakeHead.y;
        }else {
          Tile prevSnakePart = snakebody.get(i-1);
          snakePart.x=prevSnakePart.x;
          snakePart.y=prevSnakePart.y;
        } {
          
        }
      }

       //SnakeHaed
        snakeHead.x+=velocityX;
        snakeHead.y+=velocityY;

        //Game Over
        for(int i =0;i<snakebody.size();i++){
          Tile snakePart=snakebody.get(i);
          //colide with the snake head
          if (collision(snakeHead, snakePart)) {
             gameOver=true;
          }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       move();
       repaint();
       if (gameOver) {
        gameloop.stop();
       }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
     if (e.getKeyCode()==KeyEvent.VK_UP&& velocityY != 1) {
        velocityX=0;
        velocityY=-1;
     } else if (e.getKeyCode()==KeyEvent.VK_DOWN&& velocityY != -1) {
        velocityX=0;
        velocityY=1;
     } 
      else if (e.getKeyCode()==KeyEvent.VK_LEFT&& velocityX !=1) {
        velocityX=-1;
        velocityY=0;
     }  
     else if (e.getKeyCode()==KeyEvent.VK_RIGHT&& velocityX != -1) {
        velocityX=1;
        velocityY=0;
     }      
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
  }
  