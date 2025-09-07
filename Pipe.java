import java.awt.*;

public class Pipe {
    private double x;
    private double uppery;
    private double bottomy;
    public Pipe(int initialX) {
        x = initialX;
        int randomCenter = (int) (100 + Math.random() * (500 - 100 + 1));
        bottomy = randomCenter + 100;
        uppery = randomCenter - 100;
    }

    public void update(double dt) {
        x -= 100*dt;
        if (x < -50) {
            x = 550;
            int randomCenter = (int) (100 + Math.random() * (500 - 100 + 1));
            bottomy = randomCenter + 100;
            uppery = randomCenter - 100;
        }
    }

    public boolean collidingWith(Bird bird) {
        if (bird.getY() < uppery && 150 < x && x < 230) {
            return true;
        }
        if (bird.getY() + 30 > bottomy && 150 < x && x < 230) {
            return true;
        }
        return false;
    }

    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int) x, (int) uppery-500, 50, 500);
        g.fillRect((int) x, (int) bottomy, 50, 500);
    }
}
