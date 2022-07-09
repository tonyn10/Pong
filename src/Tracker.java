public class Tracker {

    private Player player;
    private ComputerPlayer computer;
    private Ball ball;

    public Tracker(Player p, ComputerPlayer c, Ball b) {
       player = p;
       computer = c;
       ball = b;
    }

    // returns 0: no one earns point
    // returns 1: human player earns point
    // returns 2: computer player earns point
    public int getState() {

        if(ball.getX() >= Constants.SCREEN_WIDTH-Constants.PADDLE_WIDTH) {
            // inside borders of player paddle
            if(ball.getY()+Constants.BALL_HEIGHT/2 >= computer.getY()
                    && ball.getY() <= computer.getY()+Constants.PADDLE_HEIGHT) {

                ball.reverseXSpeed();
            }
            else {
                return 1;
            }
        }

        if(ball.getX() <= Constants.PADDLE_WIDTH) {
            // inside borders of computer paddle
            if(ball.getY()+Constants.BALL_HEIGHT/2 >= player.getY()
                    && ball.getY()+Constants.BALL_HEIGHT/2 <= player.getY()+Constants.PADDLE_HEIGHT) {

                ball.reverseXSpeed();
            }
            else {
                return 2;
            }
        }

        // out of bounds vertically
        if(ball.getY() < 0 || ball.getY() > Constants.SCREEN_HEIGHT-Constants.BALL_HEIGHT) {
            ball.reverseYSpeed();
            computer.reverseYSpeed();
        }

        // TODO: change up speed/angle of ball trajectory after a few rallies

        return 0;
    }

}
