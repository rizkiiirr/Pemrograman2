package model;

import java.time.LocalDate;

public class Penjualan {
	private String idPenjualan;
	private int jumlah;
	private Long totalHarga;
	private LocalDate tanggal;
	
	public Penjualan(String idPenjualan, int jumlah, Long totalHarga, LocalDate tanggal) {
		this.idPenjualan = idPenjualan;
		this.jumlah = jumlah;
		this.totalHarga = totalHarga;
		this.tanggal = tanggal;
	}
	
	public String getIdPenjualan() {
        return idPenjualan;
    }

    public void setIdPenjualan(String idPenjualan) {
        this.idPenjualan = idPenjualan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Long getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(Long totalHarga) {
        this.totalHarga = totalHarga;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }
}