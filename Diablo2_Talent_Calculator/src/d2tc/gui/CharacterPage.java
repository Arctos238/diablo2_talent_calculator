package d2tc.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CharacterPage {
	private final String SKILL_BACKGROUND_IMG_URL = "file:///E:/Programming/Code/Java/Diablo2_Talent_Calculator/res/backgrond_imgs/skill_background.jpg";
	private final String TREE_BACKGROUND_IMG_URL = "file:///E:/Programming/Code/Java/Diablo2_Talent_Calculator/res/backgrond_imgs/tree_background.jpg";
	private final String FONT_URL = "file:///E:/Programming/Code/Git/D2R_Calculator/Diablo2_Talent_Calculator/res/fonts/exocet_regular.ttf";
	private final int BACKGROUND_WIDTH = 1250;
	private final int BACKGROUND_HEIGHT = 900;
	private final int SKILL_BACKGROUND_WIDTH = 350;
	private final int SKILL_BACKGROUND_HEIGHT = 550;
	private Background treeBackground;
	private Button backButton;

	public Scene setDefaultScene(Scene firstScene, Stage stage, String classIconUrl, String className) {
		
		Background skillBackground = createImgBackground(SKILL_BACKGROUND_IMG_URL);
		Background colorBackground = treeBackground = createImgBackground(TREE_BACKGROUND_IMG_URL);

		Pane centerLeftPane = cratePane(95);
		Pane centerPane = cratePane(450);
		Pane centerRightPane = cratePane(805);

		Button backButton = createBackButton(firstScene, stage);
		
		Pane root = new Pane();
		//root.setBackground(skillBackground);
		root.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		root.getChildren().addAll(centerLeftPane, centerPane, centerRightPane, backButton);
		
		
		displayClassIcon(classIconUrl, root, className);
		
		Scene scene = new Scene(root, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, Color.BLACK);
		return scene;
	}

	public Pane cratePane(int xPos) {
		Pane pane = new Pane();
		pane.setTranslateX(xPos);
		pane.setTranslateY(210);
		pane.setMinWidth(SKILL_BACKGROUND_WIDTH);
		pane.setMinHeight(SKILL_BACKGROUND_HEIGHT);
		pane.setMaxWidth(SKILL_BACKGROUND_WIDTH);
		pane.setMaxHeight(SKILL_BACKGROUND_HEIGHT);
		pane.setBackground(treeBackground);
		pane.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		return pane;
	}

	public Background createColorBackground(Color color) {
		Background background = new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY));

		return background;
	}

	public Background createImgBackground(String url) {
		Background background;
		Image bimg = new Image(url);
		BackgroundImage backgroundImg = new BackgroundImage(bimg, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(1.0, 1.0, true, true, false, false));

		return background = new Background(backgroundImg);
	}

	@SuppressWarnings("unchecked")
	public Button createBackButton(Scene firstScene, Stage stage) {
		Button backButton = new Button("Back");
		Font font = Font.loadFont(FONT_URL, 12);
		
		backButton.setTranslateX(95);
		backButton.setTranslateY(820);
		backButton.setMaxWidth(100);
		backButton.setMinWidth(100);
		backButton.setMaxHeight(40);
		backButton.setMinHeight(40);
		backButton.setTextFill(Color.GREY);
		backButton.setFont(font);
		//backButton.setBackground(createColorBackground(Color.GREY));
		backButton.setOnAction(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				stage.setScene(firstScene);
			}
		}
);
		
		return backButton;
		
	}
	
	private void displayClassIcon(String classIconUrl, Pane root, String className) {
		StackPane classImgPane = new StackPane();
		
		ImageView classImg = new ImageView(classIconUrl);
		
		Font font = Font.loadFont(FONT_URL, 28);
		
		Label classLabel = new Label(className);
		classLabel.setFont(font);
		classLabel.setTextFill(Color.WHITE);
		classLabel.setTranslateY(80);
		classImgPane.setTranslateX(540);
		classImgPane.setTranslateY(15);
		
		classImgPane.getChildren().addAll(classImg, classLabel);
		root.getChildren().add(classImgPane);
	}
}
