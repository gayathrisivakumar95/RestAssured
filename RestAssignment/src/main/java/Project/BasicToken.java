package Project;

import Utility.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BasicToken {
	
	static Response res;
	static String access_token;
	static String basetoken;
	public static String getbasictoken()
	{
		String endpointuri = URL.getEndpoints("/oauth2/token/client_credentials");
		basetoken = "dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9jbGllbnQ6dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9zZWNyZXQ=";
		res = RestCalls.PostRequestwithoutbody(endpointuri,basetoken);
		String strres= res.getBody().asString();
		JsonPath baseres = new JsonPath(strres);
		access_token = baseres.get("data.access_token");
		return access_token;
		
	}

}
