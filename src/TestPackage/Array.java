package TestPackage;

import java.util.ArrayList;
import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		Integer[] array = {1,2,3,4,5,2};
		
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array));
		
		System.out.println(list);
	}
	
}
