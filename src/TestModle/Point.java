package TestModle;

import java.util.Comparator;

public class Point implements Comparable<Point>{

	public Point(){
		this.x = 0;
		this.y = 0;
	}
	
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	private Integer x;
	private Integer y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return this.x.compareTo(o.x);
	}
	
	public static class comparatorX implements Comparator<Point>{

		@Override
		public int compare(Point o1, Point o2) {
			// TODO Auto-generated method stub
			return o1.x.compareTo(o2.x);
		}
		
	}
	
	public static class comoaratorY implements Comparator<Point>{

		@Override
		public int compare(Point o1, Point o2) {
			// TODO Auto-generated method stub
			return o1.y.compareTo(o2.y);
		}
		
	}
	
	@Override
	public String toString(){
		return "point: x: "+this.x+" y: "+this.y;
	}
	
}
