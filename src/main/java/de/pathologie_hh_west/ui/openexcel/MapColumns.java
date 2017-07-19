package de.pathologie_hh_west.ui.openexcel;

import de.pathologie_hh_west.service.ExcelFile;
import de.pathologie_hh_west.service.PatientModelAttribute;
import de.pathologie_hh_west.ui.util.AutoCompleteComboBoxListener;
import de.pathologie_hh_west.ui.util.FXMLView;
import de.pathologie_hh_west.ui.util.StageManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by eike on 16.07.2017.
 */
@Component
@Scope("prototype")
public class MapColumns implements Initializable {
	
	@FXML
	private GridPane gpMapperNodes;
	@FXML
	private Button btnBack;
	@FXML
	private Button btnContinue;
	@FXML
	private Button btnCancel;
	@Autowired
	private StageManager stageManager;
	
	private List<String> excelColumns;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Integer worksheetIndex = (Integer) stageManager.getAttribute("openExcelSelectedWorksheetIndex");
		ExcelFile excelFile = (ExcelFile) stageManager.getAttribute("openExcelSelectedFile");
		excelColumns = new ArrayList<>(excelFile.getHeadlines(worksheetIndex).keySet());
		
		int gpRowAmount = gpMapperNodes.getRowConstraints().size();
		for (int i = 0; i < excelColumns.size(); i++) {
			ChoiceBox excelBox = getExcelBox();
			excelBox.setValue(excelColumns.get(i));
			gpMapperNodes.addRow(gpRowAmount + i, excelBox, getFieldsBox(), getCheckBox());
		}
		
		btnCancel.setOnAction(event -> {
			stageManager.removeAttribute("openExcelSelectedFile");
			stageManager.removeAttribute("openExcelWorksheets");
			stageManager.removeAttribute("openExcelSelectedWorksheetIndex");
			stageManager.getStage("openExcelStage").close();
		});
		
		btnBack.setOnAction(event -> {
			stageManager.switchScene("openExcelStage", FXMLView.OPENEXCEL_WORKSHEETDIALOG);
		});
	}
	
	private CheckBox getCheckBox() {
		return new CheckBox();
	}
	
	private ChoiceBox getExcelBox() {
		ChoiceBox<Object> cb = new ChoiceBox<>();
		cb.setDisable(true);
		cb.setPrefWidth(150);
		List<Object> items = new ArrayList<>(this.excelColumns);
		cb.setItems(FXCollections.observableList(items));
		return cb;
	}
	
	private ComboBox getFieldsBox() {
		ComboBox<Object> cb = new ComboBox<>();
		cb.setPrefWidth(150);
		cb.setOnKeyTyped(new AutoCompleteComboBoxListener(cb));
		List<Object> items = Arrays.asList(PatientModelAttribute.values());
		cb.setItems(FXCollections.observableList(items));
		return cb;
	}
}
