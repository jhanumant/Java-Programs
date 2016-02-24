
public class MergeSortedArrays {

	public static void mergeArrays(int []first, int[] second,int lastFirst, int lastSecond) {
		int indexMerged = lastFirst + lastSecond + 1;
		while (lastFirst >=0 && lastSecond >=0) {
			if (first[lastFirst]> second[lastSecond]) {
				first[indexMerged] = first[lastFirst];
				indexMerged --;
				lastFirst --;
			} else {
				first[indexMerged] = second[lastSecond];
				indexMerged --;
				lastSecond --;
			}
		}
		
		while (lastSecond >=0) {
			first[indexMerged] = second[lastSecond];
			lastSecond --;
			indexMerged --;
		}
		
		for (int i=0;i<first.length;i++) {
			System.out.print(first[i]+" ");
		}
	}
	public static void main(String [] args) {
		//int []firstArray = new int[] {5,7,9,10};
		int []secondArray = new int[] {1,3,5,8,9};
		int []firstArray = new int[secondArray.length+4];
		firstArray[0] = 4;
		firstArray[1] = 7;
		firstArray[2] = 10;
		firstArray[3] = 11;
		mergeArrays(firstArray,secondArray,3,secondArray.length-1);
		
	}
}
