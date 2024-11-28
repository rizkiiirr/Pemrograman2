package soal2;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
        LinkedList <Negara> daftarNegara = new LinkedList<Negara>();
        Scanner input = new Scanner(System.in);

        HashMap <Integer, String> bulanMap = new HashMap<Integer, String>();
        bulanMap.put(1, "Januari");
        bulanMap.put(2, "Februari");
        bulanMap.put(3, "Maret");
        bulanMap.put(4, "April");
        bulanMap.put(5, "Mei");
        bulanMap.put(6, "Juni");
        bulanMap.put(7, "Juli");
        bulanMap.put(8, "Agustus");
        bulanMap.put(9, "September");
        bulanMap.put(10, "Oktober");
        bulanMap.put(11, "November");
        bulanMap.put(12, "Desember");

        System.out.print("");
        int jumlahNegara = input.nextInt();
        input.nextLine();
        
        int a = 0;
        while (a < jumlahNegara) {

            System.out.print("");
            String nama = input.nextLine();

            System.out.print("");
            String jenisKepemimpinan = input.nextLine();

            System.out.print("");
            String namaPemimpin = input.nextLine();

            int tanggalKemerdekaan = 0, bulanKemerdekaan = 0
            		, tahunKemerdekaan = 0;

            if (!jenisKepemimpinan.equalsIgnoreCase("Monarki")) {
                System.out.print("");
                tanggalKemerdekaan = input.nextInt();
                System.out.print("");
                bulanKemerdekaan = input.nextInt();
                System.out.print("");
                tahunKemerdekaan = input.nextInt();
                input.nextLine();
            }

            Negara negara = new Negara(nama, jenisKepemimpinan, namaPemimpin, tanggalKemerdekaan, bulanKemerdekaan, tahunKemerdekaan);
            daftarNegara.add(negara);
            
            a++;
        }

        int b = 0;
        while (b < daftarNegara.size()) {
        	Negara negara = daftarNegara.get(b);
        	negara.tampilkanInfo(bulanMap);
        	
        	b++;
        }

        input.close();
	}

}
