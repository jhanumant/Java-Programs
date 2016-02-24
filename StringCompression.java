
public class StringCompression {

	public static String compressString(String str) {
		StringBuffer compressedString = new StringBuffer();
		int size = str.length();
		int length = returnCompressedSize(str);
		char last;
		int count = 0;
		
		if (length >= size || length == 0) {
			return str;
		} else {
			last = str.charAt(0);
			count = 0;
			for (int i=0;i<size;i++) {
				if (str.charAt(i) == last) {
					count ++;
				} else {
					compressedString.append(last);
					compressedString.append(count);
					last = str.charAt(i);
					count = 1;
				}
			}
		}
		compressedString.append(last);
		compressedString.append(count);
		return compressedString.toString();
	}
	
	public static int returnCompressedSize(String str) {
		int size = 0;
		int count = 0;
		char last = str.charAt(0);
		
		if (str.length() == 0) {
			return 0;
		}
		
		for (int i=1;i<str.length();i++) {
			if (str.charAt(i) == last) {
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String output = compressString("aaabbbccd");
		System.out.println(output);
		output = compressString("abcd");
		System.out.println(output);
		output = compressString("abbcdd");
		System.out.println(output);
		output = compressString("abbcd");
		System.out.println(output);
	}

}
