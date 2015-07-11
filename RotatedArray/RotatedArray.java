import java.util.Arrays;
import java.util.Scanner;

public class RotatedArray {
	public static void main(String[] Arg){
		int[] n1 = {1,2,3,4,5,6,7,8};
		System.out.println("Array Asli: " + Arrays.toString(n1) + "\n") ;
		
		Scanner in = new Scanner(System.in);
		System.out.print("Masukkan offset: ");
		int offset = in.nextInt();
		rotate(n1,offset);
		System.out.println("Array Rotated " + offset + " kali: " + Arrays.toString(n1) + "\n");
	}
	
	
	public static void rotate(int[] arr, int offset){
		if (arr==null || offset<0){
			throw new IllegalArgumentException("array bernilai null atau offset lebih kecil dari 0");
		}
		int roffset = offset%arr.length;
		if (roffset>0){
			int[] copy = arr.clone();
			for(int i=0; i<arr.length; i++){
				arr[i] = copy[(roffset+i)%arr.length];
			}
		}		
	}
}

