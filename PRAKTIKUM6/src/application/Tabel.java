package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class Tabel {
	public VBox getDaftar() {
		TableView <Mahasiswa> tableView = new TableView<>();
		TableColumn <Mahasiswa, String> column1 = new TableColumn<>("NIM");
		column1.setCellValueFactory(new PropertyValueFactory<>("nim"));
		TableColumn<Mahasiswa, String> column2 = new TableColumn<>("Nama");
		column2.setCellValueFactory(new PropertyValueFactory<>("nama"));
		
		tableView.getColumns().add(column1);
		tableView.getColumns().add(column2);
		
		
		
		tableView.getItems().add(new Mahasiswa(1, "2310817310008", "Muhammad Rizki Ramadhan"));
		tableView.getItems().add(new Mahasiswa(2, "2310817110008", "Muhammad Raihan"));
		tableView.getItems().add(new Mahasiswa(3, "2310817210013", "Muhammad Aufa Fitrianda"));
		tableView.getItems().add(new Mahasiswa(4, "2310817310002", "Jovan Gilbert Natamasindah"));
		tableView.getItems().add(new Mahasiswa(5, "2310817110007", "Muhammad Daffa Musyafa"));
		tableView.getItems().add(new Mahasiswa(6, "2310817310009", "Muhammad Fauzan Ahsani"));
		tableView.getItems().add(new Mahasiswa(7, "2310817210015", "Muhammad Bukhari Fitri"));
		tableView.getItems().add(new Mahasiswa(8, "2310817210009", "Muhammad Ibnu Sina"));
		tableView.getItems().add(new Mahasiswa(9, "2310817210003", "Muhammad Azrianzan"));
		tableView.getItems().add(new Mahasiswa(10, "2310817210022", "Muhammad Adh-Dhiya'Us Salim"));
		
		tableView.setOnMouseClicked(e->{
			Mahasiswa daftarMahasiswa = tableView.getSelectionModel().getSelectedItem();
			if(daftarMahasiswa != null) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Detail Informasi");
				alert.setHeaderText("Daftar Mahasiswa");
				alert.setContentText("Nama Mahasiswa: " + daftarMahasiswa.getNama() + "\nNIM Mahasiswa: " + daftarMahasiswa.getNim());
				alert.showAndWait();
			}
			
		});
		
		VBox vbox = new VBox(tableView);
		vbox.setStyle("-fx-padding: 0,0");
		return vbox;
	}
}