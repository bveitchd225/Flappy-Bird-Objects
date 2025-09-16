import java.awt.*;

public class FlappyNO extends GBSGame {

    // Variables
    double fabyHeight = 285;
    double fabyVelocity = 0;

    public void setup() {

    }

    @Override
    public void update(double dt) {
        fabyVelocity += 981 * dt;
        fabyHeight += fabyVelocity*dt;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 400, 600);
        g.setColor(Color.YELLOW);
        g.fillRect(185, (int) fabyHeight, 30, 30);
    }

    public static void main(String[] args) {
        FlappyNO f = new FlappyNO();
        f.setResolution(400, 600);
        f.setFrameRate(30);
        f.createWindow();
        f.setup();
    }
}
