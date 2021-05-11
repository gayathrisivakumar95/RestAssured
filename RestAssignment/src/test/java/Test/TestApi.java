package Test;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import Project.BasicToken;
import Project.RestCalls;
import Utility.PayloadConverter;
import Utility.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestApi {
	static Response response;
	String access;
	Response responseone;
	Response responsetwo;
	Response responsethree;
	
	@BeforeTest
	public void token()
	{
		access = BasicToken.getbasictoken();
	}
	

	@Test(priority=0)
	public void login() throws IOException 
	{
		String loginpayload = PayloadConverter.generatePayloadString("Login.json");
		String endpointuri = URL.getEndpoints("/login");
		response = RestCalls.PostRequestwithheader(endpointuri,loginpayload,access);
		String strres= response.getBody().asString();
		JsonPath jsonres = new JsonPath(strres);
		int message = jsonres.get("success");
		if(message==1)
		{
			System.out.println("Login success");
		}
		
		
	}
	@Test(priority=1)
	public void getallProducts()
	{
		
		String producturi = URL.getEndpoints("/products");
		responseone = RestCalls.GetRequest(producturi,access);
		String strres= responseone.getBody().asString();
		JsonPath jsonres = new JsonPath(strres);
		
		int messageone = jsonres.get("success");
		if(messageone==1)
		{
			System.out.println("Got list of all products");
		
		}
		
		List<String> idList = jsonres.getList("data.id");

        
        System.out.println(idList.toString());
        
		}
	@Test(priority=2)
	public void updateBulkProducts() throws IOException
	{
		String Bulk = PayloadConverter.generatePayloadString("UpdateBulkProduct.json");
		String bulkapi = URL.getEndpoints("/bulk_products");
		responsetwo =  RestCalls.PostRequestwithheader(bulkapi, Bulk, access);
		String strres= responsetwo.getBody().asString();
		JsonPath jsonres = new JsonPath(strres);
		
		int messageone = jsonres.get("success");
		if(messageone==1)
		{
			System.out.println("updated bulk prodcuts");
		
		}
		}
	@Test(priority=3)
	public void Logout() throws IOException
	{
		
		String logout = URL.getEndpoints("/logout");
		responsethree =  RestCalls.PostRequestwithoutbody(logout, access);
		String strres= responsethree.getBody().asString();
		JsonPath jsonres = new JsonPath(strres);
		
		int messageone = jsonres.get("success");
		if(messageone==1)
		{
			System.out.println("Logout Success");
		
		}
	}
	
	
}
	

