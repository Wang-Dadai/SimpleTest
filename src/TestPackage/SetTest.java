package TestPackage;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

import TestModle.Book;

public class SetTest {

	public static void main(String[] args) {
		
		treeSet();
	}
	
	public static void hashSet(){
		
		HashSet<String> hashSet = new HashSet<>();
		
		hashSet.add("aaa");
		hashSet.add("222");
		
		Iterator<String> it = hashSet.iterator();
		
		while(it.hasNext()){
			
			System.out.println(it.next());
		}
		
		for(String str : hashSet){
			
			System.out.println(str);
		}
	}
	
	public static void linkedSet(){
		
		HashSet<String> linkedSet = new LinkedHashSet<>();
	}
	
	public static void treeSet(){
		
		TreeSet<String> treeSet = new TreeSet<String>();
		TreeSet<Book> bookSet = new TreeSet<Book>(new ListSortByComparator.comparatorByPrice());
		
		Book book1 = new Book(1,"aaa",new BigDecimal(12),"abc",true);
		Book book2 = new Book(2,"bbb",new BigDecimal(14),"abc",true);
		Book book3 = new Book(3,"ccc",new BigDecimal(8),"abc",true);
		
		bookSet.add(book3);
		bookSet.add(book2);
		bookSet.add(book1);
		
		for (Book book : bookSet) {
			
			System.out.println(book);
		}
		
	}
	
}
