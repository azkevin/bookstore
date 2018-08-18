/**  
* Entries to put in a shopping cart
* @author  Shagun Kazan
* 
*/ 

package bean;

public class CartBean 
{
	private int cartid;
	private int userid;
	private String bid;
	private String coverart;
	private String title;
	private float price;
	
	public CartBean(int cartid, int userid, String bid, String coverart, String title, float price) {
		super();
		this.cartid = cartid;
		this.userid = userid;
		this.bid = bid;
		this.coverart = coverart;
		this.title = title;
		this.price = price;
	}
	
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getCoverart() {
		return coverart;
	}
	public void setCoverart(String coverart) {
		this.coverart = coverart;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
