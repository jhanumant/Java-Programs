import java.util.*;

class HashTable {
	
	private LinkedHashEntry[] table;
	private int TABLE_SIZE;
	
	HashTable(int TABLE_SIZE) {
		this.TABLE_SIZE = TABLE_SIZE;
		table = new LinkedHashEntry[TABLE_SIZE];
		for (int i=0;i<TABLE_SIZE;i++) {
			table[i] = null;
		}
	}
	
	public int hashValue(String key){
		int hashCode = key.hashCode();
		hashCode = hashCode % TABLE_SIZE;
		if (hashCode < 0) {
			hashCode += TABLE_SIZE;
		}
		return hashCode;
	}
	
	public void insert(String key, int data) {
		int hashCode = hashValue(key) % TABLE_SIZE;
		if(table[hashCode] == null) {
			table[hashCode] = new LinkedHashEntry(key, data);
		} else {
			LinkedHashEntry temp = table[hashCode];
			while (temp.next != null && !temp.getKey().equals(key)) {
				temp = temp.next;
			}
			if (temp.getKey().equals(key)) {
				temp.setData(data);
			} else {
				temp.next = new LinkedHashEntry(key, data);
			}
		}
	}
	
	public int getValue(String key) {
		int hashCode = hashValue(key) % TABLE_SIZE;
		if (table[hashCode]!=null) {
			LinkedHashEntry temp = table[hashCode];
			while (!temp.getKey().equals(key)) {
				temp = temp.next;
			}
			if (temp!=null) {
				return temp.getData();
			}
		}
		return -1;
	}
	
	public void print() {
		for (int i=0;i<TABLE_SIZE;i++) {
			LinkedHashEntry temp = table[i];
			System.out.println("Bucket"+ i);
			while(temp!=null) {
				System.out.println(temp.getData());
				temp = temp.next;
			}
		}
	}
}

class LinkedHashEntry {
	private String key;
	private int data;
	LinkedHashEntry next;
	
	LinkedHashEntry(String key, int data) {
		this.key = key;
		this.data = data;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData(){
		return this.data;
	}
}

class CallingClass {
	public static void main(String...args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of hashTable");
		HashTable ht = new HashTable(sc.nextInt());
		
		ht.insert("A",1);
		ht.insert("AA",2);
		ht.insert("C",3);
		System.out.println(ht.getValue("AA"));
		ht.print();
	}
	
}