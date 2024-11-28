package soal1;

import java.util.Random;

public class Dadu {
	Random random= new Random();
	
	int nilai; 
	
	public void acakNilai() {
		nilai = random.nextInt(6)+1;
	}
	
	public int getNilai() {
		return nilai;
	}
}
