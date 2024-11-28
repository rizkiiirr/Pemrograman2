package soal3;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private ArrayList <Mahasiswa> dataMahasiswa = new ArrayList<>();
	private Scanner input = new Scanner(System.in);
	
	public void tampilkanDaftarMahasiswa() {
		if (dataMahasiswa.isEmpty()) {
			System.out.print("Daftar Mahasiswa Kosong"); //KONDISI APABILA DAFTAR BARANG KOSONG
			return;
		}
		else { 		
			System.out.print("Daftar Mahasiswa: \n");
			int a = 0;
			while (a < dataMahasiswa.size()) {	
				dataMahasiswa.get(a).lihatDaftarMahasiswa();
			a++;
			}
		}
	}
	
	public void tambahDataMahasiswa() {
		
		System.out.print("Masukkan Nama Mahasiswa: ");
		String nama_Mahasiswa = input.nextLine();

		System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
        Long nim_Mahasiswa = input.nextLong();
        input.nextLine();
        
        boolean sudahAda = false;
		int a = 0;
																			//VALIDASI SAAT MENAMBAHKAN DATA BARANG DENGAN MELIHAT ID BARANG
		while (a < dataMahasiswa.size()) {
			if(dataMahasiswa.get(a).getNIM() == nim_Mahasiswa) {
				sudahAda = true;
				break;
				}
				a++;
	    }
			if(sudahAda) {
			System.out.print("Mahasiswa dengan NIM " +nim_Mahasiswa+ " Sudah Ada.");
			return;
		    }
			else {
				Mahasiswa mahasiswaBaru = new Mahasiswa(nama_Mahasiswa, nim_Mahasiswa);
				dataMahasiswa.add(mahasiswaBaru);
						
				System.out.println("Mahasiswa " +nama_Mahasiswa+ " ditambahkan."); 
		}
	}
		
	public void hapusDataMahasiswa() { 
		System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
		Long nim_mahasiswa = input.nextLong();
		input.nextLine();
		
		int a = 0;
		while (a < dataMahasiswa.size()) {
            if (dataMahasiswa.get(a).getNIM() == nim_mahasiswa) {
            	dataMahasiswa.remove(a);
                System.out.println("Mahasiswa dengan NIM " + nim_mahasiswa + " dihapus.");
                return;
            }
            a++;
        }
        System.out.println("Mahasiswa dengan NIM " + nim_mahasiswa + " Tidak Ditemukan.");
	}
	
	public void cariDataMahasiswa() { //berd.NIM
		System.out.print("Masukkan NIM Mahasiswa yang akan dicari: ");
		Long nim_mahasiswa = input.nextLong();
		input.nextLine();
		
		int a = 0;
		while (a < dataMahasiswa.size()) {
			if(dataMahasiswa.get(a).getNIM() == nim_mahasiswa) {
				dataMahasiswa.get(a).lihatDaftarMahasiswa();
				return;
			}
			a++;
		}
		System.out.println("Mahasiswa dengan NIM " + nim_mahasiswa + " Tidak Ditemukan.");
	}
	
	public static void main(String[] args) {
		Main mahasiswa = new Main(); 
		Scanner input = new Scanner(System.in);
		
		int pilihan;
		
		do {
			System.out.println("\nMenu:");
			System.out.println("1. Tambah Mahasiswa");
			System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
			System.out.println("3. Cari Mahasiswa berdasarkan NIM");
			System.out.println("4. Tampilkan Daftar Mahasiswa");
			System.out.println("0. Keluar");
			System.out.print("Pilihan: ");
			pilihan = input.nextInt();
			input.nextLine();
			System.out.println("");
			
			switch (pilihan) {
			case 1:
				mahasiswa.tambahDataMahasiswa();				
				break;
			case 2:
				mahasiswa.hapusDataMahasiswa(); 
				break;
			case 3:
				mahasiswa.cariDataMahasiswa(); 
				break;
			case 4:
				mahasiswa.tampilkanDaftarMahasiswa();
				break;
			case 0:
				System.out.println("Terima kasih!");
				break;
				
			default:
				System.out.println("Pilihan Tidak Ada Pada Menu.");
				break;
			}
		} while (pilihan != 0);
		
		input.close();
	}
}
