package de.pathologie_hh_west.ui.util;

import javafx.fxml.LoadException;
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
	private HashMap<String, Object> attributes;

	public StageManager(SpringFXMLLoader fxmlLoader) {
		this.stageMap = new HashMap<>();
		this.fxmlLoader = fxmlLoader;
		this.attributes = new HashMap<>();
	}
	
	public void registerStage(String stageName, Stage stage) {
		this.stageMap.put(stageName, stage);
	}

	public void switchScene(final String stageName, final FXMLView view) throws RuntimeException {
		Parent parent = null;
		try {
			parent = loadView(view.getFXMLFile());
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof LoadException) throw new RuntimeException(e.getCause());
			throw new RuntimeException(e);
		}
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

	private Parent loadView(String fxmlFile) throws Exception {
		Parent rootNode = null;
		rootNode = fxmlLoader.loadNewFXML(fxmlFile);
		Objects.requireNonNull(rootNode);
		return rootNode;
	}

	public Stage getStage(String stageName) {
		return this.stageMap.get(stageName);
	}
	
	public boolean hasAttribute(String key) {
		return attributes.containsKey(key);
	}
	
	public void removeAttribute(String key) {
		attributes.remove(key);
	}
	
	public Object getAttribute(Object key) {
		return attributes.get(key);
	}
	
	public Object addAttribute(String key, Object value) {
		return attributes.put(key, value);
	}
}
