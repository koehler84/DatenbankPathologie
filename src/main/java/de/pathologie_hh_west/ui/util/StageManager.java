package de.pathologie_hh_west.ui.util;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by eike on 10.07.2017.
 */
@Component
public class StageManager {
	//https://www.youtube.com/watch?v=RifjriAxbw8
	
	private final Map<String, Stage> stageMap;
	private final SpringFXMLLoader fxmlLoader;

	public StageManager(SpringFXMLLoader fxmlLoader) {
		this.stageMap = new HashMap<>();
		this.fxmlLoader = fxmlLoader;
	}
	
	public void registerStage(String stageName, Stage stage) {
		this.stageMap.put(stageName, stage);
	}

	public void switchScene(final String stageName, final FXMLView view) {
		Parent parent = loadView(view.getFXMLFile());
		show(stageName, parent, view.getTitle());
	}

	private void show(final String stageName, final Parent rootNode, final String title) {
		Scene scene = prepareScene(stageName, rootNode);
		
		Stage stage = this.stageMap.get(stageName);
		if (stage == null) throw new StageNotFoundException("Stage " + stageName + " could not be found.");
		
		stage.setTitle(title);
		stage.setScene(scene);
		stage.sizeToScene();
		
		stage.show();
	}

	private Scene prepareScene(final String stageName, final Parent rootNode) {
		Stage stage = this.stageMap.get(stageName);
		if (stage == null) throw new StageNotFoundException("Stage " + stageName + " could not be found.");
		
		Scene scene = stage.getScene();
		if (scene == null) {
			scene = new Scene(rootNode);
		} else {
			scene.setRoot(rootNode);
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

	public Stage getStage(String stageName) {
		return this.stageMap.get(stageName);
	}
	
}
