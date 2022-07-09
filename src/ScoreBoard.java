import javafx.scene.canvas.GraphicsContext;

public class ScoreBoard {

    private GraphicsContext gc;

    private int playerScore;
    private int computerScore;

    public ScoreBoard(GraphicsContext gc) {
        this.gc = gc;

        playerScore = 0;
        computerScore = 0;
    }

    public boolean isFinished() {
        // one player has to win by two points if both players' points are above 10 (deuce situation)
        if(playerScore >= 11 && playerScore >= computerScore+2) {
            System.out.println("Player 1 (Human) wins!");
            return true;
        }
        if(computerScore >= 11 && computerScore >= playerScore+2) {
            System.out.println("Player 2 (Computer) wins!");
            return true;
        }
        return false;
    }

    public void increasePlayerScore() {
        ++playerScore;
    }

    public void increaseComputerScore() {
        ++computerScore;
    }

    // TODO: display scores on screen, should be in the background
    public void displayScores() {
        System.out.println(playerScore + " : " + computerScore);
    }
}
