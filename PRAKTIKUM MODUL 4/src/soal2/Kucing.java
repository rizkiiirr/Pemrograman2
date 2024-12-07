package soal2;

public class Kucing extends HewanPeliharaan {
	private String warnaBulu;

	public Kucing(String nama, String ras, String warnaBulu) {
		super(nama, ras);
		this.warnaBulu = warnaBulu;
	}
	
	public void Kucing(String n, String r, String w) {
		HewanPeliharaan(n, r);
		this.warnaBulu = w;
	}
	
	public void displayDetailKucing() {
		display();
		System.out.println("Memiliki warna bulu: " + warnaBulu);
	}
}
