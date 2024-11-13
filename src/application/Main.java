package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {

			Pane pane = new HBox(10);
			pane.setPadding(new Insets(10, 10, 10, 10));
			pane.setPrefWidth(400);
			pane.setPrefHeight(100); 
			// java code for generatind deck of cards and shuffling deck, and deal out num of selected cards

			Deck deck = new Deck();
			System.out.println(deck.toString());
			// creates dynamic list of random cards by parameter value
			ArrayList<Deck.Card> randomCards = Deck.dealRandomCards(3);

			System.out.println(randomCards);

			// get the image index of the random card, convert it to string
			// this value is stored to create an image path, the index matches the fileName
			// for the cards
			ArrayList<String> imageIndexList = new ArrayList<>();

			for (int i = 0; i < randomCards.size(); i++) {
				imageIndexList.add(String.valueOf(randomCards.get(i).imageNumber));
			}

			for (int j = 0; j < imageIndexList.size(); j++) {
				Image image = new Image("image/card/" + imageIndexList.get(j) + ".png");
				pane.getChildren().add(new ImageView(image));
			}

			Scene scene = new Scene(pane);
			primaryStage.setTitle(String.valueOf(randomCards.size()) +" Cards dealt to you");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
