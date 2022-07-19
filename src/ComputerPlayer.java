import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ComputerPlayer {

    private GraphicsContext gc;

    private double x;  // will stay constant
    private double y;

    private double ySpeed;

    public ComputerPlayer(GraphicsContext gc, double ballSpeed) {
        this.gc = gc;

        start(ballSpeed);
    }

    public void start(double ballSpeed) {
        // calculate initial speed for the computer based on the speed of the ball
        ySpeed = 0.9*ballSpeed; // 80% of the ballSpeed
        // TODO: find a way to make computer more fair

        x = Game.SCREEN_WIDTH-Game.PADDLE_WIDTH;
        y = Game.SCREEN_HEIGHT/2-Game.PADDLE_HEIGHT/2;

        // starting position of computer paddle
        gc.setFill(Color.WHITE);
        gc.fillRect(x, y, Game.PADDLE_WIDTH, Game.PADDLE_HEIGHT);
    }

    public void updateComputer() {
        // update position of computer paddle
        y += ySpeed;

        gc.setFill(Color.WHITE);
        gc.fillRect(x, y,
                Game.PADDLE_WIDTH, Game.PADDLE_HEIGHT);
    }

    public double getY() {
        return y;
    }

    public void reverseYSpeed() {
        ySpeed *= -1;
    }
}
