import java.util.Scanner;
import java.util.Arrays;

public class SearchInRotatedArray {
	public static void main (String[] Args){
		Scanner in = new Scanner(System.in);
		
		//Array Asli
		int[] arr = {1,2,3,4,5,6,7,8};
		System.out.println("Array Asli: " + Arrays.toString(arr) + "\n");
		System.out.print("Masukkan offset: ");
		int offset = in.nextInt();
		rotate(arr,offset);
		System.out.println("Array hasil rotate: " + Arrays.toString(arr) + "\n");
		
		System.out.print("Masukkan suatu angka untuk dicari: ");
		int numCari = in.nextInt();
		int hasilCari = robinsearch(arr, numCari);
		System.out.println("Angka " + numCari + " ada pada element array ke-" +hasilCari);
	}
	
	
	//prosedur mencari dalam rotated array (log n complexity)
	//step 1: find pivot:
	//step 2: bandingkan denagan nilai awal kemudian binary search
	public static int robinsearch(int[] arr, int num){
		int pivot = findpivot(arr, 0, arr.length-1);
		//print pivot
		//System.out.println("pivot: " + pivot);
		
		if(arr[pivot]==num){
			return pivot;
		}
		if(arr[0] <= num){
			return binsearch(arr,0,pivot+1, num);
		}else{
			return binsearch(arr,pivot+1,arr.length-1,num);
		}
		
	}

	//prosedur binary search
	public static int binsearch(int[] arr, int bot, int top, int key){
		int mid = (bot+top)/2;
		if(arr[mid]==key){
			return mid;
		}
		if(arr[mid]>key){
			return binsearch(arr, bot, mid-1, key);
		}else{
			return binsearch(arr, mid+1, top, key);
		}
	}
	
	//prosedur find rotation pivot dalam array
	//step 1: cari nilai tengah
	//step 2: cari kecendrungan mid>top dan mid<top
	public static int findpivot (int[] arr, int bot, int top){
		if (top<bot){
			return -1;
		}
		if (arr[bot] == arr[top]){
			return bot;
		}
		int mid = (top + bot)/2;
		// nilai mid > top kemungkinan pivot berada di sebelah kanan, sebaliknya kiri
		if (arr[mid]>arr[top] && arr[mid]>arr[mid+1]){
			return mid+1;
		}
		if (arr[mid]<arr[top] && arr[mid-1]>arr[mid]){
			return mid;
		}
		if (arr[mid]>arr[top]){
			return findpivot(arr, mid+1, top);
		}else{
			return findpivot(arr, bot, mid-1);
		}
	}
	
	
	//prosedur untuk merotate arraynya 
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

