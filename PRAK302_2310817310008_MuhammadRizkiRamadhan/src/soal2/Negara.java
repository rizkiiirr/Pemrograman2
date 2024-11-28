package soal2;

import java.util.HashMap;

public class Negara {

	    private String nama;
	    private String jenisKepemimpinan;
	    private String namaPemimpin;
	    private int tanggalKemerdekaan;
	    private int bulanKemerdekaan;
	    private int tahunKemerdekaan;
	    
	    
	    public Negara(String nama, String jenisKepemimpinan, String namaPemimpin, int tanggalKemerdekaan, int bulanKemerdekaan, int tahunKemerdekaan) {
	        this.nama = nama;
	        this.jenisKepemimpinan = jenisKepemimpinan;
	        this.namaPemimpin = namaPemimpin;
	        this.tanggalKemerdekaan = tanggalKemerdekaan;
	        this.bulanKemerdekaan = bulanKemerdekaan;
	        this.tahunKemerdekaan = tahunKemerdekaan;
	    }

	    public String getNama() {
	        return nama;
	    }

	    public String getJenisKepemimpinan() {
	        return jenisKepemimpinan;
	    }

	    public String getNamaPemimpin() {
	        return namaPemimpin;
	    }

	    public int getTanggalKemerdekaan() {
	        return tanggalKemerdekaan;
	    }

	    public int getBulanKemerdekaan() {
	        return bulanKemerdekaan;
	    }

	    public int getTahunKemerdekaan() {
	        return tahunKemerdekaan;
	    }

	    public void tampilkanInfo(HashMap <Integer, String> bulanMap) {
	    	if (jenisKepemimpinan.equalsIgnoreCase("monarki")) {
	    		String pemimpin = "Raja";
	    		 System.out.println("\nNegara " +nama+ " mempunyai " +pemimpin+ " bernama " +namaPemimpin+ "/n");
	    	}
	    	else {
	    		System.out.println("\nNegara " +nama+ " mempunyai " +jenisKepemimpinan+ " bernama " +namaPemimpin);
	    	}
	       
	        if (!jenisKepemimpinan.equalsIgnoreCase("Monarki")) {
	            String bulan = bulanMap.get(bulanKemerdekaan);
	            System.out.println("Deklarasi Kemerdekaan pada Tanggal " +tanggalKemerdekaan+ " " +bulan+ " " +tahunKemerdekaan+ "\n");
	        } 
	    }
	}