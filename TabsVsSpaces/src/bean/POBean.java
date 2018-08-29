package bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PurchaseOrder")
public class POBean {
	private int poid;
	private int userid;
	private int addressid;
	private String status;
	
	public POBean() {}
	
	public POBean(int poid, int userid, int addressid, String status) {
		this.poid = poid;
		this.userid = userid;
		this.addressid = addressid;
		this.status = status;
	}
	
	@XmlAttribute
	public int getPoid() {
		return poid;
	}
	public void setPoid(int poid) {
		this.poid = poid;
	}
	@XmlElement
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@XmlElement
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	@XmlElement
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
