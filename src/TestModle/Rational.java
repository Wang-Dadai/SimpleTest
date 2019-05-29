package TestModle;

public class Rational extends Number implements Comparable<Rational>{
	
	private long numerator;
	private long denominator;;
	
	public Rational(){
		this(0,1);
	}
	
	public Rational(long numerator,long denominator){
		long gcd = gcd(numerator,denominator);
		this.numerator = (denominator>0?1:-1)*numerator/gcd;
		this.denominator = denominator/gcd;
	}
	
	protected long gcd(long numerator,long denominator){
		
		long n1 = Math.abs(numerator);
		long n2 = Math.abs(denominator);
		int min = (int)Math.min(numerator, denominator);
		int gcd = 1;
		
		for(int k=min;k>0;k--){
			if(n1%k==0 && n2%k==0){
				gcd = k;
			}
		}
		
		return gcd;
		
	}

	public Rational add(Rational secondRational){
		
		long n = numerator*secondRational.getDenominator() + denominator*secondRational.getNumerator();
		long d = denominator*secondRational.getDenominator();
		
		return new Rational(n,d);
				
				
		
	}
	
	public long getNumerator() {
		return numerator;
	}

	public void setNumerator(long numerator) {
		this.numerator = numerator;
	}

	public long getDenominator() {
		return denominator;
	}

	public void setDenominator(long denominator) {
		this.denominator = denominator;
	}

	@Override
	public int compareTo(Rational arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

} 
