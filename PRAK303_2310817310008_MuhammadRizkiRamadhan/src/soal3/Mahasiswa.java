
package soal3;

public class Mahasiswa {
	String nama;
	long nim;
	
	public Mahasiswa(String nama, long nim) {
		this.nama = nama;
		this.nim = nim;
	}
	
	public String getNama() {
		return nama;
	}
	
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public long getNIM() {
		return nim;
	}
	
	public void setNIM(int nim) {
		this.nim = nim;
	}
	
	public void lihatDaftarMahasiswa() {
		System.out.println("NIM Mahasiswa: " + nim + ", Nama Mahasiswa: " + nama);
	}
}
 