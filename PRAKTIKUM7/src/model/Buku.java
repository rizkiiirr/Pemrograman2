package model;

public class Buku {
	private String idBuku;
	private String judul;
	private String penulis;
	private Long harga;
	private int stok;
	
	public Buku(String idBuku, String judul, String penulis, Long harga, int stok) {
		this.idBuku = idBuku;
		this.judul = judul;
		this.penulis = penulis;
		this.harga = harga;
		this.stok = stok;
	}
	
	public String getIdBuku() {
        return idBuku;
    }

    public void setBukuId(String idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public Long getHarga() {
        return harga;
    }

    public void setHarga(Long harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}
