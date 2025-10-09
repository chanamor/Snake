package gameobj;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FoodSpecial  {
    private final List<Tile> foodTiles;
    private int boardWidth;
    private int boardHeight;
    private int tileSize;
    private Random random;
    private int count; // number of special food items

   
    public FoodSpecial(int boardWidth, int boardHeight, int tileSize) {
        this(boardWidth, boardHeight, tileSize, 5);
    }

    public FoodSpecial(int boardWidth, int boardHeight, int tileSize, int count) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.tileSize = tileSize;
        this.count = Math.max(1, count);
        this.random = new Random();
        this.foodTiles = new ArrayList<>();

        // initialize tiles
        for (int i = 0; i < this.count; i++) {
            foodTiles.add(new Tile(0, 0));
        }
        placeAllFoods();
    }

    // place a single food at random index
    public void placeFood(int index) {
        if (index < 0 || index >= foodTiles.size()) return;
        int x = random.nextInt(boardWidth / tileSize);
        int y = random.nextInt(boardHeight / tileSize);
        Tile t = foodTiles.get(index);
        t.setX(x);
        t.setY(y);
    }

    // place all foods randomly
    public void placeAllFoods() {
        for (int i = 0; i < foodTiles.size(); i++) {
            placeFood(i);
        }
    }

    // backward-compatible single-tile getter (returns first)
    public Tile getFoodSpTile() {
        return foodTiles.get(0);
    }

    // new API: get list of special food tiles
    public List<Tile> getFoodSpTiles() {
        return foodTiles;
    }

    public void drawFoodSpecial(Graphics g) {
        g.setColor(Color.orange);
        for (Tile t : foodTiles) {
            g.fillRect(t.getX() * tileSize, t.getY() * tileSize, tileSize, tileSize);
        }
    }
}
