/**  
* Entries to put in a shopping cart
* @author  Shagun Kazan
* 
*/ 


package bean;

public class CartBean 
{
	private String bid;
	private String title;
	private String author;
	private String coverart;
	private float price;
	private int quantity;
	
	
	
	public CartBean(String bid, String title, String author, String coverart, float price, int quantity) 
	{
		this.bid = bid;
		this.title = title;
		this.author = author;
		this.coverart = coverart;
		this.price = price;
		this.quantity = quantity;
	}
	
	
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCoverart() {
		return coverart;
	}
	public void setCoverart(String coverart) {
		this.coverart = coverart;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
