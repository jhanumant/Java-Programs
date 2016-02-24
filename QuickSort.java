import java.util.HashSet;
import java.util.Set;

public class QuickSort {
	
	public static void sortArray(int []data,int left,int right){
		int index = partition(data,left,right);
		if (left < index-1) {
			sortArray(data,left,index-1);
		}
		if (index<right) {
			sortArray(data,index,right);
		}
	}
	
	public static int partition(int []data,int left,int right) {
		int pivot = data[(left+right)/2];
		while (left<=right) {
			while (data[left]<pivot) {
				left ++;
			}
			while (data[right]>pivot) {
				right --;
			}
			if (left <= right) {
				int temp = data[left];
				data[left]=data[right];
				data[right]=temp;
				left ++;
				right --;
				
				
				
			}
		}
		return left;
	}
	public static void main(String []args) {
		int []unsortedArray = new int[] {10,9,8,7,6,5};
		int size = unsortedArray.length;
		for (int i=0; i<size ; i++) {
			System.out.print(unsortedArray[i]+" ");
		}
		sortArray(unsortedArray,0,size-1);
		System.out.println();
		for (int i=0; i<size ; i++) {
			System.out.print(unsortedArray[i]+" ");
		}
		int j=0;
		for (int i=0;i<100;i++) j= j++;
		System.out.println("j"+j);
	}
}
