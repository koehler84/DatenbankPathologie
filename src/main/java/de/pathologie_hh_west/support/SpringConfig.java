package de.pathologie_hh_west.support;

import de.pathologie_hh_west.ui.util.SpringFXMLLoader;
import de.pathologie_hh_west.ui.util.StageManager;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.ResourceBundle;

/**
 * Created by eike on 10.07.2017.
 */
@Configuration
public class SpringConfig {

	@Autowired
	private SpringFXMLLoader springFXMLLoader;
	
	@Bean
	public ResourceBundle resourceBundle() {
		return ResourceBundle.getBundle("ui.resourcebundles.Bundle");
	}
	
	@Bean
	@Lazy(true)
	public StageManager stageManager(Stage stage) {
		return new StageManager(springFXMLLoader, stage);
	}

}
