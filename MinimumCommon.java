import java.util.Arrays;
import java.util.Hashtable;

public class MinimumCommon {
	
	public static int returnMinCommon(int[] array1, int[] array2) {
		Hashtable ht = new Hashtable();
		int min = Integer.MAX_VALUE;
		for (int i=0;i<array1.length;i++) {
			ht.put(array1[i],true);
		}
		for (int j=0;j<array2.length;j++) {
			if (ht.containsKey(array2[j])) {
				if (min > array2[j]) {
					min = array2[j];
				}
			}
		}
		return (min!=Integer.MAX_VALUE)?min: -1;
		
		/*Arrays.sort(array1);
		Arrays.sort(array2);
		int length1 = array1.length;
		int length2 = array2.length;
		int i = 0;
		int j = 0;
		int min = 0;
		while (i<length1 && j<length2) {
			if (array1[i] > array2[j]) {
				j++;
			} else if (array2[j] > array1[i]){
				i++;
			} else {
				min = array1[i];
				break;
			}
		}
		return (min > 0)?min:-1;*/
	}
	public static void main(String...strings) {
		int[] array1 = {2,1,7,9,3};
		int[] array2 = {4,6,5,4,3,1};
		int min = returnMinCommon(array1, array2);
		System.out.println(min);
	}
}
