package de.pathologie_hh_west.ui.openexcel;

import de.pathologie_hh_west.service.ExcelFile;
import de.pathologie_hh_west.service.ExcelService;
import de.pathologie_hh_west.service.IndexMapper;
import de.pathologie_hh_west.support.ProgressListener;
import de.pathologie_hh_west.ui.util.StageManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ProgressBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;

@Component
@Scope("prototype")
public class ProgressController implements Initializable {
	
	@FXML
	private ProgressBar progressBar;
	@Autowired
	private ExcelService excelService;
	@Autowired
	private StageManager stageManager;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		final Integer worksheetIndex = (Integer) stageManager.getAttribute("openExcelSelectedWorksheetIndex");
		final ExcelFile excelFile = (ExcelFile) stageManager.getAttribute("openExcelSelectedFile");
		final Set<IndexMapper> indexMappers = (Set<IndexMapper>) stageManager.getAttribute("openExcelIndexMappers");
		
		Platform.runLater(() -> {
			try {
				excelService.updatePatientsFromExcel(indexMappers, excelFile, worksheetIndex)
						.registerListener(new ProgressBarUpdater())
						.updateData();
				
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
						"Der Datenimport wurde abgeschlossen. Möchten Sie dieses Fenster jetzt schließen?", ButtonType.YES, ButtonType.NO);
				Optional<ButtonType> buttonType = alert.showAndWait();
				if (buttonType != null && buttonType.get() == ButtonType.YES) {
					stageManager.removeAttribute("openExcelSelectedFile");
					stageManager.removeAttribute("openExcelWorksheets");
					stageManager.removeAttribute("openExcelSelectedWorksheetIndex");
					stageManager.removeAttribute("openExcelIndexMappers");
					stageManager.getStage("openExcelStage").close();
				} else if (buttonType != null && buttonType.get() == ButtonType.NO) {
				
				}
			} catch (Exception e) {
				Alert alert = new Alert(Alert.AlertType.ERROR, "Beim einlesen der Daten ist ein Fehler aufgetreten: " + e.getMessage());
				alert.show();
			}
		});
	}
	
	public class ProgressBarUpdater implements ProgressListener {
		
		@Override
		public void updateProgress(double progress) {
			progressBar.progressProperty().setValue(progress);
		}
	}
}
