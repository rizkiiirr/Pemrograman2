package soal1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		LinkedList<Dadu> daftarNilai = new LinkedList<Dadu>();
		Scanner input = new Scanner(System.in);
		
		System.out.print("");
		int nilai = input.nextInt();
		
		int a = 0;
		while (a < nilai) {
			Dadu dadu = new Dadu();
			dadu.acakNilai();
			daftarNilai.add(dadu);
			a++;
		}
		
		int totalNilai = 0;
		int b = 0;
		while (b < daftarNilai.size()) {
			Dadu dadu = daftarNilai.get(b);
			daftarNilai.get(b);
			System.out.println("Dadu ke-" +(b+1)+ " bernilai " + dadu.getNilai());
			
			totalNilai += dadu.getNilai();
		    b++;
		}
		System.out.print("Total nilai dadu keseluruhan " + totalNilai );
		input.close();
	}
}
