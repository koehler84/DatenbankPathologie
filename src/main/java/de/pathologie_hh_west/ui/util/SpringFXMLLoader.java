package de.pathologie_hh_west.ui.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by eike on 10.07.2017.
 */
@Component
public class SpringFXMLLoader {
	
	private final ApplicationContext springContext;
	private final ResourceBundle resourceBundle;
	private Map<String, Parent> cachedParents;
	
	@Autowired
	public SpringFXMLLoader(ApplicationContext springContext, ResourceBundle resourceBundle) {
		this.cachedParents = new HashMap<>();
		this.springContext = springContext;
		this.resourceBundle = resourceBundle;
	}
	
	public Parent loadNewFXML(final String fxmlPath) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setControllerFactory(springContext::getBean);
		loader.setResources(resourceBundle);
		loader.setLocation(getClass().getResource(fxmlPath));
		Parent parent = loader.load();
		cachedParents.put(fxmlPath, parent);
		return parent;
	}
	
	public Parent getCachedOrLoad(final String fxmlPath) throws IOException {
		Parent parent = cachedParents.get(fxmlPath);
		if (parent == null) {
			return loadNewFXML(fxmlPath);
		}
		return parent;
	}
}
