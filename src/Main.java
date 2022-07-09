import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    public static Timeline timeline;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        Canvas canvas = new Canvas(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        Game game = new Game(gc);

        // when play(), updates keyframe based on game.run() every 10 ms
        timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> game.run(Constants.gameStarted)));
        timeline.setCycleCount(Timeline.INDEFINITE);    // unlimited cycles

        canvas.setOnMouseClicked(e -> Constants.gameStarted = !Constants.gameStarted);

        stage.setTitle("Pong");
        stage.setScene(new Scene(new StackPane(canvas), Color.BLACK));
        stage.show();

        timeline.play();    // updates keyframe

    }

}