package Project;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestCalls {
	
	public static Response GetRequest(String URI,String tkn)
	{
		RequestSpecification requestspecification = RestAssured.given();
		requestspecification.contentType(ContentType.JSON);
		requestspecification.header("Authorization", "Bearer "+tkn);
		Response response = requestspecification.get(URI);
		return response;
	}
	public static Response PostRequestwithoutbody(String URI,String tkn)
	{
		RequestSpecification requestspecification = RestAssured.given();
		requestspecification.contentType(ContentType.JSON);
		requestspecification.header("Authorization", "Basic "+tkn);
		Response response = requestspecification.post(URI);
		
		return response;
	}
	public static Response PostRequest(String URI,String strjson)
	{
		RequestSpecification requestspecification = RestAssured.given().body(strjson);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.post(URI);
		return response;
	}
	public static Response PostRequestwithheader(String URI,String strjson,String token)
	{
		RequestSpecification requestspecification = RestAssured.given().body(strjson);
		requestspecification.contentType(ContentType.JSON);
		requestspecification.header("Authorization","Bearer "+token);
		Response response = requestspecification.post(URI);
		return response;
	}
	public static Response PutRequest(String URI,String strjson)
	{
	
		RequestSpecification requestspecification = RestAssured.given().body(strjson);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.put(URI);
		return response;
	}

	public static Response DeleteRequest(String URI,String strjson)
	{
		RequestSpecification requestspecification = RestAssured.given().body(strjson);
		requestspecification.contentType(ContentType.JSON);
		Response response = requestspecification.delete(URI);
		return response;
	}
	


	}
