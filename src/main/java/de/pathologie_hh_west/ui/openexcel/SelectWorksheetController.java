package de.pathologie_hh_west.ui.openexcel;

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
		System.out.println(stageManager.getStage("openExcelStage").getUserData());
		
		HashMap<Integer, String> hashMap = stageManager.getStage("openExcelStage").getUserData() instanceof HashMap ? ((HashMap) stageManager.getStage("openExcelStage").getUserData()) : null;
		if (hashMap != null) {
			List<String> strings = hashMap.entrySet().stream()
					.map(entry -> entry.getValue())
					.collect(Collectors.toList());
			cbWorksheet.setItems(FXCollections.observableList(strings));
		}
		
		btnCancel.setOnAction(event -> {
			stageManager.getStage("openExcelStage").close();
		});
	}
}
