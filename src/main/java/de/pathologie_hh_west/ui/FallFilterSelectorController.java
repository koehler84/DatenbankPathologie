package de.pathologie_hh_west.ui;

import de.pathologie_hh_west.data.FallQueryExecutor;
import de.pathologie_hh_west.model.Fall;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;
import org.controlsfx.validation.decoration.GraphicValidationDecoration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by eike on 12.07.2017.
 */
@Component
@Scope("prototype")
public class FallFilterSelectorController implements Initializable {
	
	@FXML private ChoiceBox<String> columnSelection;
	@FXML private TextField expression;
	@FXML private Button btnRemove;
	@FXML private Button btnEquality;
	private FallQueryExecutor.Equality equality;
	
	public FallFilterSelectorController() {
		equality = FallQueryExecutor.Equality.EQUAL;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		expression.setText("");
		btnRemove.setGraphic(new Glyph("FontAwesome", FontAwesome.Glyph.REMOVE));
		columnSelection.setItems(FXCollections.observableList(getFieldNames()));
		
		ValidationSupport vsExpression = new ValidationSupport();
		vsExpression.registerValidator(expression, false, Validator.createEmptyValidator(""));
		vsExpression.initInitialDecoration();
		
		ValidationSupport vsChoice = new ValidationSupport();
		vsChoice.registerValidator(columnSelection, false, Validator.createEmptyValidator(""));
		vsChoice.setValidationDecorator(new GraphicValidationDecoration());
		vsChoice.initInitialDecoration();
		vsChoice.setErrorDecorationEnabled(true);
		
		btnEquality.addEventHandler(ActionEvent.ANY, event -> {
			this.equality = this.equality.getNext();
			btnEquality.setText(this.equality.getStringOperator());
		});
	}
	
	private List<String> getFieldNames() {
		List<String> strings = new ArrayList<>();
		try {
			Field[] fallIDFields = Fall.class.getDeclaredField("fallID").getType().getDeclaredFields();
			strings.addAll(Arrays.stream(fallIDFields)
					.map(Field::getName)
					.map("fallID."::concat)
					.collect(Collectors.toList()));
			
			Field[] klassifikationFields = Fall.class.getDeclaredField("klassifikation").getType().getDeclaredFields();
			strings.addAll(Arrays.stream(klassifikationFields)
					.map(Field::getName)
					.map("klassification."::concat)
					.collect(Collectors.toList()));
			
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
		return strings;
	}
}
