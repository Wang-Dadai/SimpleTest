package TestPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * @author WangDadai
 *
 */
public class MapTest {
	
	/**
	 * @param args
	 * @author WangDadai
	 */
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<String,String>();
		
		for(int i=0;i<1000;i++){
			map.put(i+"", "hhh");
		}
		
		long start = System.currentTimeMillis();
		
//		entry(map);
//		iteratorTest(map);
//		value(map);
		try {
			countWordsInFile("C:\\dev\\workspace\\java\\Test\\file\\test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(System.currentTimeMillis() - start);
		
	}

	/**
	 * @param map
	 * @author WangDadai
	 */
	public static void iteratorTest(Map<String,String> map){
		Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			
			Map.Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey()+entry.getValue());
		}
		
	}
	
	public static void entry(Map<String,String> map){
		
		for(Entry<String,String> entry:map.entrySet()){
			
			System.out.println(entry.getKey()+entry.getValue());
		}
	}
	
	public static void value(Map<String,String> map){
		
		for(String value : map.values()){
			
			System.out.println(value);
		}
	}
	
	/**
	 * 统计文件中单词出现次数
	 * @param filename
	 * @throws IOException
	 * @author WangDadai
	 */
	public static void countWordsInFile(String filename) throws IOException{
		
//		Map<String,Integer> map = new HashMap<String,Integer>();
		TreeMap<String, Integer> map = new TreeMap<>(Collections.reverseOrder());
		
		File file = new File(filename);
		
		BufferedReader bf = new BufferedReader(new FileReader(file));
		
		String str = null;
		while((str=bf.readLine())!=null){
			
			str = str.toLowerCase();
			String[] words = str.split("[ \n\t\r.,:;!?(){}\"]");
			
			for (String string : words) {
				
				if(string.length()>0){
					
					if(map.containsKey(string)){
						
						Integer value = map.get(string);
						value++;
						map.put(string, value);
					}else{
						
						map.put(string, 1);
					}
				}
			}
		}
		
		bf.close();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
	
}
