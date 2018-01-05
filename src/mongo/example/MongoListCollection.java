package mongo.example;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoListCollection
{
	private static final String HOST = "localhost";
	private static final int PORT = 27017;
	private static final String DATABASE_NAME = "foobar";

	public static void main(String[] args)
	{
		MongoClient mongoClient = new MongoClient( HOST, PORT );

		MongoDatabase mongoDatabase = mongoClient.getDatabase(DATABASE_NAME);

		for (String name : mongoDatabase.listCollectionNames()) {
			System.out.println(name);
		}
	}
}
