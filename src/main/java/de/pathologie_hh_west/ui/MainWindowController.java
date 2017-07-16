package de.pathologie_hh_west.ui;

import de.pathologie_hh_west.ui.util.FXMLView;
import de.pathologie_hh_west.ui.util.SpringFXMLLoader;
import de.pathologie_hh_west.ui.util.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
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
	@FXML private MenuItem mnFallView;
	@FXML private MenuItem mnExcelEinlesen;
	@FXML private GridPane mainContainer;
	private SpringFXMLLoader springFXMLLoader;
	private StageManager stageManager;
	
	@Autowired
	public MainWindowController(SpringFXMLLoader springFXMLLoader, StageManager stageManager) {
		this.springFXMLLoader = springFXMLLoader;
		this.stageManager = stageManager;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mnFallView.addEventHandler(ActionEvent.ANY, event -> {
			try {
				Parent parent = springFXMLLoader.getCachedOrLoad("/ui/fxml/FallView.fxml");
				mainContainer.getChildren().clear();
				mainContainer.getChildren().addAll(parent);
			} catch (IOException e) {
				//TODO
				e.printStackTrace();
			}
		});
		
		mnExcelEinlesen.addEventHandler(ActionEvent.ANY, event -> {
			String stageName = "openExcelStage";
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stageManager.registerStage(stageName, stage);
			stageManager.switchScene(stageName, FXMLView.OPENEXCEL_FILEDIALOG);
		});
	}
}
