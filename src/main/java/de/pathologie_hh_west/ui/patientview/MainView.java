package de.pathologie_hh_west.ui.patientview;

import de.pathologie_hh_west.data.PatientRepository;
import de.pathologie_hh_west.model.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

@Component
@Scope("prototype")
public class MainView implements Initializable {
	
	@FXML
	private TitledPane tilePanePatient;
	@FXML
	private TextField tfId;
	@FXML
	private TextField tfVorname;
	@FXML
	private TextField tfNachname;
	@FXML
	private TextField tfAlternativname;
	@FXML
	private DatePicker dpGeburtsdatum;
	@FXML
	private TextField tfStrasse;
	@FXML
	private TextField tfHausnummer;
	@FXML
	private TextField tfPLZ;
	@FXML
	private TextField tfOrt;
	@FXML
	private TextField tfLand;
	@FXML
	private TextField tfPseudonym;
	@FXML
	private TextField tfPseudonym2;
	@FXML
	private TextField tfStatus;
	@FXML
	private DatePicker dpDatum;
	@FXML
	private TextField tfTodQuelle;
	@FXML
	private DatePicker dpTodDatum;
	@FXML
	private TextField tfNotizen;
	@FXML
	private TextField welle;
	@FXML
	private TextField rawid;
	@FXML
	private TextField source;
	@FXML
	private TextField zeit;
	@FXML
	private TextField chemo;
	@FXML
	private TextField chemo_zeitpunkt;
	@FXML
	private TextField medikamente;
	@FXML
	private TextField bestrahlung;
	@FXML
	private CheckBox med_anithormon;
	@FXML
	private CheckBox med_antihormon_unbekannt;
	@FXML
	private CheckBox med_antihormon_tamoxifen;
	@FXML
	private CheckBox med_antihormon_arimidex;
	@FXML
	private CheckBox med_antihormon_aromasin;
	@FXML
	private CheckBox med_antihormon_fe03a;
	@FXML
	private TextField herceptin;
	@FXML
	private TextField biophosphonaten;
	@FXML
	private TextField biophosphaten_text;
	@FXML
	private TextField weitere_erkrankung;
	@FXML
	private CheckBox rezidiv;
	@FXML
	private CheckBox metastasen;
	@FXML
	private CheckBox metastasen_abrust;
	@FXML
	private CheckBox metastasen_lymphknoten;
	@FXML
	private CheckBox metastasen_knochen;
	@FXML
	private CheckBox metastasen_lunge;
	@FXML
	private CheckBox metastasen_gehirn;
	@FXML
	private CheckBox metastasen_leber;
	@FXML
	private CheckBox metastasen_andere;
	@FXML
	private TextField metastasen_andere_text;
	@FXML
	private DatePicker rezidiv_zeitpunkt;
	@FXML
	private TextField hausarzt;
	@FXML
	private TextField frauenarzt;
	@FXML
	private TextField anmerkungen;
	@FXML
	private TextField information;
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tilePanePatient.collapsibleProperty().setValue(true);
		
		Platform.runLater(() -> {
			final Fall fall;
			try {
				fall = (Fall) tfId.getScene().getUserData();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			
			Patient patient = null;
			try {
				patient = patientRepository.findAllByFaelleContaining(fall);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			
			displayPatient(patient);
			displayAdresse(patient.getAdresse());
			displayPatientZusatzdaten(patient.getPatientenZusatzdaten());
		});
	}
	
	private void displayPatient(Patient patient) {
		tfId.setText(patient.getId().toString());
		tfVorname.setText(patient.getVorname());
		tfNachname.setText(patient.getNachname());
		tfAlternativname.setText(patient.getAlternativName());
		dpGeburtsdatum.setValue(patient.getGeburtsDatum());
	}
	
	private void displayAdresse(Adresse adresse) {
		if (adresse == null) {
			return;
		}
		
		tfStrasse.setText(adresse.getStrasse());
		tfHausnummer.setText(adresse.getHausnummer());
		tfPLZ.setText(adresse.getPlz());
		tfOrt.setText(adresse.getOrt());
		tfLand.setText(adresse.getLand());
	}
	
	private void displayPatientZusatzdaten(PatientenZusatzdaten zusatzdaten) {
		if (zusatzdaten == null) {
			return;
		}
		
		tfPseudonym.setText(zusatzdaten.getPseudonym());
		displayEE2015(zusatzdaten.getEe2015());
	}
	
	private void displayEE2015(EE2015 ee2015) {
		if (ee2015 == null) {
			return;
		}
		
		tfPseudonym2.setText(ee2015.getPseudonym2());
		tfStatus.setText(ee2015.getStatus());
		dpDatum.setValue(ee2015.getDatum());
		tfTodQuelle.setText(ee2015.getTodQuelle());
		dpTodDatum.setValue(ee2015.getTodDatum());
		tfNotizen.setText(ee2015.getNotizen());
		welle.setText(ee2015.getWelle());
		rawid.setText(ee2015.getRawid());
		source.setText(ee2015.getSource());
		zeit.setText(ee2015.getZeit());
		chemo.setText(ee2015.getChemo());
		chemo_zeitpunkt.setText(ee2015.getChemo_zeitpunkt());
		medikamente.setText(ee2015.getMedikamente());
		bestrahlung.setText(ee2015.getBestrahlung());
		med_anithormon.setSelected(ee2015.getMed_anithormon());
		med_antihormon_unbekannt.setSelected(ee2015.getMed_antihormon_unbekannt());
		med_antihormon_tamoxifen.setSelected(ee2015.getMed_antihormon_tamoxifen());
		med_antihormon_arimidex.setSelected(ee2015.getMed_antihormon_arimidex());
		med_antihormon_aromasin.setSelected(ee2015.getMed_antihormon_aromasin());
		med_antihormon_fe03a.setSelected(ee2015.getMed_antihormon_fe03a());
		herceptin.setText(ee2015.getHerceptin());
		biophosphonaten.setText(ee2015.getBiophosphonaten());
		biophosphaten_text.setText(ee2015.getBiophosphaten_text());
		weitere_erkrankung.setText(ee2015.getWeitere_erkrankung());
		rezidiv.setSelected(ee2015.getRezidiv());
		metastasen.setSelected(ee2015.getMetastasen());
		metastasen_abrust.setSelected(ee2015.getMetastasen_abrust());
		metastasen_lymphknoten.setSelected(ee2015.getMetastasen_lymphknoten());
		metastasen_knochen.setSelected(ee2015.getMetastasen_knochen());
		metastasen_lunge.setSelected(ee2015.getMetastasen_lunge());
		metastasen_gehirn.setSelected(ee2015.getMetastasen_gehirn());
		metastasen_leber.setSelected(ee2015.getMetastasen_leber());
		metastasen_andere.setSelected(ee2015.getMetastasen_andere());
		metastasen_andere_text.setText(ee2015.getMetastasen_andere_text());
		rezidiv_zeitpunkt.setValue(ee2015.getRezidiv_zeitpunkt());
		hausarzt.setText(ee2015.getHausarzt());
		frauenarzt.setText(ee2015.getFrauenarzt());
		anmerkungen.setText(ee2015.getAnmerkungen());
		information.setText(ee2015.getInformation());
	}
}
