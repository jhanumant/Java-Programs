import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
	
	public static String sortString (String str) {
		char[] content = str.toCharArray();
		Arrays.sort(content);
		return new String(content);
		
	}
	public static boolean isAnagramUsingSort(String str1, String str2) {
		if (str1.length()!=str2.length()) {
			return false;
		} 
		return sortString(str1).equals(sortString(str2));
	}
	
	public static boolean isAnagramUsingCount(String str1,String str2) {
		int[] count = new int[256];
		if (str1.length()!= str2.length()) {
			return false;
		}
		for (int i=0;i<str1.length();i++) {
			count[str1.charAt(i)]++;
		}
		for (int i=0;i<str2.length();i++) {
			count[str2.charAt(i)]--;
			if (count[str2.charAt(i)] < 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input the first String");
		String str1 = sc.next();
		System.out.println("Input the second String");
		String str2 = sc.next();
		sc.close();
		
		boolean isAnagram = isAnagramUsingCount(str1, str2);
		if (isAnagram) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
		isAnagram = isAnagramUsingSort(str1, str2);
		if (isAnagram) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
