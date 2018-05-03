package bean;

public class ReviewBean {

	private int reviewid;
	private String bid;
	private int userid;
	private String username;
	private int rating;
	private String reviewdesc;
	
	public ReviewBean() {}
	
	public ReviewBean(int reviewid, String bid, int userid, String username, int rating, String reviewdesc) {
		super();
		this.reviewid = reviewid;
		this.bid = bid;
		this.userid = userid;
		this.username = username;
		this.rating = rating;
		this.reviewdesc = reviewdesc;
	}
	
	public int getReviewid() {
		return reviewid;
	}

	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviewdesc() {
		return reviewdesc;
	}

	public void setReviewdesc(String reviewdesc) {
		this.reviewdesc = reviewdesc;
	}

}
