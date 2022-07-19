import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;


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

    public void displayScores() {
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(Font.font("Helvetica", FontWeight.BOLD, 40));
        gc.setFill(Color.WHITE);
        gc.fillText(playerScore + "\t\t\t\t\t" + computerScore, Game.SCREEN_WIDTH/2, Game.SCREEN_HEIGHT/4);   // string and x and y position
        System.out.println(playerScore + " : " + computerScore);
    }
}
