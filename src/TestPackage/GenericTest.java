package TestPackage;

import java.math.BigDecimal;

import CommonUtil.CommonUtil;

public class GenericTest {

	public static void main(String[] args) {
		
		Integer[] list = new Integer[3];
		list[0] = 12;
		list[1] = 14;
		list[2] = 10;
		CommonUtil.<Integer>printArray(list);
		sort(list);
		CommonUtil.<Integer>printArray(list);
		
		testBigDecimal();
		testInteger();
		
	}
	
	public static void testBigDecimal(){
		
		BigDecimal a1 = new BigDecimal(10);
		BigDecimal a2 = a1;
		
		a1 = a1.add(new BigDecimal(10));
		
		System.out.println("a1:"+a1);
		System.out.println("a2:"+a2);
		
	}
	
	public static void testInteger(){
		
		Integer a1 = 10;
		Integer a2 = a1;
		
		a1 = 12;
		
		System.out.println(a1+"--"+a2);
	}
	
	public static <E extends Comparable<E>> void sort(E[] list){
		int minIndex;
		E currentMin;
		
		for(int i=0;i<list.length-1;i++){
			
			minIndex = i;
			currentMin = list[i];
			
			for(int j=i+1;j<list.length;j++){
				
				if(list[j].compareTo(currentMin)<0){
					minIndex = j;
					currentMin = list[j];
				}
			}
			
			if(i!=minIndex){
				
				list[minIndex] = list[i];
				list[i] = currentMin;
			}
		}
		
	}
	
}
