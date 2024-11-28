package com.transaksi_toko;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);
		
		String nama_barang = "";
		int jumlah_barang = 0, harga_barang = 0, subtotal_barang = 0, pilihan = 0;
		double pajak = 0.1, total_ppn = 0.1, diskon = 0.1, total_diskon = 0.1, jumlah_uang = 0.1, total_hargadiskon = 0.1, total_hargapajak = 0.1, kembalian = 0.1; 
		
		do {
			System.out.println("=============================");
			System.out.println("|| Transaksi Toko Kampoeng ||");
			System.out.println("=============================");
			System.out.println("Pilih Menu:");
			System.out.println("1. Masukkan Data Pembelian");
			System.out.println("2. Hitung Total Pembelian");
			System.out.println("3. Hitung Total Pembelian dengan Diskon");
			System.out.println("4. Hitung Total Pembelian dengan Diskon dan PPN");
			System.out.println("5. Pembayaran");
			System.out.println("6. Nota");
			System.out.println("7. Tutup");
			System.out.print("Input Menu: ");
			pilihan = input.nextInt();
			input.nextLine();
			
			System.out.println("");
			
			switch (pilihan) {
			case 1:
				System.out.print("Nama Barang: ");
				nama_barang = input.nextLine();
				
				do {
					System.out.print("Jumlah Barang: ");
					jumlah_barang = input.nextInt();
					if (jumlah_barang <= 0) {
						System.out.println("Masukkan jumlah barang \n");
					}
				} while (jumlah_barang <= 0);
				
				do {
					System.out.print("Harga Per Unit: Rp ");
					harga_barang = input.nextInt();
					if (harga_barang <= 0) {
						System.out.println("Masukkan harga barang \n");
					} 
				} while (harga_barang <= 0);
			break;
				
			case 2:
				subtotal_barang = jumlah_barang * harga_barang;
				System.out.println(nama_barang);
				System.out.println(jumlah_barang+ " x " +harga_barang+ " = Rp " +subtotal_barang);
				System.out.println("Total Pembelian: Rp " +subtotal_barang+ "\n");
				if (subtotal_barang <= 0) {
					System.out.println("Masukkan Data Pembelian \n");
				}
				break;
			case 3:
				System.out.print("Diskon (%): ");
				diskon = input.nextDouble();
				total_diskon = subtotal_barang * diskon/100;
				total_hargadiskon = subtotal_barang - total_diskon;
				System.out.println(subtotal_barang+ " x " +diskon+ "% = Rp " +total_diskon);
				System.out.println(subtotal_barang+ " - " +total_diskon+ " = Rp " +total_hargadiskon);
				System.out.println("Total Pembelian dengan Diskon: Rp " +total_hargadiskon+ "\n");
				if (subtotal_barang <= 0) {
					System.out.println("Masukkan Data Pembelian dan Hitung Total Pembelian \n");
				}
				break;
			case 4:
				System.out.print("PPN (%): ");
				pajak = input.nextDouble();
				total_ppn = total_hargadiskon * pajak/100;
				total_hargapajak = total_hargadiskon + total_ppn;
				System.out.println(total_hargadiskon+ " x " +pajak+ "%  = Rp " +total_ppn);
				System.out.println("Total Pembelian dengan Diskon dan PPN: Rp " +total_hargadiskon+ " + " +total_ppn+ " = Rp " +total_hargapajak+ "\n");
				
				if (subtotal_barang <= 0) {
					System.out.println("Masukkan Data Pembelian dan Hitung Total Pembelian \n");
				}
				break;
			case 5:
				if (total_hargapajak <= 0) {
					System.out.println("Silakan hitung total pembelian beserta Diskon dan PPN \n");
				} else {
					do {
						System.out.print("Jumlah Uang: Rp ");
						jumlah_uang = input.nextDouble(); 
						if (jumlah_uang < total_hargapajak) {
							System.out.println("Uang tidak cukup, silakan masukkan lagi \n");
						} 
					} while (jumlah_uang < total_hargapajak);
					
					kembalian = jumlah_uang - total_hargapajak;
					System.out.println(jumlah_uang+ " - " +total_hargapajak+ " = " +kembalian);
					System.out.println("Kembalian: Rp " +kembalian+ "\n");
				 }
				break;
			case 6:
				if (jumlah_barang <= 0 || harga_barang <= 0 || subtotal_barang <= 0) {
					System.out.println("Masukkan Data Pembelian dan Hitung Total Pembelian");
				} else if (total_hargapajak <= 0 || jumlah_uang <= 0){
					System.out.println("Hitung Total Pembelian beserta PPN dan diskon, Kemudian Lakukan Pembayaran");
					
				} else {
					System.out.println("====================================");
					System.out.println("|| Nota Transaksi \"Toko Kampoeng\" ||");
					System.out.println("====================================");
					System.out.println("Nama Barang: " +nama_barang);
					System.out.println("Jumlah Barang: " +jumlah_barang);
					System.out.println("Harga Barang Per Unit: Rp " +harga_barang);
					System.out.println("---------------------------------");
					System.out.println("Subtotal Barang: Rp " +subtotal_barang);
					System.out.println("Diskon: -Rp " +total_diskon);
					System.out.println("Pajak Barang: +Rp " +total_ppn);
					System.out.println("Total Harga: Rp " +total_hargapajak);
					System.out.println("Jumlah Uang: Rp " +jumlah_uang);
					System.out.println("Kembalian: Rp " +kembalian+ "\n");
				}
				break;
			case 7:
				System.out.println("=======================");
				System.out.println("| Terima kasih banyak |");
				System.out.println("=======================");
				break;
			default:
				System.out.println("Pilihan Tidak Ada Pada Menu.\n");
				break;
			}
		} while (pilihan != 7);
		
		input.close();
	}
}