package TestPackage;

public class SingleTon {

	/**
	 * 普通懒汉
	 */
//	private static SingleTon single = null;
//	
//	private SingleTon(){
//		
//	}
//	
//	public static SingleTon getIntanse(){
//		
//		if(single== null){
//			
//			single = new SingleTon();
//		}
//		return single;
//	}
	
	/**
	 * 同步加一层
	 */
//	private static SingleTon single = null;
//	
//	private SingleTon(){
//		
//	}
//	
//	private static synchronized SingleTon getInstanse(){
//		//在每一次获取单例时都试图获取同步锁 浪费了资源
//		if(single == null){
//			single = new SingleTon();
//		}
//		return single;
//	}
	
	/**
	 * 双重检查锁定
	 */
//	private static SingleTon single = null;//没有性能损耗 
//	
//	private SingleTon(){
//		
//	}
//	
//	public static SingleTon getInstance(){
//		if(single == null){
//			
//			synchronized (SingleTon.class) {
//				if(single == null){
//					single = new SingleTon();
//				}
//				
//			}
//			
//		}
//		return single;
//	}
	
	/**
	 * 静态内部类
	 */
//	private static class insideClass{
//		private static final SingleTon instance = new SingleTon(); 
//	}
//	private SingleTon(){
//		
//	}
//	public static SingleTon getInstance(){
//		return insideClass.instance;
//	}
	
	/**
	 * 饿汉模式
	 */
	private SingleTon(){
		
	}
	private static final SingleTon single = new SingleTon();
	
	public static SingleTon getInstance(){
		return single;
	}
	
}
