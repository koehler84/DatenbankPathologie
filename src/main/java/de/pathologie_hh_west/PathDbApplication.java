package de.pathologie_hh_west;

import de.pathologie_hh_west.ui.util.FMXLView;
import de.pathologie_hh_west.ui.util.StageManager;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PathDbApplication extends Application {
	
	private ConfigurableApplicationContext springContext;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void init() throws Exception {
		super.init();
		springContext = SpringApplication.run(PathDbApplication.class);
	}
	
	public void start(Stage primaryStage) throws Exception {
		StageManager stageManager = springContext.getBean(StageManager.class, primaryStage);
		stageManager.switchScene(FMXLView.MAIN);
	}
	
	@Override
	public void stop() throws Exception {
		super.stop();
		springContext.stop();
	}
}
