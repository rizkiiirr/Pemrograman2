package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Tabel mahasiswa = new Tabel();
    		Scene scene = new Scene(mahasiswa.getDaftar(), 400, 270);
    		primaryStage.setScene(scene);
 
            primaryStage.setTitle("Daftar Mahasiswa");
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
