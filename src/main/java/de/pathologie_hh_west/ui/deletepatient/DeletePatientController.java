package de.pathologie_hh_west.ui.deletepatient;

import de.pathologie_hh_west.model.Patient;
import de.pathologie_hh_west.service.PatientService;
import de.pathologie_hh_west.ui.util.StageManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@Scope("prototype")
public class DeletePatientController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private RadioButton rbSingle;

    @FXML
    private ToggleGroup tgDeleteType;

    @FXML
    private TextField tfFirstname;

    @FXML
    private TextField tfLastname;

    @FXML
    private DatePicker dbDateOfBirth;

    @FXML
    private RadioButton rbMulti;

    @FXML
    private Label lblFile;

    @FXML
    private Button btnChooseFile;

    private File selectedFile;

    @Autowired
    private StageManager stageManager;
    @Autowired
    private PatientService patientService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnChooseFile.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Datei", "*.xlsx"));
            File file = fileChooser.showOpenDialog(stageManager.getStage("openExcelStage"));

            if (file != null) {
                selectedFile = file;
                lblFile.setText(selectedFile.getPath());
            }
        });

        tgDeleteType.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (rbSingle.isSelected()) {
                btnChooseFile.setDisable(true);

                tfFirstname.setDisable(false);
                tfLastname.setDisable(false);
                dbDateOfBirth.setDisable(false);
            } else if (rbMulti.isSelected()) {
                btnChooseFile.setDisable(false);

                tfFirstname.setDisable(true);
                tfLastname.setDisable(true);
                dbDateOfBirth.setDisable(true);
            }
        });
        tgDeleteType.selectToggle(rbSingle);

        btnDelete.setOnAction(event -> {
            if (rbSingle.isSelected()) {
                Patient patient = new Patient();
                patient.setVorname(tfFirstname.getText());
                patient.setNachname(tfLastname.getText());
                patient.setGeburtsDatum(dbDateOfBirth.getValue());
                try {
                    patientService.deletePatient(patient);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (rbSingle.isSelected()) {
                //TODO: EXCELDATEI
            }
            stageManager.getStage("deletePatientStage").close();
        });
    }

}
