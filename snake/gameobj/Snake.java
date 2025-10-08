
package gameobj;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Snake extends JPanel implements ActionListener, KeyListener {

    private int border;
    private int tile;
    private int t=1;
    String playerName;

    
    int tileSize = 25;//ขนาด 1 ช่อง (ตาราง)

    // Snake
    Tile snakeHead;//หัวงู
    ArrayList<Tile> snakeBody;//ลำตัวงู

    //Food
    Food food;
    FoodSpecial foodSpecial;
    // Logic
    Timer gameLoop;
    int velocityX;
    int velocityY;
    boolean gameOver = false;

    public Snake(int border, int tile) {
        
        this.border = border;
        this.tile = tile;
        
        setBackground(Color.BLACK);
        
        addKeyListener(this);
        setFocusable(true);

        // Snake
        snakeHead = new Tile(5, 5);//เริ่มตำแหน่งหัวงู
        snakeBody = new ArrayList<>();//ตัวงู

        // Food
        food = new Food(border, border, tileSize);
        foodSpecial = new FoodSpecial(border, border, tileSize);

        
        // Game loop
        velocityX = 0;
        velocityY = 1;//งูเริ่มต้นขยับลงล่าง
        gameLoop = new Timer(100, this);
        gameLoop.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        

        if (gameOver) {
            drawgameover(g);
        }else{
            draw(g);
        }

        
    }
        
    

    private void drawgameover(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Monospaced", Font.BOLD, 40));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (border - metrics.stringWidth("GAME OVER")) / 2, border / 2);
    }
    

    public void draw(Graphics g) {//การวาด
                 // Draw food
        food.draw(g);
        foodSpecial.drawFoodSpecial(g);

        // Draw snake head
        g.setColor(Color.GREEN);//วาดหัวงู
        g.fillRect(snakeHead.x * tileSize, snakeHead.y * tileSize, tileSize, tileSize);

        // Draw snake body
        for (Tile part : snakeBody) {//วาดตัวงู
            g.fillRect(part.x * tileSize, part.y * tileSize, tileSize, tileSize);
        }


       
    }

    public boolean collision(Tile t1, Tile t2) {
        return t1.x == t2.x && t1.y == t2.y;
    }

    public void move() {
      //Food
        Tile foodTile = food.getFoodTile();
        Tile foodSPTile= foodSpecial.getFoodSpTile();
        if (collision(snakeHead, foodTile)) {
            snakeBody.add(new Tile(foodTile.getX(), foodTile.getY()));
            food.placeFood();
        } 
        if (collision(snakeHead, foodSPTile)) {
            snakeBody.add(new Tile(foodSPTile.getX(), foodSPTile.getY()));
                foodSpecial.placeFood();t++;}



        

        // Move snake body
        for (int i = snakeBody.size() - 1; i >= 0; i--) {//ย้ายงูตามตามหัว
            if (i == 0) {
                snakeBody.get(i).x = snakeHead.x;
                snakeBody.get(i).y = snakeHead.y;
            } else {
                snakeBody.get(i).x = snakeBody.get(i - (1+(t-1))).x;
                snakeBody.get(i).y = snakeBody.get(i - (1+(t-1))).y;
            }
        }

        // Move snake head
        snakeHead.x += velocityX;
        snakeHead.y += velocityY;

        int maxX = border / tile;
        int maxY = border / tile;

      // แนวนอน
    if (snakeHead.x < 0) {
        snakeHead.x = maxX-1;       // ออกซ้าย → ไปขวาสุด
    } else if (snakeHead.x >= maxX) {
        snakeHead.x = 0;                   // ออกขวา → ไปซ้ายสุด
    }

    // แนวตั้ง
    if (snakeHead.y < 0) {
        snakeHead.y = maxY-1;       // ออกบน → ไปล่างสุด
    } else if (snakeHead.y >= maxY) {
        snakeHead.y = 0;                   // ออกล่าง → ไปบนสุด
    }



        // Check collision with self
        for (Tile part : snakeBody) {//ถ้ากัดตัวเองGame Over
            if (collision(snakeHead, part)) {
                gameOver = true;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (gameOver) {
            gameLoop.stop();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && velocityY != t) {
            velocityX = 0;
            velocityY = -t;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && velocityY != -t) {
            velocityX = 0;
            velocityY = t;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && velocityX != t) {
            velocityX = -t;
            velocityY = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && velocityX != -t) {
            velocityX = t;
            velocityY = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // optional
    }
}


