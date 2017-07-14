package de.pathologie_hh_west.ui.util;

/**
 * Created by eike on 10.07.2017.
 */
public enum FMXLView {

	MAIN {
		@Override
		String getTitle() {
			return "PHHW Datenbank";
		}
		
		@Override
		String getFXMLFile() {
			return "/ui/fxml/MainWindow.fxml";
		}
	}, FALL {
		@Override
		String getTitle() {
			return "PHHW Datenbank";
		}
		
		@Override
		String getFXMLFile() {
			return "/ui/fxml/FallView.fxml";
		}
	};
	
	abstract String getTitle();
	abstract String getFXMLFile();
}
