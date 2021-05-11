package Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PayloadConverter {
	public static String generatePayloadString(String filename) throws IOException
	{
		String filepath = "C:\\Users\\GayathriS\\git\\RestAssured\\RestAssignment\\resource\\" +filename ;
		return new String (Files.readAllBytes(Paths.get(filepath)));
	}

}
