package de.pathologie_hh_west.ui.openexcel;

import de.pathologie_hh_west.ui.util.FXMLView;
import de.pathologie_hh_west.ui.util.StageManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by eike on 15.07.2017.
 */
@Component
@Scope("prototype")
public class SelectWorksheetController implements Initializable {
	
	@FXML private ChoiceBox<String> cbWorksheet;
	@FXML private Button btnBack;
	@FXML private Button btnContinue;
	@FXML private Button btnCancel;
	@Autowired
	private StageManager stageManager;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		final HashMap<Integer, String> hashMap = stageManager.getAttribute("openExcelWorksheets") instanceof HashMap ? ((HashMap) stageManager.getAttribute("openExcelWorksheets")) : null;
		if (hashMap != null) {
			List<String> strings = hashMap.entrySet().stream()
					.map(Map.Entry::getValue)
					.collect(Collectors.toList());
			cbWorksheet.setItems(FXCollections.observableList(strings));
		}
		
		btnBack.setOnAction(event -> {
			stageManager.switchScene("openExcelStage", FXMLView.OPENEXCEL_FILEDIALOG);
		});
		
		btnContinue.setOnAction(event -> {
		
		});
		
		btnCancel.setOnAction(event -> {
			stageManager.removeAttribute("openExcelSelectedFile");
			stageManager.getStage("openExcelStage").close();
		});
	}
}
