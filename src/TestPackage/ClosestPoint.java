package TestPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import TestModle.Point;

public class ClosestPoint {
	
	public static void main(String[] args) {
		
		Set<Point> set = new HashSet<Point>();
		Random random = new Random();
		
		for(int i=0;i<500;i++){
			
			int x = random.nextInt(500);
			int y = random.nextInt(500);
			set.add(new Point(x,y));
		}
		
		Point[] testPoint = new Point[set.size()];
		set.toArray(testPoint);
		
		for(Point point : testPoint){ 
			System.out.println(point);
		}
		
		Point result[] = divide(testPoint);
		
		System.out.println("Closest Point:");
		for(Point point : result){
			
			System.out.println(point);
		}
		
	}

	public static Point[] divide(Point[] ps){
		
		Point[] result = new Point[2];
		
		//少于二十个点时使用蛮力法求解
		double dmin = Double.POSITIVE_INFINITY;
		double tmpmin = 0;
		
		if(ps.length<20){
			
			for(int i=0;i<ps.length;i++){
				for(int j=i+1;j<ps.length;j++){
					
					tmpmin = Math.sqrt(Math.pow(ps[i].getX()-ps[j].getX(), 2)-Math.pow(ps[i].getY()-ps[j].getY(), 2));
					
					if(tmpmin<dmin){
						dmin = tmpmin;
						result[0] = ps[i];
						result[1] = ps[j];
					}
				}
			}
			return result;
			
		}
	
		//分治
		//1、找到以x轴中线
		int minX = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		
		for(int i=0;i<ps.length;i++){
			if(ps[i].getX()<minX){
				minX = ps[i].getX();
			}
			if(ps[i].getX()>maxX){
				maxX = ps[i].getX();
			}
		}
		
		int midX = (minX + maxX)/2;
		
		//2、按中线划分
		List<Point> leftlist = new ArrayList<Point>();
		List<Point> rightlist = new ArrayList<Point>();
		
		for(int i=0;i<ps.length;i++){
			
			if(ps[i].getX()>midX){
				rightlist.add(ps[i]);
			}else{
				leftlist.add(ps[i]);
			}
		}
		
		//3、将两张表化为数组并按照x轴升序排列
		Point[] leftPoint = new Point[leftlist.size()];
		Point[] rightPoint = new Point[rightlist.size()];
		
		leftlist.toArray(leftPoint);
		rightlist.toArray(rightPoint);
		
		Arrays.sort(leftPoint,new Point.comparatorX());
		Arrays.sort(rightPoint,new Point.comparatorX());
		
		//4、分别求出两边最近的两个点
		Point lresult[] = divide(leftPoint);
		Point rresult[] = divide(leftPoint);
		
		//5、计算出两边最近点距
		double ld = Math.sqrt(Math.pow(lresult[0].getX()-lresult[1].getX(), 2)+Math.pow(lresult[0].getY()-lresult[1].getY(), 2));
		double rd = Math.sqrt(Math.pow(rresult[0].getX()-rresult[1].getX(), 2)+Math.pow(rresult[0].getY()-rresult[1].getY(), 2));
		double mind;
		if(ld<rd){
			mind = ld;
			result = lresult;
		}else{
			mind = rd;
			result = rresult;
		}
		
		//6、获取两边距离中线小于mind的点 分别放入两个列表
		List<Point> llist = new ArrayList<Point>();
		List<Point> rlist = new ArrayList<Point>();
		
		for(int i=0;i<leftPoint.length;i++){
			
			if(midX-leftPoint[i].getX()<mind){
				llist.add(leftPoint[i]);
			}
		}
		for(int i=0;i<rightPoint.length;i++){
			
			if(rightPoint[i].getX()-midX<mind){
				rlist.add(rightPoint[i]);
			}
		}
		
		//7、转为数组 按y升序排序
		Point[] lPoint = new Point[llist.size()];
		Point[] rPoint = new Point[rlist.size()];
		
		llist.toArray(lPoint);
		rlist.toArray(rPoint);
		
		Arrays.sort(lPoint,new Point.comoaratorY());
		Arrays.sort(rPoint,new Point.comoaratorY());
		
		//8、求出两列表中最近点 并与mind比较
		for(int i=0;i<lPoint.length;i++){
			
			for(int j=0;j<rPoint.length;j++){
				
				double lrd = Math.sqrt(Math.pow(lPoint[i].getX()-rPoint[j].getX(), 2)+Math.pow(lPoint[i].getY()-rPoint[j].getY(), 2));
				
				if(lrd<mind){
					
					mind = lrd;
					result[0] = lPoint[i];
					result[1] = rPoint[j];
				}
			}
		}
	
		return result;
	}
	
}
