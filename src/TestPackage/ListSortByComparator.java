package TestPackage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import CommonUtil.CommonUtil;
import TestModle.Book;

public class ListSortByComparator {

	public static void main(String[] args){
		
		Book book1 = new Book(1,"aaa",new BigDecimal(12),"abc",true);
		Book book2 = new Book(2,"bbb",new BigDecimal(14),"abc",true);
		Book book3 = new Book(3,"ccc",new BigDecimal(8),"abc",true);
		
		List<Book> list = new ArrayList<>();
		
		list.add(book3);
		list.add(book2);
		list.add(book1);
		
		CommonUtil.printList1(list);
		
		Collections.sort(list, new comparatorByPrice());
		
		CommonUtil.printList1(list);
	}
	
	static class comparatorByPrice implements Comparator<Object>{

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			Book book1 = (Book)o1;
			Book book2 = (Book)o2;
			
			return -1*book1.getPrice().compareTo(book2.getPrice());//可通过乘以-1控制排序是升序还是降序
		}
		
		
	}
	
}
