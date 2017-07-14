package de.pathologie_hh_west.ui.util;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Created by eike on 10.07.2017.
 */
public class StageManager {
	//https://www.youtube.com/watch?v=RifjriAxbw8
	
	private final Stage primaryStage;
	private final SpringFXMLLoader fxmlLoader;
	
	public StageManager(SpringFXMLLoader fxmlLoader, Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.fxmlLoader = fxmlLoader;
	}
	
	public void switchScene(final FMXLView view) {
		Parent parent = loadView(view.getFXMLFile());
		show(parent, view.getTitle());
	}
	
	private void show(final Parent rootNode, String title) {
		Scene scene = prepareScene(rootNode);
		
		primaryStage.setTitle(title);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		
		primaryStage.show();
	}
	
	private Scene prepareScene(Parent rootNode) {
		Scene scene = primaryStage.getScene();
		if (scene == null) {
			scene = new Scene(rootNode);
		}
		return scene;
	}
	
	private Parent loadView(String fxmlFile) {
		Parent rootNode = null;
		try {
			rootNode = fxmlLoader.loadNewFXML(fxmlFile);
			Objects.requireNonNull(rootNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rootNode;
	}
}
