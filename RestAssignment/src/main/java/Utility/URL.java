package Utility;

public class URL {
	public static final String URL = "http://rest-api.upskills.in/api/rest_admin";
	
	public static String getEndpoint()
	{
		return URL;
		
	}
	public static String getEndpoints(String resource)
	{
		return URL+resource;
		
	}
	
	
}
