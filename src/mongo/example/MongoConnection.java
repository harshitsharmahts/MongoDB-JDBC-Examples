package mongo.example;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnection
{
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 27017;

	public static void main(String[] args)
	{
		try {
			MongoClient mongo = new MongoClient( HOST , PORT );

			MongoDatabase database = mongo.getDatabase("foobar");

			System.out.println("Successfully connected..");
		}
		catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " +e.getMessage() );
		}
	}
}
