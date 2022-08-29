package d2tc.gui;

import java.util.ArrayList;

import javax.swing.text.Position;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainPageCharacterSelectionScreen extends Application {
	private final String TITLE_NAME = "Diablo 2 Talent Calculator";
	private final String HEADING_NAME = "Choose a class:";
	private final String SORCERESS_IMG_URL = "file:///E:/Programming/Code/Java/Diablo2_Talent_Calculator/res/button_imgs/sorceress.jpg";
	private final String PALADIN_IMG_URL = "file:///E:/Programming/Code/Java/Diablo2_Talent_Calculator/res/button_imgs/paladin.jpg";
	private final String NECROMANCER_IMG_URL = "file:///E:/Programming/Code/Java/Diablo2_Talent_Calculator/res/button_imgs/necromancer.jpg";
	private final String DRUID_IMG_URL = "file:///E:/Programming/Code/Java/Diablo2_Talent_Calculator/res/button_imgs/druid.jpg";
	private final String BARBARIAN_IMG_URL = "file:///E:/Programming/Code/Java/Diablo2_Talent_Calculator/res/button_imgs/barbarian.jpg";
	private final String ASSASSIN_IMG_URL = "file:///E:/Programming/Code/Java/Diablo2_Talent_Calculator/res/button_imgs/assassin.jpg";
	private final String AMAZON_IMG_URL = "file:///E:/Programming/Code/Java/Diablo2_Talent_Calculator/res/button_imgs/amazon.jpg";
	private final String D2R_ICON_URL = "file:///E:/Programming/Code/Java/Diablo2_Talent_Calculator/res/logo/D2RLogo.jpeg";
	private final String FONT_URL = "file:///E:/Programming/Code/Git/D2R_Calculator/Diablo2_Talent_Calculator/res/fonts/exocet_regular.ttf";
	private final int WINDOW_WIDTH = 990;
	private final int WINDOW_HEIGHT = 236;

	private Text headingText;
	FlowPane characterButtonflow;
	private ArrayList<Button> characterButtons;
	private Button sorceressButton;
	private Button paladinButton;
	private Button necromancerButton;
	private Button barbarianButton;
	private Button druidButton;
	private Button assassinButton;
	private Button amazonButton;
	private Stage mainStage;
	private Scene firstScene;

	@Override
	public void start(Stage startupStage) throws Exception {
		mainStage = startupStage;
		characterButtons = new ArrayList<>();
		
		createHeadingText();
		createFlowPane();
		addButtons();

		for (int i = 0; i < characterButtons.size(); i++) {
			characterButtons.get(i).setContentDisplay(ContentDisplay.TOP);
			characterButtons.get(i).setWrapText(true);
			characterButtons.get(i).setFont(Font.loadFont(FONT_URL, 14));
			characterButtonflow.getChildren().add(characterButtons.get(i));
			characterButtons.get(i).setOnAction(CharacterButtonHandler);
		}

		Group root = new Group();
		root.getChildren().add(characterButtonflow);
		root.getChildren().add(headingText);

		firstScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT, Color.BLACK);
		mainStage.setTitle(TITLE_NAME);
		mainStage.getIcons()
				.add(new Image(D2R_ICON_URL));
		mainStage.setScene(firstScene);
		mainStage.show();
	}

	public void createFlowPane() {
		characterButtonflow = new FlowPane(Orientation.VERTICAL);
		characterButtonflow.setVgap(8);
		characterButtonflow.setHgap(4);
		characterButtonflow.setPrefWrapLength(300);
		characterButtonflow.setTranslateY(85);
	}

	public void createHeadingText() {
		headingText = new Text(HEADING_NAME);
		Font font = Font.loadFont(FONT_URL, 32);
		
		headingText.setFont(font);
		headingText.setFill(Color.WHITE);
		headingText.setX(325);
		headingText.setY(50);
	}

	public void addButtons() {
		characterButtons.add(sorceressButton = new Button("Sorceress", new ImageView(SORCERESS_IMG_URL)));
		characterButtons.add(paladinButton = new Button("Paladin", new ImageView(PALADIN_IMG_URL)));
		characterButtons.add(necromancerButton = new Button("Necromancer", new ImageView(NECROMANCER_IMG_URL)));
		characterButtons.add(druidButton = new Button("Druid", new ImageView(DRUID_IMG_URL)));
		characterButtons.add(barbarianButton = new Button("Barbarian", new ImageView(BARBARIAN_IMG_URL)));
		characterButtons.add(assassinButton = new Button("Assassin", new ImageView(ASSASSIN_IMG_URL)));
		characterButtons.add(amazonButton = new Button("Amazon", new ImageView(AMAZON_IMG_URL)));
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	EventHandler<ActionEvent> CharacterButtonHandler = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {

			if (event.getSource().equals(sorceressButton)) {
				SorceressPage sorceressPage = new SorceressPage(mainStage, firstScene, SORCERESS_IMG_URL);
			} else if (event.getSource().equals(paladinButton)) {
				PaladinPage paladinPage = new PaladinPage(mainStage, firstScene, PALADIN_IMG_URL);
			} else if (event.getSource().equals(necromancerButton)) {
				NecromancerPage necromancerPage = new NecromancerPage(mainStage, firstScene, NECROMANCER_IMG_URL);
			} else if (event.getSource().equals(assassinButton)) {
				AssassinPage assassinPage = new AssassinPage(mainStage, firstScene, ASSASSIN_IMG_URL);
			} else if (event.getSource().equals(amazonButton)) {
				AmazonPage amazonPage = new AmazonPage(mainStage, firstScene, AMAZON_IMG_URL);
			} else if (event.getSource().equals(barbarianButton)) {
				BarbarianPage barbarian = new BarbarianPage(mainStage, firstScene, BARBARIAN_IMG_URL);
			} else if (event.getSource().equals(druidButton)) {
				DruidPage druidPage = new DruidPage(mainStage, firstScene, DRUID_IMG_URL);
			} 
		}
	};
}
