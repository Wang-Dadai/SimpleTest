package TestModle;

import java.math.BigDecimal;

public class Book {

	private Integer id;
	private String bookname;
	private BigDecimal price;
	private String author;
	private Boolean saled;
	
	public Book(int id,String bookname,BigDecimal price,String author,boolean saled){
		
		this.id = id;
		this.bookname = bookname;
		this.price = price;
		this.author = author;
		this.saled = saled;
	}
	
	public Book(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Boolean getSaled() {
		return saled;
	}
	public void setSaled(Boolean saled) {
		this.saled = saled;
	}
	
	@Override
	public String toString(){
		return this.id+" "+this.bookname+" "+this.price+" "+this.author+" "+(this.saled?"已售出":"未售出");
		
	}
	
}
