package myInterface;

import java.util.Set;

public interface MyMap<E,T> {

	public void clear();
	
	public boolean containsKey(E key);
	
	public boolean containsValue(T value);
	
	public Set<Entry<E,T>> entrySet();
	
	public T get(E key);
	
	public boolean isEmpty();
	
	public Set<E> keySet();
	
	public T put(E key,T value);
	
	public void remove(E key);
	
	public int size();
	
	public Set<T> values();
	
	public static class Entry<E,T>{
		E key;
		public T value;
		
		public Entry(E key,T value){
			this.key = key;
			this.value = value;
		}
		
		public E getKey(){
			return key;
		}
		
		public T getValue(){
			return value;
		}
		
		@Override
		public String toString(){
			return "["+key+","+value+"]";
		}
	}
	
}
