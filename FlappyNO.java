import java.awt.*;

public class FlappyNO extends GBSGame {

    // Variables
    double fabyHeight = 285;
    double fabyVelocity = 0;

    double pipe1x = 400;
    double pipe1topy = 200;
    double pipe1bottomy = 400;

    double pipe2x = 600;
    double pipe2topy = 200;
    double pipe2bottomy = 400;

    double pipe3x = 800;
    double pipe3topy = 200;
    double pipe3bottomy = 400;

    boolean colliding = false;
    boolean gameOver = false;

    double score = 0;

    double base1x = 0;
    double base2x = 408;
    Image bird = super.getImage("assets/bird.png");
    Image topPipe = super.getImage("assets/top_pipe.png");
    Image bottomPipe = super.getImage("assets/bottom_pipe.png");
    Image background = super.getImage("assets/background.png");
    Image base = super.getImage("assets/base.png");

    public void setup() {

        int randomHeight = (int) (150 + Math.random()*(450-150+1));
        pipe1bottomy = randomHeight + 100;
        pipe1topy = randomHeight - 100;
        randomHeight = (int) (150 + Math.random()*(450-150+1));
        pipe2bottomy = randomHeight + 100;
        pipe2topy = randomHeight - 100;
        randomHeight = (int) (150 + Math.random()*(450-150+1));
        pipe3bottomy = randomHeight + 100;
        pipe3topy = randomHeight - 100;
    }

    @Override
    public void update(double dt) {

        if (super.keyPressed("r")) {
            fabyHeight = 285;
            fabyVelocity = 0;

            pipe1x = 400;
            pipe1topy = 200;
            pipe1bottomy = 400;

            pipe2x = 600;
            pipe2topy = 200;
            pipe2bottomy = 400;

            pipe3x = 800;
            pipe3topy = 200;
            pipe3bottomy = 400;

            int randomHeight = (int) (150 + Math.random()*(400-150+1));
            pipe1bottomy = randomHeight + 100;
            pipe1topy = randomHeight - 100;
            randomHeight = (int) (150 + Math.random()*(400-150+1));
            pipe2bottomy = randomHeight + 100;
            pipe2topy = randomHeight - 100;
            randomHeight = (int) (150 + Math.random()*(400-150+1));
            pipe3bottomy = randomHeight + 100;
            pipe3topy = randomHeight - 100;

            colliding = false;
            gameOver = false;
            score = 0;
        }

        if (gameOver) {
            return;
        }

        if (super.keyPressed("space")) {
            fabyVelocity = -300;
        }
        fabyVelocity += 9.81 * 60 * dt;
        fabyHeight += fabyVelocity*dt;

        pipe1x -= 120 * dt;
        if (pipe1x < -50) {
            pipe1x = 550;
            int randomHeight = (int) (150 + Math.random()*(400-150+1));
            pipe1bottomy = randomHeight + 100;
            pipe1topy = randomHeight - 100;
        }

        pipe2x -= 120 * dt;
        if (pipe2x < -50) {
            pipe2x = 550;
            int randomHeight = (int) (150 + Math.random()*(400-150+1));
            pipe2bottomy = randomHeight + 100;
            pipe2topy = randomHeight - 100;
        }

        pipe3x -= 120 * dt;
        if (pipe3x < -50) {
            pipe3x = 550;
            int randomHeight = (int) (150 + Math.random()*(400-150+1));
            pipe3bottomy = randomHeight + 100;
            pipe3topy = randomHeight - 100;
        }

        base1x -= 120*dt;
        if (base1x < -408) {
            base1x = 408;
        }
        base2x -= 120*dt;
        if (base2x < -408) {
            base2x = 408;
        }

        colliding = false;
        if (215 > pipe1x && 185 < pipe1x+50) {
            if (fabyHeight < pipe1topy) {
                colliding = true;
            }
            if (fabyHeight + 30 > pipe1bottomy) {
                colliding = true;
            }
        }
        if (215 > pipe2x && 185 < pipe2x+50) {
            if (fabyHeight < pipe2topy) {
                colliding = true;
            }
            if (fabyHeight + 30 > pipe2bottomy) {
                colliding = true;
            }
        }
        if (215 > pipe3x && 185 < pipe3x+50) {
            if (fabyHeight < pipe3topy) {
                colliding = true;
            }
            if (fabyHeight + 30 > pipe3bottomy) {
                colliding = true;
            }
        }
        if (colliding) {
            gameOver = true;
        }

        if (fabyHeight + 30 > 550) {
            gameOver = true;
        }

        score += 120 / 200.0 * dt;
        
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 400, 600);

        g.drawImage(background, 0, 0, this);
        g.setColor(Color.YELLOW);
        // if (colliding) {
        //     g.setColor(Color.RED);
        // }
        // g.fillRect(185, (int) fabyHeight, 30, 30);
        g.drawImage(bird, 183, (int) fabyHeight+3, this);

        g.setColor(Color.GREEN);
        // g.fillRect((int) pipe1x, (int) pipe1bottomy, 50, 500);
        // g.fillRect((int) pipe1x, (int) pipe1topy - 500, 50, 500);
        g.drawImage(topPipe, (int) pipe1x-1, (int) pipe1topy-500, this);
        g.drawImage(bottomPipe, (int) pipe1x-1, (int) pipe1bottomy, this);

        g.setColor(Color.GREEN);
        // g.fillRect((int) pipe2x, (int) pipe2bottomy, 50, 500);
        // g.fillRect((int) pipe2x, (int) pipe2topy - 500, 50, 500);
        g.drawImage(topPipe, (int) pipe2x-1, (int) pipe2topy-500, this);
        g.drawImage(bottomPipe, (int) pipe2x-1, (int) pipe2bottomy, this);

        g.setColor(Color.GREEN);
        // g.fillRect((int) pipe3x, (int) pipe3bottomy, 50, 500);
        // g.fillRect((int) pipe3x, (int) pipe3topy - 500, 50, 500);
        g.drawImage(topPipe, (int) pipe3x-1, (int) pipe3topy-500, this);
        g.drawImage(bottomPipe, (int) pipe3x-1, (int) pipe3bottomy, this);

        g.drawImage(base, (int) base1x, 550, this);
        g.drawImage(base, (int) base2x, 550, this);


        g.setColor(Color.BLACK);

        g.drawString("Score: " + (int) score, 10,30);

        if (gameOver) {
            g.drawString("Press r to play again", 150, 300);
        }
    }

    public static void main(String[] args) {
        FlappyNO f = new FlappyNO();
        f.setResolution(400, 600);
        f.setFrameRate(60);
        f.createWindow();
        f.setup();
    }
}