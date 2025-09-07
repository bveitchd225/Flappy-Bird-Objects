import java.awt.*;

public class Flappy extends GBSGame {

    private Bird bird;

    private Pipe pipe1;
    private Pipe pipe2;
    private Pipe pipe3;

    private boolean gameOver;
    private double score;

    public Flappy() {
        super.setResolution(400,600);
        super.setFrameRate(60);
        super.createWindow();
        
        score = 0.0;

        bird = new Bird();

        pipe1 = new Pipe(400);
        pipe2 = new Pipe(600);
        pipe3 = new Pipe(800);
    }

    @Override
    public void update(double dt) {

        if (GBSGame.keyDown("r")) {
            // restart game
            bird = new Bird();

            pipe1 = new Pipe(400);
            pipe2 = new Pipe(600);
            pipe3 = new Pipe(800);

            gameOver = false;
            score = 0;
        }

        if (gameOver) {
            return;
        }

        score += 0.5*dt;

        bird.update(dt);

        pipe1.update(dt);
        pipe2.update(dt);
        pipe3.update(dt);

        // Check for collision with pipe1
        boolean colliding = false;

        if (pipe1.collidingWith(bird)) {
            colliding = true;
        }
        if (pipe2.collidingWith(bird)) {
            colliding = true;
        }
        if (pipe3.collidingWith(bird)) {
            colliding = true;
        }

        if (colliding || bird.isOffScreen()) {
            gameOver = true;
        }
    }

    @Override
    public void draw(Graphics g) {

        bird.draw(g);

        pipe1.draw(g);
        pipe2.draw(g);
        pipe3.draw(g);

        // Draw UI
        g.setColor(Color.BLACK);
        if (gameOver) {
            g.drawString("Press R to try again", 150, 300);
        }
        g.drawString("Score: " + (int) score, 10, 50);
    }

    public static void main(String[] args) {
        new Flappy();
    }
}