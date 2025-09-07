import java.awt.*;

public class Bird {
    private double y;
    private double yvel;

    public Bird() {
        y = 200;
        yvel = 0;
    }

    public void update(double dt) {
        if (GBSGame.keyDown("space")) {
            yvel = -5;
        }

        // Move bird
        yvel += 8*dt;
        y += yvel;
    }

    public boolean isOffScreen() {
        return y < 0 || y > 600;
    }

    public double getY() {
        return y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(200,(int) y,30,30);
    }
}
