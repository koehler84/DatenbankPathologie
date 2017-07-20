package de.pathologie_hh_west.ui.openexcel;

import de.pathologie_hh_west.service.ExcelFile;
import de.pathologie_hh_west.service.ExcelService;
import de.pathologie_hh_west.ui.util.FXMLView;
import de.pathologie_hh_west.ui.util.StageManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by eike on 15.07.2017.
 */
@Component
@Scope("prototype")
public class SelectWorksheetController implements Initializable {
	
	@FXML private ChoiceBox<String> cbWorksheet;    //TODO change type to ExcelWorksheet wrapper
	@FXML
	private Button btnBack;
	@FXML
	private Button btnContinue;
	@FXML
	private Button btnCancel;
	@Autowired
	private StageManager stageManager;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		final HashMap<String, Integer> worksheets = stageManager.getAttribute("openExcelWorksheets") instanceof HashMap ? ((HashMap) stageManager.getAttribute("openExcelWorksheets")) : null;
		if (worksheets != null) {
			List<String> items = new ArrayList<>(worksheets.keySet());
			cbWorksheet.setItems(FXCollections.observableList(items));
		}
		
		btnBack.setOnAction(event -> {
			stageManager.switchScene("openExcelStage", FXMLView.OPENEXCEL_FILEDIALOG);
		});
		
		btnContinue.setOnAction(event -> {
			if (cbWorksheet.getValue() == null) {
				Alert alert = new Alert(Alert.AlertType.WARNING, "Bitte wählen Sie ein Worksheet aus.");
				alert.show();
				return;
			}
			
			stageManager.addAttribute("openExcelSelectedWorksheetIndex", worksheets.get(cbWorksheet.getValue()));
			stageManager.switchScene("openExcelStage", FXMLView.OPENEXCEL_MAPPINGDIALOG);
		});
		
		btnCancel.setOnAction(event -> {
			stageManager.removeAttribute("openExcelSelectedFile");
			stageManager.removeAttribute("openExcelWorksheets");
			stageManager.removeAttribute("openExcelSelectedWorksheetIndex");
			stageManager.getStage("openExcelStage").close();
		});
	}
	
}
