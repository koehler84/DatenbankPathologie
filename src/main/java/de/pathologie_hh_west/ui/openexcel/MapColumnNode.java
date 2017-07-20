package de.pathologie_hh_west.ui.openexcel;

import de.pathologie_hh_west.model.Adresse;
import de.pathologie_hh_west.model.Patient;
import de.pathologie_hh_west.model.PatientenZusatzdaten;
import de.pathologie_hh_west.ui.util.StageManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by eike on 16.07.2017.
 */
@Component
@Scope("prototype")
public class MapColumnNode implements Initializable {
	
	@FXML
	private ChoiceBox<Field> cbDatabaseField;
	@FXML
	private ChoiceBox<Field> cbExcelColumn;
	@Autowired
	private StageManager stageManager;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbDatabaseField.setConverter(new StringConverter<Field>() {
			private Map<String, Field> fields = new HashMap<>();
			
			@Override
			public String toString(Field object) {
				fields.put(object.getName(), object);
				return object.getName();
			}
			
			@Override
			public Field fromString(String string) {
				return fields.get(string);
			}
		});
		
		List<Field> fields = Arrays.stream(Patient.class.getDeclaredFields())
				.filter(field -> !field.getType().equals(Adresse.class))
				.filter(field -> !field.getName().equals("faelle"))
				.filter(field -> !field.getType().equals(PatientenZusatzdaten.class))
				.collect(Collectors.toList());
		
		fields.addAll(Arrays.asList(Adresse.class.getDeclaredFields()));
		
		cbDatabaseField.setItems(FXCollections.observableList(fields));
	}
}
