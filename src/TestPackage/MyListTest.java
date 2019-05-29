package TestPackage;

import java.util.Iterator;

import TestModle.MyArrayList;
import TestModle.MyLinkedList;

public class MyListTest {

	public static void main(String[] args) {
		
//		testArrayList();
		testLinkedList();
		
	}
	
	/**
	 * 
	 * @author WangDadai
	 */
	public static void testArrayList(){
		
		MyArrayList<Integer> list = new MyArrayList<Integer>();
		list.add(12);
		list.add(0, 13);
		list.add(4, 14);
//		list.clear();
		list.remove(2);
		printList(list);
		System.out.println(list.get(0));
	}
	
	public static void testLinkedList(){
		
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(12);
		list.addLast(123);
		list.addLast(124);
		list.addFirst(13);
		list.set(0, 11);
		list.set(3, 44);
		System.out.println(list.indexOf(11));
		
//		System.out.println(list.get(2));
		printList(list);
	}
	
	public static void printList(MyArrayList<Integer> list){
		for(Integer num : list){
			System.out.println(num);
		}
	}
	
	public static void printList(MyLinkedList<Integer> list){
		for(Integer num : list){
			System.out.println(num);
		}
//		Iterator<Integer> it = list.iterator();
//		while(it.hasNext()){
//			System.out.println(it.next());
//		}
	}
	
}
