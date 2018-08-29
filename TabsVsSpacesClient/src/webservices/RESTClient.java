package webservices;

import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class RESTClient {
	public static void main(String[] argv){
		System.out.println("Enter a poid (integer): ");
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		//create a client
		Client client = ClientBuilder.newClient();
		//create a web target
		WebTarget wt=client.target("http://localhost:8080/TabsVsSpaces/rest/tvs/getOrdersByPartNumber/");
		//add the query parameter
		wt.queryParam("poid", input);	
		//create a request and invoke get; the argument of get is the type of return
		String price = wt.request().get(String.class);
		System.out.println(price);   
		scanner.close();
		client.close();	
	}
}
