package TestModle;

import java.io.ObjectOutputStream.PutField;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import myInterface.MyMap;

public class MyHashMap<E,T> implements MyMap<E, T>{

	private static int DEFAULT_INITIAL_CAPACITY = 4;
	
	private static int MAXIMUM_CAPACITY = 1<<30;
	
	private int capacity;
	private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;
	private float loadFactorThreshold;
	private int size = 0;
	
	LinkedList<MyMap.Entry<E,T>>[] table;
	
	public MyHashMap() {
		// TODO Auto-generated constructor stub
		this(DEFAULT_INITIAL_CAPACITY,DEFAULT_MAX_LOAD_FACTOR);
	}
	
	public MyHashMap(int initialCapacity){
		this(initialCapacity,DEFAULT_MAX_LOAD_FACTOR);
	}
	
	public MyHashMap(int initialCapacity, float loadFactorThreshold) {
		// TODO Auto-generated constructor stub
		if(initialCapacity>MAXIMUM_CAPACITY){
			this.capacity = MAXIMUM_CAPACITY;
		}else{
			this.capacity = trimToPowerOf2(initialCapacity);
		}
		
		this.loadFactorThreshold = loadFactorThreshold;
		table = new LinkedList[capacity];
	}

	private int trimToPowerOf2(int initialCapacity) {
		// TODO Auto-generated method stub
		int capacity = 1;
		while(capacity<initialCapacity){
			capacity<<=1;
		}
		
		return capacity;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		removeEntries();
	}

	private void removeEntries() {
		// TODO Auto-generated method stub
		for(int i =0 ;i<capacity;i++){
			if(table[i]!=null){
				table[i].clear();
			}
		}
	}

	@Override
	public boolean containsKey(E key) {
		// TODO Auto-generated method stub
		if(get(key)!=null){
			return true;
		}
		
		return false;
	}

	@Override
	public boolean containsValue(T value) {
		// TODO Auto-generated method stub
		for(int i=0;i<capacity;i++){
			if(table[i]!=null){
				LinkedList<Entry<E,T>> bucket = table[i];
				for(Entry<E,T> entry : bucket){
					if(entry.getValue().equals(value)){
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public Set<MyMap.Entry<E, T>> entrySet() {
		// TODO Auto-generated method stub
		HashSet<MyMap.Entry<E, T>> set = new HashSet<MyMap.Entry<E,T>>();
		for(int i=0;i<capacity;i++){
			if(table[i]!=null){
				LinkedList<Entry<E,T>> bucket = table[i];
				for(Entry<E,T> entry:bucket){
					set.add(entry);
				}
			}
		}
		
		return set;
	}

	@Override
	public T get(E key) {
		// TODO Auto-generated method stub
		int bucketIndex = hash(key.hashCode());
		if(table[bucketIndex]!=null){
			LinkedList<Entry<E,T>> bucket = table[bucketIndex];
			for(Entry<E,T> entry : bucket){
				if(entry.getKey().equals(key)){
					return entry.getValue();
				}
			}
		}
		
		return null;
	}

	private int hash(int hashCode) {
		// TODO Auto-generated method stub
		return supplementalHash(hashCode) & (capacity - 1);
	}

	private int supplementalHash(int hashCode) {
		// TODO Auto-generated method stub
		hashCode ^= (hashCode>>>20) ^ (hashCode>>>12);
		return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public Set<E> keySet() {
		// TODO Auto-generated method stub
		HashSet<E> set = new HashSet<E>();
		for(int i=0;i<capacity;i++){
			if(table[i]!=null){
				LinkedList<Entry<E,T>> bucket = table[i];
				for(Entry<E,T> entry : bucket){
					set.add(entry.getKey());
				}
			}
		}
		
		return set;
	}

	@Override
	public T put(E key, T value) {
		// TODO Auto-generated method stub
		if(get(key)!=null){
			int bucketIndex = hash(key.hashCode());
			LinkedList<Entry<E,T>> bucket = table[bucketIndex];
			for(Entry<E,T> entry : bucket){
				if(entry.getKey().equals(key)){
					T oldValue = entry.getValue();
					entry.value = value;
					return oldValue;
				}
			}
		}
		
		if(size>=capacity*loadFactorThreshold){
			if(capacity == MAXIMUM_CAPACITY){
				throw new RuntimeException("Exceeding maximum capacity");
			}
			rehash();
		}
		
		int bucketIndex = hash(key.hashCode());
		
		if(table[bucketIndex]==null){
			table[bucketIndex] = new LinkedList<Entry<E,T>>();
		}
		
		table[bucketIndex].add(new MyMap.Entry<E, T>(key, value));
		
		size++;
		return value;
	}

	private void rehash() {
		// TODO Auto-generated method stub
		Set<Entry<E,T>> set = entrySet();
		
		capacity<<=1;
		size=0;
		table = new LinkedList[capacity];
		for(Entry<E,T> entry : set){
			put(entry.getKey(), entry.getValue());
		}
		
	}

	@Override
	public void remove(E key) {
		// TODO Auto-generated method stub
		int bucketIndex = hash(key.hashCode());
		if(table[bucketIndex]!=null){
			LinkedList<Entry<E,T>> bucket = table[bucketIndex];
			for(Entry<E,T> entry : bucket){
				if(entry.getKey().equals(key)){
					bucket.remove(entry);
					size--;
					break;
				}
			}
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Set<T> values() {
		// TODO Auto-generated method stub
		HashSet<T> set = new HashSet<T>();
		for(int i=0;i<capacity;i++){
			
			if(table[i]!=null){
				LinkedList<Entry<E,T>> bucket = table[i];
				for(Entry<E,T> entry : bucket){
					set.add(entry.getValue());
				}
			}
		}
		
		return set;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		
		for(int i=0;i<capacity;i++){
			
			if(table[i]!=null && table[i].size()>0){
				for(Entry<E,T> entry : table[i]){
					sb.append(entry);
				}
			}
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	
}
