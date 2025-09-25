package gameobj;
//Class รับพิกัด
public class Tile {
    int x;
    int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

}

