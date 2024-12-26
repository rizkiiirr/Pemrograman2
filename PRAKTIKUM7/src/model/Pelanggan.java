package model;

public class Pelanggan {
	private String IdPelanggan;
	private String nama;
	private String email;
	private String telepon;
	
	public Pelanggan(String IdPelanggan, String nama, String email, String telepon) {
		this.IdPelanggan = IdPelanggan;
		this.nama = nama;
		this.email = email;
		this.telepon = telepon;
	}
	
	// Getter and Setter methods
    public String getIdPelanggan() {
        return IdPelanggan;
    }

    public void setIdPelanggan(String IdPelanggan) {
        this.IdPelanggan = IdPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
}