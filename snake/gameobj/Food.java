package gameobj;

import java.awt.*;
import java.util.Random;

public class Food {
    private Tile foodTile;
    private int boardWidth;
    private int boardHeight;
    private int tileSize;
    private Random random;

    public Food(int boardWidth, int boardHeight, int tileSize) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.tileSize = tileSize;
        this.random = new Random();
        this.foodTile = new Tile(0, 0);
        placeFood();
    }

    public void placeFood() {
        Tile newTile = RandomFood();
        foodTile.setX(newTile.getX());
        foodTile.setY(newTile.getY());
    }

    public Tile RandomFood() {
        int x = random.nextInt(boardWidth / tileSize);
        int y = random.nextInt(boardHeight / tileSize);
        return new Tile(x, y);
    }
    public Tile getFoodTile() {
        return foodTile;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(foodTile.getX() * tileSize, foodTile.getY() * tileSize, tileSize, tileSize);
    }
}
