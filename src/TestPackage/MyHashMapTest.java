package TestPackage;

import TestModle.MyHashMap;
import myInterface.MyMap;

public class MyHashMapTest {

	public static void main(String[] args) {
		
		MyMap<Integer, Integer> map = new MyHashMap<Integer,Integer>();
		
		map.put(1, 12);
		map.put(2, 13);
		map.put(3, 14);
		
		System.out.println(map);
		System.out.println(map.containsKey(1));
		System.out.println(map.put(4, 15));
	}
	
}
