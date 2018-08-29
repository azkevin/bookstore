package webservices;

import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import bean.POBean;
import model.Model;

@Path("tvs")  //this is the path of the service
public class REST_TVS {
	private Model sis;
	private Map<Integer, POBean> orders;
     
	public REST_TVS() {
    	try {
			this.sis = new Model();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/* GET tvs/getOrdersByPartNumber?poid=x   */
	//this is a READ method on the service
	//the resource name is plant, the operation is get, the parameters are passed as 
	//query parameters in the url
	//once you deploy this, you can access this method with
	//http://localhost:8080/TabsVsSpaces/rest/tvs/getOrdersByPartNumber?poid=1
	@GET
    @Path("/getOrdersByPartNumber/")
	@Produces(MediaType.APPLICATION_XML)
	public POBean getOrdersByPartNumber(@DefaultValue("1") @QueryParam("poid") int poid) {
		try {
			orders = sis.retrieveByPOId(poid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orders.get(poid);
		
	}
}
