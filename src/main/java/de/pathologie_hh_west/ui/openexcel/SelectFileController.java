package de.pathologie_hh_west.ui.openexcel;

import de.pathologie_hh_west.service.ExcelOeffnenService;
import de.pathologie_hh_west.ui.util.FXMLView;
import de.pathologie_hh_west.ui.util.StageManager;
import de.pathologie_hh_west.ui.util.StageNotFoundException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Created by eike on 15.07.2017.
 */
@Component
@Scope("prototype")
public class SelectFileController implements Initializable {
	
	@FXML private TextField filePath;
	@FXML private Button btnChooseFile;
	@FXML private Button btnContinue;
	@FXML private Button btnCancel;
	@Autowired
	private StageManager stageManager;
	private File selectedFile;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnChooseFile.setOnAction(event -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Datei", "*.xlsx"));
			File file = fileChooser.showOpenDialog(stageManager.getStage("openExcelStage"));
			
			if (file != null) {
				selectedFile = file;
				filePath.setText(selectedFile.getPath());
			}
		});
		
		btnContinue.setOnAction(event -> {
			if (selectedFile == null) {
				Alert alert = new Alert(Alert.AlertType.ERROR, "Bitte wählen Sie eine Datei aus.", ButtonType.OK);
				alert.show();
				return;
			}
			
			HashMap<Integer, String> arbeitsblaetter;
			try {
				ExcelOeffnenService excelOeffnenService = new ExcelOeffnenService(selectedFile.getPath());
				arbeitsblaetter = excelOeffnenService.getNamenArbeitsblaetter();
			} catch (IOException e) {
				e.printStackTrace();
				Alert alert = new Alert(Alert.AlertType.ERROR, "Es ist ein Fehler beim einlesen der Datei aufgetreten.", ButtonType.OK);
				alert.show();
				return;
			}
			
			try {
				stageManager.getStage("openExcelStage").setUserData(arbeitsblaetter);
				stageManager.switchScene("openExcelStage", FXMLView.OPENEXCEL_WORKSHEETDIALOG);
			} catch (StageNotFoundException e) {
				e.printStackTrace();
			}
		});
		
		btnCancel.setOnAction(event -> {
			stageManager.getStage("openExcelStage").close();
		});
	}
}
