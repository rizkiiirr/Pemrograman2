package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import basisdata.BasisData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Buku;
import model.Pelanggan;
import model.Penjualan;

public class TabelController {
	@FXML
	private TextField fieldIdPenjualan;
	@FXML
	private TextField fieldJumlah;
	@FXML
	private TextField fieldTotalHarga;
	@FXML
	private DatePicker fieldTanggal;
	
	@FXML
	private TextField fieldIdPelanggan;
	@FXML
	private TextField fieldNama;
	@FXML
	private TextField fieldEmail;
	@FXML
	private TextField fieldTelepon;
	
	@FXML
	private TextField fieldIdBuku;
	@FXML
	private TextField fieldJudul;
	@FXML
	private TextField fieldPenulis;
	@FXML
	private TextField fieldHarga;
	@FXML
	private TextField fieldStok;
	
	@FXML
	private TableView <Penjualan> tblPenjualan;
	@FXML
	private TableColumn <Penjualan, String> clmIdPenjualan;
	@FXML
	private TableColumn <Penjualan, String> clmJumlah;
	@FXML
	private TableColumn <Penjualan, Long> clmTotalHarga;
	@FXML
	private TableColumn <Penjualan, Date> clmTanggal;
	
	@FXML
	private TableView <Pelanggan> tblPelanggan;
	@FXML
	private TableColumn <Pelanggan, String> clmIdPelanggan;
	@FXML
	private TableColumn <Pelanggan, String> clmNama;
	@FXML
	private TableColumn <Pelanggan, String> clmEmail;
	@FXML
	private TableColumn <Pelanggan, Long> clmTelepon;
	
	@FXML
	private TableView <Buku> tblBuku;
	@FXML
	private TableColumn <Buku, String> clmIdBuku;
	@FXML
	private TableColumn <Buku, String> clmJudul;
	@FXML
	private TableColumn <Buku, Long> clmPenulis;
	@FXML
	private TableColumn <Buku, Date> clmHarga;
	@FXML
	private TableColumn <Buku, String> clmStok;

	private ObservableList <Penjualan> dataPenjualan;
	
	private ObservableList <Pelanggan> dataPelanggan;
	
	private ObservableList <Buku> dataBuku;
	
	private Connection conn;
	
	public void initialize() {
		try {
			conn = BasisData.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		clmIdPenjualan.setCellValueFactory(new PropertyValueFactory<>("idPenjualan"));
		clmJumlah.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
		clmTotalHarga.setCellValueFactory(new PropertyValueFactory<>("totalHarga"));
		clmTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));

		tblPenjualan.setOnMouseClicked(event -> {
			Penjualan selectedPenjualan = tblPenjualan.getSelectionModel().getSelectedItem();
			fieldIdPenjualan.setText(selectedPenjualan.getIdPenjualan());
			fieldJumlah.setText(String.valueOf(selectedPenjualan.getJumlah()));
			fieldTotalHarga.setText(String.valueOf(selectedPenjualan.getTotalHarga()));
			fieldTanggal.setValue(selectedPenjualan.getTanggal());
		});
		
		loadDataFromDatabase1();
		
		
		clmIdPelanggan.setCellValueFactory(new PropertyValueFactory<>("idPelanggan"));
		clmNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
		clmEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		clmTelepon.setCellValueFactory(new PropertyValueFactory<>("telepon"));

		tblPelanggan.setOnMouseClicked(event -> {
			Pelanggan selectedPelanggan = tblPelanggan.getSelectionModel().getSelectedItem();
			fieldIdPelanggan.setText(selectedPelanggan.getIdPelanggan());
			fieldNama.setText(String.valueOf(selectedPelanggan.getNama()));
			fieldEmail.setText(String.valueOf(selectedPelanggan.getEmail()));
			fieldTelepon.setText(selectedPelanggan.getTelepon());
		});
		
		loadDataFromDatabase2();
		
		
		clmIdBuku.setCellValueFactory(new PropertyValueFactory<>("idBuku"));
		clmJudul.setCellValueFactory(new PropertyValueFactory<>("judul"));
		clmPenulis.setCellValueFactory(new PropertyValueFactory<>("penulis"));
		clmHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
		clmStok.setCellValueFactory(new PropertyValueFactory<>("stok"));

		tblBuku.setOnMouseClicked(event -> {
			Buku selectedBuku = tblBuku.getSelectionModel().getSelectedItem();
			fieldIdBuku.setText(selectedBuku.getIdBuku());
			fieldJudul.setText(selectedBuku.getJudul());
			fieldPenulis.setText(selectedBuku.getPenulis());
			fieldHarga.setText(String.valueOf(selectedBuku.getHarga()));
			fieldStok.setText(String.valueOf(selectedBuku.getStok()));
		});
		
		loadDataFromDatabase3();
	}
	
	private void loadDataFromDatabase1() {
		dataPenjualan = FXCollections.observableArrayList();
		
		try(Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM penjualan");
		){
			while(rs.next()) {
				String idPenjualan = rs.getString("Id_Penjualan");
				int jumlah = rs.getInt("Jumlah");
				Long totalHarga = rs.getLong("Total_Harga");
				LocalDate tanggal = rs.getDate("Tanggal").toLocalDate();
				
				dataPenjualan.add(new Penjualan(idPenjualan, jumlah, totalHarga, tanggal));
			}
			
			tblPenjualan.setItems(dataPenjualan);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void addData1() {
		String idPenjualan = fieldIdPenjualan.getText();
		int jumlah = Integer.valueOf(fieldJumlah.getText());
		Long totalHarga = Long.valueOf(fieldTotalHarga.getText());
		Date tanggal = Date.valueOf(fieldTanggal.getValue());
		
		String query = "INSERT INTO penjualan (Id_Penjualan, Jumlah, Total_Harga, Tanggal) VALUES (?, ?, ?, ?)";
		
		if(idPenjualan.isEmpty()) {
			showAlert1(AlertType.ERROR, "Peringatan", "Id Penjualan tidak boleh kosong");
		}
		else {
			try (PreparedStatement stat =  conn.prepareStatement(query);
			){
				stat.setString(1, idPenjualan);
				stat.setInt(2, jumlah);
				stat.setLong(3, totalHarga);
				stat.setDate(4, tanggal);
				stat.executeUpdate();
				
			} catch (Exception e) {
				showAlert1(AlertType.ERROR, "Peringatan", e.getMessage());
			}
		}
		
		loadDataFromDatabase1();
	}
	
	@FXML
	public void updateData1() {
		Penjualan selectedPenjualan = tblPenjualan.getSelectionModel().getSelectedItem();
		String query = "UPDATE penjualan SET Id_Penjualan = ?, Jumlah = ?, Total_Harga = ?, Tanggal = ? WHERE Id_Penjualan = ?";
		
		String idPenjualan = fieldIdPenjualan.getText();
		int jumlah = Integer.valueOf(fieldJumlah.getText());
		Long totalHarga = Long.valueOf(fieldTotalHarga.getText());
		Date tanggal = Date.valueOf(fieldTanggal.getValue());	
		
		if(idPenjualan.isEmpty()) {
			
			showAlert1(AlertType.ERROR, "Peringatan", "Id Penjualan tidak boleh kosong");
		}
		else {
			try (PreparedStatement stat = conn.prepareStatement(query);
			){
				stat.setString(1, idPenjualan);
				stat.setInt(2, jumlah);
				stat.setLong(3, totalHarga);
				stat.setDate(4, tanggal);
				stat.setString(5, selectedPenjualan.getIdPenjualan());
				stat.executeUpdate();
				
			} catch (SQLException e) {
				showAlert1(AlertType.ERROR, "Peringatan", e.getMessage());
			}
		}
		 
		loadDataFromDatabase1();
	}
	
	@FXML
	public void deleteData1() {
		Penjualan selectedPenjualan = tblPenjualan.getSelectionModel().getSelectedItem();
		String query = "DELETE FROM penjualan WHERE Id_Penjualan = ?";
		
		try(PreparedStatement stat = conn.prepareStatement(query);
		) {
			String idPenjualan = selectedPenjualan.getIdPenjualan();
			stat.setString(1, idPenjualan);
			stat.executeUpdate();
			
		} catch (SQLException e) {
			showAlert1(AlertType.ERROR, "Peringatan", e.getMessage());
		}
		
		loadDataFromDatabase1();
	}
	
	@FXML
	public void clear1() {
		fieldIdPenjualan.clear(); 
		fieldJumlah.clear();
		fieldTotalHarga.clear();
		fieldTanggal.setValue(null);
	}
	
	public void showAlert1(AlertType type, String title, String content) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
		alert.showAndWait();
	}
	
	private void loadDataFromDatabase2() {
		dataPelanggan = FXCollections.observableArrayList();
		
		try(Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM pelanggan");
		){
			while(rs.next()) {
				String idPelanggan = rs.getString("Id_Pelanggan");
				String nama = rs.getString("Nama_Pelanggan");
				String email = rs.getString("Email");
				String telepon = rs.getString("Telepon");
				
				dataPelanggan.add(new Pelanggan(idPelanggan, nama, email, telepon));
			}
			
			tblPelanggan.setItems(dataPelanggan);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void addData2() {
		String idPelanggan = fieldIdPelanggan.getText();
		String nama = fieldNama.getText();
		String email = fieldEmail.getText();
		String telepon = fieldTelepon.getText();
		
		String query = "INSERT INTO pelanggan (Id_Pelanggan, Nama_Pelanggan, Email, Telepon) VALUES (?, ?, ?, ?)";
		
		if(idPelanggan.isEmpty()) {
			showAlert2(AlertType.ERROR, "Peringatan", "Id Pelanggan tidak boleh kosong");
		}
		else {
			try (PreparedStatement stat =  conn.prepareStatement(query);
			){
				stat.setString(1, idPelanggan);
				stat.setString(2, nama);
				stat.setString(3, email);
				stat.setString(4, telepon);
				stat.executeUpdate();
				
			} catch (Exception e) {
				showAlert2(AlertType.ERROR, "Peringatan", e.getMessage());
			}
		}
		
		loadDataFromDatabase2();
	}
	
	@FXML
	public void updateData2() {
		Pelanggan selectedPelanggan = tblPelanggan.getSelectionModel().getSelectedItem();
		String query = "UPDATE pelanggan SET Id_Pelanggan = ?, Nama_Pelanggan = ?, Email = ?, Telepon = ? WHERE Id_Pelanggan = ?";
		
		String idPelanggan = fieldIdPelanggan.getText();
		String nama = fieldNama.getText();
		String email = fieldEmail.getText();
		String telepon = fieldTelepon.getText();
		
		if(idPelanggan.isEmpty()) {
			
			showAlert2(AlertType.ERROR, "Peringatan", "Id Pelanggan tidak boleh kosong");
		}
		else {
			try (PreparedStatement stat = conn.prepareStatement(query);
			){
				stat.setString(1, idPelanggan);
				stat.setString(2, nama);
				stat.setString(3, email);
				stat.setString(4, telepon);
				stat.setString(5, selectedPelanggan.getIdPelanggan());
				stat.executeUpdate();
				
			} catch (SQLException e) {
				showAlert2(AlertType.ERROR, "Peringatan", e.getMessage());
			}
		}
		 
		loadDataFromDatabase2();
	}
	
	@FXML
	public void deleteData2() {
		Pelanggan selectedPelanggan = tblPelanggan.getSelectionModel().getSelectedItem();
		String query = "DELETE FROM pelanggan WHERE Id_Pelanggan = ?";
		
		try(PreparedStatement stat = conn.prepareStatement(query);
		) {
			String idPelanggan = selectedPelanggan.getIdPelanggan();
			stat.setString(1, idPelanggan);
			stat.executeUpdate();
			
		} catch (SQLException e) {
			showAlert2(AlertType.ERROR, "Peringatan", e.getMessage());
		}
		
		loadDataFromDatabase2();
	}
	
	@FXML
	public void clear2() {
		fieldIdPelanggan.clear(); 
		fieldNama.clear();
		fieldEmail.clear();
		fieldTelepon.clear();
	}
	
	public void showAlert2(AlertType type, String title, String content) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
		alert.showAndWait();
	}
	
	private void loadDataFromDatabase3() {
		dataBuku = FXCollections.observableArrayList();
		
		try(Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM buku");
		){
			while(rs.next()) {
				String idBuku = rs.getString("Id_Buku");
				String judul = rs.getString("Judul");
				String penulis = rs.getString("Penulis");
				Long harga = rs.getLong("Harga");
				int stok = rs.getInt("Stok");
				
				dataBuku.add(new Buku(idBuku, judul, penulis, harga, stok));
			}
			
			tblBuku.setItems(dataBuku);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void addData3() {
		String idBuku = fieldIdBuku.getText();
		String judul = fieldJudul.getText();
		String penulis = fieldPenulis.getText();
		Long harga = Long.valueOf(fieldHarga.getText());
		int stok = Integer.valueOf(fieldStok.getText());
		
		String query = "INSERT INTO buku (Id_Buku, Judul, Penulis, Harga, Stok) VALUES (?, ?, ?, ?, ?)";
		
		if(idBuku.isEmpty()) {
			showAlert3(AlertType.ERROR, "Peringatan", "Id Buku tidak boleh kosong");
		}
		else {
			try (PreparedStatement stat =  conn.prepareStatement(query);
			){
				stat.setString(1, idBuku);
				stat.setString(2, judul);
				stat.setString(3, penulis);
				stat.setLong(4, harga);
				stat.setInt(5, stok);
				stat.executeUpdate();
				
			} catch (Exception e) {
				showAlert1(AlertType.ERROR, "Peringatan", e.getMessage());
			}
		}
		
		loadDataFromDatabase3();
	}
	
	@FXML
	public void updateData3() {
		Buku selectedBuku = tblBuku.getSelectionModel().getSelectedItem();
		String query = "UPDATE buku SET Id_Buku = ?, Judul = ?, Penulis = ?, Harga = ?, Stok = ? WHERE Id_Buku = ?";
		
		String idBuku = fieldIdBuku.getText();
		String judul = fieldJudul.getText();
		String penulis = fieldPenulis.getText();
		Long harga = Long.valueOf(fieldHarga.getText());
		int stok = Integer.valueOf(fieldStok.getText());
		
		if(idBuku.isEmpty()) {
			
			showAlert3(AlertType.ERROR, "Peringatan", "Id Buku tidak boleh kosong");
		}
		else {
			try (PreparedStatement stat = conn.prepareStatement(query);
			){
				stat.setString(1, idBuku);
				stat.setString(2, judul);
				stat.setString(3, penulis);
				stat.setLong(4, harga);
				stat.setInt(5, stok);
				stat.setString(6, selectedBuku.getIdBuku());
				stat.executeUpdate();
				
			} catch (SQLException e) {
				showAlert1(AlertType.ERROR, "Peringatan", e.getMessage());
			}
		}
		 
		loadDataFromDatabase3();
	}
	
	@FXML
	public void deleteData3() {
		Buku selectedBuku = tblBuku.getSelectionModel().getSelectedItem();
		String query = "DELETE FROM buku WHERE Id_Buku = ?";
		
		try(PreparedStatement stat = conn.prepareStatement(query);
		) {
			String idBuku = selectedBuku.getIdBuku();
			stat.setString(1, idBuku);
			stat.executeUpdate();
			
		} catch (SQLException e) {
			showAlert1(AlertType.ERROR, "Peringatan", e.getMessage());
		}
		
		loadDataFromDatabase3();
	}
	
	@FXML
	public void clear3() {
		fieldIdBuku.clear(); 
		fieldJudul.clear();
		fieldPenulis.clear();
		fieldHarga.clear();
		fieldStok.clear();
	}
	
	public void showAlert3(AlertType type, String title, String content) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
		alert.showAndWait();
	}
}