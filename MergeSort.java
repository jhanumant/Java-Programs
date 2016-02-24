
public class MergeSort {
	
	public static void divideArray(int []data, int low,int high) {
		if (low<high){
			int middle = (low+high)/2;
			divideArray(data, low, middle);
			divideArray(data, middle+1, high);
			merge(data,low,middle,high);
		}
	}
	
	public static void merge(int []data,int low,int middle,int high) {
		int []tempArray = new int [data.length];
		for (int i=low;i<=high;i++) {
			tempArray[i] = data[i];
		}
		int tempLeft = low;
		int tempRight = middle + 1;
		int current = low;
		while (tempLeft <=middle && tempRight <= high) {
			if (tempArray[tempLeft] <= tempArray[tempRight]) {
				data[current] = tempArray[tempLeft];
				tempLeft ++;
			} else {
				data[current] = tempArray[tempRight];
				tempRight++;
			}
			current ++;
		}
		while (tempLeft <= middle) {
			data[current] = tempArray[tempLeft];
			tempLeft++;
			current++;
		}
	}
	public static void main(String []args) {
		int []unsortedArray = new int[] {10,9,8,7,6,5};
		int size = unsortedArray.length;
		for (int i=0; i<size ; i++) {
			System.out.print(unsortedArray[i]+" ");
		}
		divideArray(unsortedArray,0,size-1);
		System.out.println();
		for (int i=0; i<size ; i++) {
			System.out.print(unsortedArray[i]+" ");
		}
	}
}
