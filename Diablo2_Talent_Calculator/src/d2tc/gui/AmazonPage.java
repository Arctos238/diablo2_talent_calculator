package d2tc.gui;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AmazonPage {
	private final String CLASS_NAME = "Amazon";
	private CharacterPage characterPage;
	private Scene scene;
		
	public AmazonPage(Stage stage, Scene firstScene, String classUrl) {
		characterPage = new CharacterPage();
		
		//Load Default Settings for scene
		scene = characterPage.setDefaultScene(firstScene, stage, classUrl, CLASS_NAME);
		
		
		stage.setScene(scene);
	}
}
