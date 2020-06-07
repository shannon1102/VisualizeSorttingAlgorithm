package application;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
public class Main extends Application{
	@Override
	public void start(Stage primaryStage){
		// TODO Auto-generated method stub
		try {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("one_window.fxml"));
		AnchorPane layout = loader.load();
		Scene scene = new Scene(layout);	
		primaryStage.setScene(scene);
		primaryStage.setTitle("Menu");
		primaryStage.setResizable(false);
//		primaryStage.setFullScreen(true);
		primaryStage.show();
		}catch (IOException e) {
			e.printStackTrace();
		}
}
public static void main(String[] args)
{
	launch(args);
}
}