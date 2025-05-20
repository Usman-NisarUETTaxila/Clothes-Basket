package main;

import javafx.animation.PauseTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

public class LoadingWindow {
	private Main main;
	private final int button_size = 75;
	private boolean is_login;
	
	public LoadingWindow(Main main, boolean login) {
		this.main = main;
		is_login = login;
	}
	
	public Parent getPane() {
        StackPane loadingPane = new StackPane();
        ProgressIndicator indicator = new ProgressIndicator();
        indicator.setStyle("-fx-progress-color: #FFD300;");
        Label status = new Label();
        loadingPane.getChildren().add(indicator);
        BackgroundImage home_image = new BackgroundImage(
    			new Image("file:/F:/Java/Clothes Basket/imgs/bg.png"), 
    			BackgroundRepeat.NO_REPEAT,
    			BackgroundRepeat.NO_REPEAT,
    			BackgroundPosition.CENTER,
    			new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
    			);

        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(event -> {
        	if(is_login)
        		main.switchToMainWindow();
        	else {
        		Scene scene = new Scene(new LogIn(main).getLogIn(), 800, 600);
                main.getStage().setScene(scene);
        	}
        });
        pause.play();
        loadingPane.setBackground(new Background(home_image));
		return loadingPane;
	}
}
