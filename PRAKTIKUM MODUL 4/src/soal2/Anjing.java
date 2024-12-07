package soal2;

public class Anjing extends HewanPeliharaan{
	private String warnaBulu;
	private String kemampuan;
	
	public Anjing(String nama, String ras, String warnaBulu, String kemampuan) {
		super(nama, ras);
		this.warnaBulu = warnaBulu;
		this.kemampuan = kemampuan;
	}
	
	public void Anjing (String n, String r, String w, String k) {
		HewanPeliharaan(n, r);
		this.warnaBulu = w;
		this.kemampuan = k;
	}
	
	public void displayDetailAnjing() {
		display();
		System.out.println("Memiliki warna bulu : " + warnaBulu);
        System.out.println("Memiliki kemampuan : " + kemampuan);
	}
}