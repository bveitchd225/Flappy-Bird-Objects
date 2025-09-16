import java.awt.*;

public class FlappyNOSolution extends GBSGame {

    private double birdy;
    private double birdyvel;

    private double pipe1x;
    private double pipe1uppery;
    private double pipe1bottomy;

    private double pipe2x;
    private double pipe2uppery;
    private double pipe2bottomy;

    private double pipe3x;
    private double pipe3uppery;
    private double pipe3bottomy;

    private boolean gameOver;
    private double score;

    public FlappyNOSolution() {
        super.setResolution(400,600);
        super.setFrameRate(60);
        super.createWindow();

        score = 0.0;

        birdy = 300;
        birdyvel = 0;

        pipe1x = 400;
        int randomCenter = (int) (100 + Math.random() * (500 - 100 + 1));
        pipe1bottomy = randomCenter + 100;
        pipe1uppery = randomCenter - 100;
        
        pipe2x = 600;
        randomCenter = (int) (100 + Math.random() * (500 - 100 + 1));
        pipe2bottomy = randomCenter + 100;
        pipe2uppery = randomCenter - 100;
        
        pipe3x = 800;
        randomCenter = (int) (100 + Math.random() * (500 - 100 + 1));
        pipe3bottomy = randomCenter + 100;
        pipe3uppery = randomCenter - 100;
    }

    @Override
    public void update(double dt) {

        if (super.keyDown("r")) {
            // restart game
            birdy = 300;
            birdyvel = 0;

            pipe1x = 400;
            int randomCenter = (int) (100 + Math.random() * (500 - 100 + 1));
            pipe1bottomy = randomCenter + 100;
            pipe1uppery = randomCenter - 100;
            
            pipe2x = 600;
            randomCenter = (int) (100 + Math.random() * (500 - 100 + 1));
            pipe2bottomy = randomCenter + 100;
            pipe2uppery = randomCenter - 100;
            
            pipe3x = 800;
            randomCenter = (int) (100 + Math.random() * (500 - 100 + 1));
            pipe3bottomy = randomCenter + 100;
            pipe3uppery = randomCenter - 100;

            gameOver = false;
            score = 0;
        }

        if (gameOver) {
            return;
        }

        score += 0.5*dt;

        // Update Bird
        if (super.keyDown("space")) {
            birdyvel = -5;
        }
        birdyvel += 800*dt;
        birdy += birdyvel*dt;


        // Update pipe 1
        pipe1x -= 100*dt;
        if (pipe1x < -50) {
            pipe1x = 550;
            int randomCenter = (int) (100 + Math.random() * (500 - 100 + 1));
            pipe1bottomy = randomCenter + 100;
            pipe1uppery = randomCenter - 100;
        }

        // Update pipe 2
        pipe2x -= 100*dt;
        if (pipe2x < -50) {
            pipe2x = 550;
            int randomCenter = (int) (100 + Math.random() * (500 - 100 + 1));
            pipe2bottomy = randomCenter + 100;
            pipe2uppery = randomCenter - 100;
        }

        // Update pipe 3
        pipe3x -= 100*dt;
        if (pipe3x < -50) {
            pipe3x = 550;
            int randomCenter = (int) (100 + Math.random() * (500 - 100 + 1));
            pipe3bottomy = randomCenter + 100;
            pipe3uppery = randomCenter - 100;
        }

        // Check for collision with pipe1
        boolean colliding = false;

        // Is pipe 1 colliding with bird?
        if (birdy < pipe1uppery && 150 < pipe1x && pipe1x < 230) {
            colliding = true;
        }
        if (birdy + 30 > pipe1bottomy && 150 < pipe1x && pipe1x < 230) {
            colliding = true;
        }

        // Is pipe 2 colliding with bird?
        if (birdy < pipe2uppery && 150 < pipe2x && pipe2x < 230) {
            colliding = true;
        }
        if (birdy + 30 > pipe2bottomy && 150 < pipe2x && pipe2x < 230) {
            colliding = true;
        }

        // Id pipe 3 colliding with bird?
        if (birdy < pipe3uppery && 150 < pipe3x && pipe3x < 230) {
            colliding = true;
        }
        if (birdy + 30 > pipe3bottomy && 150 < pipe3x && pipe3x < 230) {
            colliding = true;
        }
        
        // Is bird colliding or off screen?
        // if (colliding || birdy > 600 || birdy < 0) {
        //     gameOver = true;
        // }

        if (birdy > 600) {
            System.out.println(score);
            gameOver = true;
        }
    }

    @Override
    public void draw(Graphics g) {

        // Draw Bird
        g.setColor(Color.RED);
        g.fillRect(200,(int)birdy,30,30);


        // Draw pipe 1
        g.setColor(Color.GREEN);
        g.fillRect((int) pipe1x, (int) pipe1uppery-500, 50, 500);
        g.fillRect((int) pipe1x, (int) pipe1bottomy, 50, 500);
        
        // Draw pipe 2
        g.setColor(Color.GREEN);
        g.fillRect((int) pipe2x, (int) pipe2uppery-500, 50, 500);
        g.fillRect((int) pipe2x, (int) pipe2bottomy, 50, 500);

        // Draw pipe 3
        g.setColor(Color.GREEN);
        g.fillRect((int) pipe3x, (int) pipe3uppery-500, 50, 500);
        g.fillRect((int) pipe3x, (int) pipe3bottomy, 50, 500);

        
        // Draw score
        g.setColor(Color.BLACK);
        if (gameOver) {
            g.drawString("Press R to try again", 150, 300);
        }
        g.drawString("Score: " + (int) score, 10, 50);
    }

    public static void main(String[] args) {
        new FlappyNOSolution();
    }
}