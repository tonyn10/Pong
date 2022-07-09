import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player {

    private GraphicsContext gc;

    private double x;  // will stay constant
    private double y;

    public Player(GraphicsContext gc) {
        this.gc = gc;

        start();
    }

    public void start() {
        x = 0;
        y = Constants.SCREEN_HEIGHT/2 - Constants.PADDLE_HEIGHT/2;

        // player paddle starting position
        gc.setFill(Color.WHITE);
        gc.fillRect(x, y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);

        // TODO: fix teleportation of paddle when restarting set
        gc.getCanvas().setOnMouseMoved(e -> y = (int)e.getY());
    }

    public void updatePlayer() {
        gc.setFill(Color.WHITE);
        gc.fillRect(x, y, Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT);
    }

    public double getY() {
        return y;
    }
}
