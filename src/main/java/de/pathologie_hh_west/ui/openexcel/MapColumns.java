package de.pathologie_hh_west.ui.openexcel;

import de.pathologie_hh_west.service.*;
import de.pathologie_hh_west.ui.util.AutoCompleteComboBoxListener;
import de.pathologie_hh_west.ui.util.FXMLView;
import de.pathologie_hh_west.ui.util.StageManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
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
	@Autowired
	private ExcelService excelService;
	
	private Map<String, Integer> excelColumnsMap;
	private List<String> excelColumns;
	private List<Node[]> gridPaneInputNodes;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		final Integer worksheetIndex = (Integer) stageManager.getAttribute("openExcelSelectedWorksheetIndex");
		final ExcelFile excelFile = (ExcelFile) stageManager.getAttribute("openExcelSelectedFile");
		try {
			excelColumnsMap = excelFile.getHeadlines(worksheetIndex);
		} catch (ColumnHeadersNotFoundException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR, "Es ist ein Fehler beim öffnen des Arbeitsblatts aufgetreten. " +
					"Bitte wählen Sie ein anderes Arbeitsblatt oder überprüfen Sie die Daten.");
			alert.showAndWait();
			stageManager.switchScene("openExcelStage", FXMLView.OPENEXCEL_WORKSHEETDIALOG);
			throw new RuntimeException(e);
		}
		this.excelColumns = new ArrayList<>(excelColumnsMap.keySet());
		gridPaneInputNodes = new ArrayList<>();
		
		int gpRowAmount = gpMapperNodes.getRowConstraints().size();
		for (int i = 0; i < this.excelColumns.size(); i++) {
			Node[] inputNodes = getInputNodes();
			ChoiceBox<String> excelBox = ((ChoiceBox<String>) inputNodes[0]);
			excelBox.setValue(this.excelColumns.get(i));
            ComboBox<String> excelMapValue = (ComboBox<String>) inputNodes[1];
            CheckBox excelOverride = (CheckBox) inputNodes[2];
            try {
                PatientModelAttribute.valueOf(this.excelColumns.get(i).toUpperCase());
                excelMapValue.setValue(this.excelColumns.get(i).toUpperCase());
                excelOverride.setSelected(true);
            } catch (IllegalArgumentException e) {
                //TODO: Überschrift existiert nicht als enum
                //Feedback nötig?
            }
            gpMapperNodes.addRow(gpRowAmount + i, excelBox, excelMapValue, excelOverride);
        }
		
		btnCancel.setOnAction(event -> {
			stageManager.removeAttribute("openExcelSelectedFile");
			stageManager.removeAttribute("openExcelWorksheets");
			stageManager.removeAttribute("openExcelSelectedWorksheetIndex");
			stageManager.getStage("openExcelStage").close();
		});
		
		btnContinue.setOnAction(event -> {
			Set<IndexMapper> indexMappers = getIndexMappersFromGridPane();
			stageManager.addAttribute("openExcelIndexMappers", indexMappers);
			
			stageManager.switchScene("openExcelStage", FXMLView.OPENEXCEL_PROGESSDIALOG);
		});
		
		btnBack.setOnAction(event -> {
			stageManager.switchScene("openExcelStage", FXMLView.OPENEXCEL_WORKSHEETDIALOG);
		});
	}
	
	private Set<IndexMapper> getIndexMappersFromGridPane() {
		Set<IndexMapper> mappers;
		
		mappers = gridPaneInputNodes.stream()
				.map(nodeArray -> {
					Integer excelIndex = null;
					if (nodeArray[0] != null && nodeArray[0] instanceof ChoiceBox) {
						try {
							excelIndex = excelColumnsMap.get(((ChoiceBox<String>) nodeArray[0]).getValue());
						} catch (Exception e) {
							new Alert(Alert.AlertType.ERROR, "Ein Fehler ist aufgetreten. Es konnte kein Index zur ausgewählten ExcelSpalte gefunden werden.").show();
							e.printStackTrace();
							return null;
						}
					}
					
					PatientModelAttribute patientAttribut = null;
					if (nodeArray[1] != null && nodeArray[1] instanceof ComboBox) {
						String value = ((ComboBox<String>) nodeArray[1]).getValue();
						if (value == null) {
							return null;
						}
						try {
							patientAttribut = PatientModelAttribute.valueOf(value);
						} catch (IllegalArgumentException e) {
							new Alert(Alert.AlertType.ERROR, "Ein Fehler ist aufgetreten. Es konnte kein ModelAttribute für '" + value + "' gefunden werden.").show();
							e.printStackTrace();
							return null;
						}
					}
					
					Boolean selected = null;
					if (nodeArray[2] != null && nodeArray[2] instanceof CheckBox) {
						selected = !((CheckBox) nodeArray[2]).isSelected();
					}
					
					return new IndexMapper(excelIndex, patientAttribut, selected);
				})
				.filter(Objects::nonNull)
				.collect(Collectors.toSet());
		
		return mappers;
	}
	
	private Node[] getInputNodes() {
		ComboBox fieldsBox = getFieldsBox();
		CheckBox checkBox = getCheckBox();
		checkBox.disableProperty().bind(fieldsBox.getEditor().textProperty().isEmpty());
		fieldsBox.getEditor().textProperty().isEmpty().addListener((observable, oldValue, newValue) -> {
			if (newValue) checkBox.setSelected(false);      //uncheck if fieldsbox is being cleared
		});
		
		Node[] nodes = new Node[3];
		nodes[0] = getExcelBox();
		nodes[1] = fieldsBox;
		nodes[2] = checkBox;
		gridPaneInputNodes.add(nodes);
		
		return nodes;
	}
	
	private CheckBox getCheckBox() {
		return new CheckBox();
	}
	
	private Node getExcelBox() {
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
