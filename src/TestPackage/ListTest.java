package TestPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import CommonUtil.CommonUtil;

/**
 * @author w2896
 *
 */
public class ListTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
				
		//将数组转换成列表
//		List<String> arrayList = Arrays.asList("aaa","bbb","ccc","sss");
		
		List<Object> list = new ArrayList<>();
		
		for(int i=0;i<100;i++){
			
			list.add(i+"");
		}
		
		LinkedList<Object> list2 = new LinkedList<>(list);
		
		list2.addLast(list2.removeFirst());
		for(Object str : list2){
			System.out.println(str);
		}
		
//		iteratorTest(list);
		
//		testList();
//		testArrayList();
//		testList2();
//		reverseTest();
		shuffleTest();
		
	}

	/**
	 * 测试list赋值是否是引用赋值  结果：是
	 */
	public static void testList(){
		
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		List<String> list2 = new ArrayList<>();
		list2 = list;
		
		list.remove("a");
		
		List<Object> list3 = new ArrayList<>();
		list3.add(3);
		list3.add("asd");
		
		
		CommonUtil.<String>printList(list);
		CommonUtil.<String>printList(list2);
		CommonUtil.printList1(list3);
		CommonUtil.printList1(list);
		objectTest(list);
	}
	
	/**
	 * 
	 */
	public static void testArrayList(){
		
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("a");
		list2 = (ArrayList<String>)(list.clone());
		
		list.remove("a");
		
		CommonUtil.<String>printList(list);
		CommonUtil.<String>printList(list2);
	}
	
	/**
	 * 
	 */
	public static void testList2(){
		
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		List<String> list2 = new ArrayList<>(list);
		
		list.remove("a");
		
		CommonUtil.<String>printList(list);
		CommonUtil.<String>printList(list2);
	}
	
	/**
	 * @param o
	 * @author WangDadai
	 */
	public static void objectTest(Object o){
		System.out.println("hhhh");
	}
	
	/**
	 * 测试list的iterator 返回的是上一次迭代的位置 还是每次都是list头部位置
	 * @param list
	 */
	public static void iteratorTest(List<Object> list){
		
		Iterator<Object> iterator = list.iterator();
		for(int i=0;i<2;i++){
			if(iterator.hasNext()){
				System.out.println(iterator.next());
			}
		}
		Iterator<Object> it = list.iterator();
		System.out.println(it.next());
		
	}
	
	public static void reverseTest(){
		
		List<Integer> list1 = new ArrayList<>();
		
		list1 = Arrays.asList(1,2,3,4,5,6);
		
		List<Integer> list2 = new ArrayList<>(list1.subList(3, 3));
		
		CommonUtil.<Integer>printList(list2);
		Collections.reverse(list2);
		CommonUtil.printList1(list2);
		CommonUtil.printList1(list1);
		
	}
	
	public static void shuffleTest(){
		
		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
		
		Collections.shuffle(list1, new Random(10));
		
		CommonUtil.printList1(list1);
	}
	
}
