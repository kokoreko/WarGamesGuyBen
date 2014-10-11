package main;

import java.io.File;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Missile.AddMissile;

public class RemoteWarClinet extends Application {
		public static void main(String[] arguments) {
			launch(arguments);
		}
		@Override
		public void start(final Stage stage) throws Exception {
			FXMLLoader f = new FXMLLoader();

			Parent fxmlRoot = (Parent) f.load(new FileInputStream(new File(
					"bin\\main.fxml")));
			Font.loadFont(RemoteWarClinet.class.getResource("DS-DIGII.TTF").toExternalForm(),12);

			Scene scene = new Scene(fxmlRoot);
			//scene.getStylesheets().add(
			//		AddMissile.class.getResource("..\\Login.css")
			//				.toExternalForm());
			stage.setScene(scene);
			stage.show();
			
		
		}
}
