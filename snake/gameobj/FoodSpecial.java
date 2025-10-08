package gameobj;

import java.awt.*;
import java.util.Random;

public class FoodSpecial  {
    private Tile foodTile;
    private int boardWidth;
    private int boardHeight;
    private int tileSize;
    private Random random;
    public FoodSpecial(int boardWidth, int boardHeight, int tileSize) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.tileSize = tileSize;
   this.random =new Random();
   this.foodTile = new Tile(0, 0);
   placeFood();
    }
    public void placeFood() {
        int x = random.nextInt(boardWidth / tileSize);
        int y = random.nextInt(boardHeight / tileSize);
        foodTile.setX(x);
        foodTile.setY(y);
    }
    public Tile getFoodSpTile() {
        return foodTile;
    }

    public void drawFoodSpecial(Graphics g) {

        g.setColor(Color.orange);
        g.fillRect(foodTile.getX() * tileSize, foodTile.getY() * tileSize, tileSize, tileSize);
    }
}
