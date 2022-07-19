import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Tracker {

    private Player player;
    private ComputerPlayer computer;
    private Ball ball;

    private final String paddleSoundFile = "";  // TODO: create m4a files
    private final String wallSoundFile = "";
    private final String scoreSoundFile = "";

    public Tracker(Player p, ComputerPlayer c, Ball b) {
       player = p;
       computer = c;
       ball = b;
    }

    // returns 0: no one earns point
    // returns 1: human player earns point
    // returns 2: computer player earns point
    public int getState() {

        MediaPlayer mediaPlayer;

        if(ball.getX() >= Game.SCREEN_WIDTH-Game.PADDLE_WIDTH) {
            // inside borders of player paddle
            if(ball.getY()+Ball.BALL_HEIGHT/2 >= computer.getY()
                    && ball.getY() <= computer.getY()+Game.PADDLE_HEIGHT) {

//                mediaPlayer = new MediaPlayer(new Media(new File(paddleSoundFile).toURI().toString()));
//                mediaPlayer.play();
                ball.reverseXSpeed();
            }
            else {
//                mediaPlayer = new MediaPlayer(new Media(new File(scoreSoundFile).toURI().toString()));
//                mediaPlayer.play();
                return 1;
            }
        }

        if(ball.getX() <= Game.PADDLE_WIDTH) {
            // inside borders of computer paddle
            if(ball.getY()+Ball.BALL_HEIGHT/2 >= player.getY()
                    && ball.getY()+Ball.BALL_HEIGHT/2 <= player.getY()+Game.PADDLE_HEIGHT) {

//                mediaPlayer = new MediaPlayer(new Media(new File(paddleSoundFile).toURI().toString()));
//                mediaPlayer.play();
                ball.reverseXSpeed();
            }
            else {
//                mediaPlayer = new MediaPlayer(new Media(new File(scoreSoundFile).toURI().toString()));
//                mediaPlayer.play();
                return 2;
            }
        }

        // out of bounds vertically
        if(ball.getY() < 0 || ball.getY() > Game.SCREEN_HEIGHT-Ball.BALL_HEIGHT) {
//            mediaPlayer = new MediaPlayer(new Media(new File(wallSoundFile).toURI().toString()));
//            mediaPlayer.play();

            ball.reverseYSpeed();
            computer.reverseYSpeed();
        }

        // TODO: change up speed/angle of ball trajectory after a few rallies

        return 0;
    }

}
