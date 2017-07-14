package de.pathologie_hh_west.ui;

import de.pathologie_hh_west.ui.util.SpringFXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by eike on 10.07.2017.
 */
@Component
@Scope("prototype")
public class MainWindowController implements Initializable {
	
	@FXML private MenuBar menuBar;
	@FXML private GridPane mainContainer;
	private SpringFXMLLoader springFXMLLoader;
	
	@Autowired
	public MainWindowController(SpringFXMLLoader springFXMLLoader) {
		this.springFXMLLoader = springFXMLLoader;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		menuBar.getMenus().filtered(m -> m.getText().equals("Ansicht")).get(0).getItems().get(0).addEventHandler(ActionEvent.ANY, event -> {
			try {
				Parent parent = springFXMLLoader.getCachedOrLoad("/ui/fxml/FallView.fxml");
				mainContainer.getChildren().clear();
				mainContainer.getChildren().addAll(parent);
			} catch (IOException e) {
				//TODO
				e.printStackTrace();
			}
		});
	}
}
