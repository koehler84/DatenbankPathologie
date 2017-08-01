package de.pathologie_hh_west.ui;

import de.pathologie_hh_west.data.FallQueryExecutor;
import de.pathologie_hh_west.data.FallRepository;
import de.pathologie_hh_west.model.Fall;
import de.pathologie_hh_west.model.FallID;
import de.pathologie_hh_west.ui.util.FXMLView;
import de.pathologie_hh_west.ui.util.SpringFXMLLoader;
import de.pathologie_hh_west.ui.util.StageManager;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by eike on 10.07.2017.
 */
@Component
@Scope("prototype")
public class FallViewController implements Initializable {
	
	@FXML
	private VBox filters;
	@FXML
	private Button btnAddFilter;
	@FXML
	private Button btnSuchen;
	@FXML
	private TableView<Fall> tableView;
	private SpringFXMLLoader springFXMLLoader;
	private FallQueryExecutor queryExecutor;
	private FallRepository fallRepository;
	private StageManager stageManager;
	
	@Autowired
	public FallViewController(SpringFXMLLoader springFXMLLoader, FallQueryExecutor queryExecutor, FallRepository fallRepository, StageManager stageManager) {
		this.springFXMLLoader = springFXMLLoader;
		this.queryExecutor = queryExecutor;
		this.fallRepository = fallRepository;
		this.stageManager = stageManager;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Parent parent = null;
		try {
			parent = springFXMLLoader.loadNewFXML("/ui/fxml/FallFilterSelector.fxml");
			filters.getChildren().add(parent);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		initTableView();
		
		filters.addEventHandler(ActionEvent.ANY, event -> {
			if (!((Node) event.getTarget()).getId().equals("btnRemove")) {
				return;
			}
			filters.getChildren().remove(((Node) event.getTarget()).getParent());
		});
		
		btnAddFilter.setOnAction(event -> {
			Parent localParent = null;
			try {
				localParent = springFXMLLoader.loadNewFXML("/ui/fxml/FallFilterSelector.fxml");
				filters.getChildren().add(localParent);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		btnSuchen.setOnAction(event -> {
			List<FallQueryExecutor.Filter> filterList = filters.getChildren().stream()
					.map(node -> {
						FallQueryExecutor.Filter filter = new FallQueryExecutor.Filter();
						ChoiceBox<String> columnSelection = ((ChoiceBox) ((HBox) node).getChildren()
								.stream()
								.filter(node1 -> node1.getId().equals("columnSelection"))
								.findFirst()
								.get());
						try {
							filter.setFieldName(columnSelection.getValue());
							
							Button btnEquality = ((Button) ((HBox) node).getChildren().stream().filter(node1 -> node1.getId().equals("btnEquality")).findFirst().get());
							filter.setEquality(FallQueryExecutor.Equality.fromString(btnEquality.getText()));
							
							TextField expression = ((TextField) ((HBox) node).getChildren().stream().filter(node1 -> node1.getId().equals("expression")).findFirst().get());
							filter.setFilterValue(expression.getText());
						} catch (IllegalArgumentException | NullPointerException e) {
							return null;
						}
						return filter;
					})
					.filter(Objects::nonNull)
					.collect(Collectors.toList());
			
			try {
				List<Fall> itemsByFilter = queryExecutor.getItemsByFilter(filterList);
				tableView.getItems().clear();
				tableView.getItems().addAll(itemsByFilter);
			} catch (IllegalArgumentException e) {
				Alert alert = new Alert(Alert.AlertType.WARNING, "Sie haben keine gültigen Filter hinzugefügt, " +
						"daher werden ALLE Daten aus der Datenbank abgerufen. Fortfahren?", ButtonType.YES, ButtonType.CANCEL);
				Optional<ButtonType> returnButton = alert.showAndWait();
				if (returnButton.isPresent() && returnButton.get() == ButtonType.YES) {
					List<Fall> fallList = fallRepository.findAll();
					tableView.getItems().clear();
					tableView.getItems().addAll(fallList);
				}
			}
		});
		
		tableView.setRowFactory(tv -> {
			final TableRow<Fall> tableRow = new TableRow<>();
			tableRow.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
				if (event.getClickCount() != 2) {
					return;
				}
				
				Fall item = tableRow.getItem();
				
				String stageName = "PatientView".concat(String.valueOf(item.getFallID().hashCode()));
				Stage stage = new Stage();
				Scene scene = new Scene(new VBox());
				scene.setUserData(item);
				stage.setScene(scene);
				stageManager.registerStage(stageName, stage);
				stageManager.switchScene(stageName, FXMLView.PATIENT_VIEW);
			});
			return tableRow;
		});
	}
	
	private void initTableView() {
		TableColumn<Fall, FallID> fallIDColumn = new TableColumn<>("Fall ID");
		TableColumn<Fall, String> eNummerColumn = new TableColumn<>("E-Nummer");
		eNummerColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getFallID().geteNummer().getValue()));
		TableColumn<Fall, String> befundTypColumn = new TableColumn<>("Befundtyp");
		befundTypColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<String>(cellData.getValue().getFallID().getBefundTyp().toString()));
		fallIDColumn.getColumns().add(eNummerColumn);
		fallIDColumn.getColumns().add(befundTypColumn);

		tableView.getColumns().add(fallIDColumn);
	}
}
