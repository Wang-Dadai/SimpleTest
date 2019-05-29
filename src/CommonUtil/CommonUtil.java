package CommonUtil;

import java.util.List;

public class CommonUtil {

	public static <E> void printList(List<E> list){
		
		if(list!=null && !list.isEmpty()){
			for(E e : list){
				System.out.println("elsement:"+e);
				
			}
			
		}
	}
	
	public static void printList1(List<?> list){
		
		if(list!=null && !list.isEmpty()){
			for(Object e : list){
				System.out.println("elsement:"+e);
				
			}
			
		}
	}
	
	public static <E> void printArray(E[] list){
		
		for(E e : list){
			System.out.println("element:" + e);
		}
	}
	
	public static void printArray1(Object[] list){
		
		for(Object o : list){
			System.out.println("element:"+o);
		}
	}
	
}
