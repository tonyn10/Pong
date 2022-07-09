import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Game {

    private GraphicsContext gc;
    private Ball ball;
    private Player player;
    private ComputerPlayer computer;
    private Tracker tracker;
    private ScoreBoard scoreBoard;

    private boolean gameEnded;

    public Game(GraphicsContext gc) {
        this.gc = gc;

        ball = new Ball(gc);
        player = new Player(gc);
        computer = new ComputerPlayer(gc, ball.getYSpeed());
        tracker = new Tracker(player, computer, ball);
        scoreBoard = new ScoreBoard(gc);

        gameEnded = false;
    }

    public void run(boolean gameStarted) {
        if(gameStarted && !gameEnded) {

            // new black screen
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

            // restart positions
            if(tracker.getState() == 0) {
                ball.updateBall();
                computer.updateComputer();
                player.updatePlayer();
            }
            else {
                if(tracker.getState() == 1) {
                    scoreBoard.increasePlayerScore();
                }
                else {
                    scoreBoard.increaseComputerScore();
                }
                scoreBoard.displayScores();

                if(scoreBoard.isFinished()) {
                    Main.timeline.stop();
                    System.out.println("Click on the screen to exit.");
                    gc.getCanvas().setOnMouseClicked(e -> System.exit(1));
                }
                else {
                    ball.start();
                    player.start();
                    computer.start(ball.getYSpeed());

                    Constants.gameStarted = false;  // resets and waits for click to start again
                }
            }

        }
    }
}
