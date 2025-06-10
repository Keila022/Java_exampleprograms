import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * The TreeViewSample4 class extends Application and sets up the primary stage
 * with a scene containing the TreePane4 component.
 */
public class TreeViewSample4 extends Application {

    /**
     * The main entry point for all JavaFX applications.
     * This method is called when the application is launched.
     *
     * @param primaryStage the primary stage for this application
     */
    @Override
    public void start(Stage primaryStage) {
        //--------------------------------------------------------------------
        // Set up the scene with TreePane4 and configure the stage
        //--------------------------------------------------------------------
        Scene scene = new Scene(new TreePane4(), 400, 800);
        scene.setFill(Color.LIGHTGRAY);
        primaryStage.setTitle("Tree View Sample4");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main method is ignored in JavaFX applications.
     * main() serves only as fallback in case the application is launched
     * as a regular Java application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //--------------------------------------------------------------------
        // Launch the JavaFX application
        //--------------------------------------------------------------------
        launch(args);
    }
}

