package bean;

public class SoldBean {

	private BookBean bookBean;
	private int quantity;
	
	public SoldBean() {
		// TODO Auto-generated constructor stub
	}
	
	public SoldBean(BookBean b, int q) {
		this.bookBean = b;
		this.quantity = q;
	}

	public BookBean getBookBean() {
		return bookBean;
	}

	public void setBookBean(BookBean bookBean) {
		this.bookBean = bookBean;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
