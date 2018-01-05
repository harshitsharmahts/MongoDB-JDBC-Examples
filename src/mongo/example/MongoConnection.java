/**
 * @author : Harshit Sharma
 */

package mongo.example;

import com.mongodb.MongoClient;

public class MongoConnection
{
	private static final String HOST = "127.0.0.1";
	private static final int PORT = 27017;

	public static void main(String[] args)
	{
		try {
			MongoClient mongo = new MongoClient( HOST , PORT );
			System.out.println("Successfully connected..");
		}
		catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " +e.getMessage() );
		}
	}
}
