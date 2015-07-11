import java.util.Scanner;

public class AToPowerOfB {

	public static void main(String []args){
		int A, B, Hasil = 0;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Program Menghitung (A Pangkat B)");
		System.out.println("---------------------------------");
		System.out.print("Masukkan A: ");
		A = in.nextInt();
		System.out.print("Masukkan B: ");
		B = in.nextInt();
		System.out.println();
		Hasil = pangkat(A,B);
		System.out.println("Hasil: " + Hasil);
		
	}
	
	public static int pangkat(int a, int b){
		int hasil = 0;
		switch (b){
			case 0:
				hasil = 1;
				break;
			case 1:
				hasil = a;
				break;
			default:
				if ((b%2)==0){
					int ngen = pangkat(a, (b/2));
					hasil = ngen * ngen;
				}else{
					int ngan = pangkat(a, (b-1)/2);
					hasil = a * ngan * ngan;
				}
				break;
		}
		
		return hasil;
	}
}