import java.util.Scanner;

/*Implement an algorithm to determine if a string has all unique characters.
 What if you cannot use additional data structures */

public class UniqueCharactersInString {
	
	public static boolean isUnique(String input) {
		boolean[] count = new boolean[256]; //integer array to store the count
		if (input.length() > 256 ) {
			return false;
		}
		
		for (int i=0;i<input.length();i++) {
			char c = input.charAt(i);
			if (count[c]) {
				return false;
			} else {
				count[c] = true;
			}
		}
		
		return true;
	}
	
	/*Assumption that all characters are lower case*/
	public static boolean isUniqueWithoutBuffer(String input) {
		
		input = input.toLowerCase();
		int checker = 0;
		
		for (int i=0;i<input.length();i++) {
			int value = input.charAt(i) - 'a';
			if ((checker & (1<<value)) > 0) {
				return false;
			}
			checker |= (1<<value);
		}
		
		return true;
	}
	public static void main(String...strings) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the input String:-");
		String inputString = sc.next();
		
		boolean unique = isUnique(inputString);
		if (unique) {
			System.out.println("The input string has all unique characters");
		} else {
			System.out.println("The input string doesn't have unique characters");
		}
		
		boolean uniqueWBuffer = isUniqueWithoutBuffer(inputString);
		if (uniqueWBuffer) {
			System.out.println("The input string has all unique characters");
		} else {
			System.out.println("The input string doesn't have unique characters");
		}		
	}
}
