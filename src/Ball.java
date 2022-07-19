import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball {

    private GraphicsContext gc;

    private double x;
    private double y;

    private double xSpeed;
    private double ySpeed;

    public static final int BALL_WIDTH = 12;
    public static final int BALL_HEIGHT = 12;


    public Ball(GraphicsContext gc) {
        this.gc = gc;

        start();
    }

    public void start() {
        x = Game.SCREEN_WIDTH/2 - Ball.BALL_WIDTH/2;
        y = Game.SCREEN_HEIGHT/2 - Ball.BALL_HEIGHT/2;

        gc.setFill(Color.WHITE);
        // parameters: x y positions, width height
        gc.fillOval(x, y, Ball.BALL_WIDTH, Ball.BALL_HEIGHT);

        int xDirection = 1;
        if((int)(Math.random()*10)%2 == 0) {   // 50 50 chance number is even
            xDirection *= -1;
        }

        int yDirection = 1;
        if((int)(Math.random()*10)%2 == 0) {   // 50 50 chance number is even
            yDirection *= -1;
        }

        xSpeed = 5 * xDirection;
        ySpeed = 2.5 * yDirection;
    }

    public void updateBall() {
        x += xSpeed;
        y += ySpeed;

        gc.setFill(Color.WHITE);
        // parameters: x y positions, width height
        gc.fillOval(x, y, Ball.BALL_WIDTH, Ball.BALL_HEIGHT);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(double newSpeed) {
        ySpeed = newSpeed;
    }

    public void setXSpeed(double newSpeed) {
        xSpeed = newSpeed;
    }

    public void reverseXSpeed() {
        xSpeed *= -1;
    }

    public void reverseYSpeed() {
        ySpeed *= -1;
    }


}
