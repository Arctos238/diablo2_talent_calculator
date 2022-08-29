package d2tc.gui;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AssassinPage {
	private final String CLASS_NAME = "Amazon";
	private final CharacterPage characterPage;
	private Scene scene;
		
	public AssassinPage(Stage stage, Scene firstScene, String classIconUrl) {
		characterPage = new CharacterPage();
		
		//Load Default Settings for scene
		scene = characterPage.setDefaultScene(firstScene, stage, classIconUrl, CLASS_NAME);
		
		
		stage.setScene(scene);
	}
}
