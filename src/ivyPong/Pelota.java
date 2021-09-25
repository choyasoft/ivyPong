package ivyPong;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Pelota {
    private static final int DIAMETER = 30;
    int x = 0;
    int y = 0;
    int xa = 2;
    int ya = 2;
    private final Game game;

    public Pelota(Game game) {
        this.game= game;
    }

    void move() {
        if (x + xa < 0)
            xa = 2;
        if (x + xa > game.getWidth() - DIAMETER)
            xa = -2;
        if (y + ya < 0)
            ya = 2;
        if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        if (collision()){
            ya = -2;
            y = game.raqueta.getTopY() - DIAMETER;
        }
        x = x + xa;
        y = y + ya;
    }

    private boolean collision() {
        return game.raqueta.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}