package de.pathologie_hh_west.ui.util;

/**
 * Created by eike on 10.07.2017.
 */
public enum FXMLView {

	MAIN {
		@Override
		String getTitle() {
			return "PHHW Datenbank";
		}
		
		@Override
		String getFXMLFile() {
			return "/ui/fxml/MainWindow.fxml";
		}
	}, OPENEXCEL_FILEDIALOG {
		@Override
		String getTitle() {
			return "Excel einlesen";
		}
		
		@Override
		String getFXMLFile() {
			return "/ui/fxml/openexcel/SelectFile.fxml";
		}
	}, OPENEXCEL_WORKSHEETDIALOG {
		@Override
		String getTitle() {
			return "Excel einlesen";
		}
		
		@Override
		String getFXMLFile() {
			return "/ui/fxml/openexcel/SelectWorksheet.fxml";
		}
	}, OPENEXCEL_MAPPINGDIALOG {
		@Override
		String getTitle() {
			return "Excel einlesen";
		}
		
		@Override
		String getFXMLFile() {
			return "/ui/fxml/openexcel/MapColumns.fxml";
		}
	}, OPENEXCEL_PROGESSDIALOG {
		@Override
		String getTitle() {
			return "Excel einlesen";
		}
		
		@Override
		String getFXMLFile() {
			return "/ui/fxml/openexcel/Progress.fxml";
		}
	}, PATIENT_VIEW {
		@Override
		String getTitle() {
			return "Patient";
		}
		
		@Override
		String getFXMLFile() {
			return "/ui/fxml/patientview/MainView.fxml";
		}
	};
	
	abstract String getTitle();
	abstract String getFXMLFile();
}
