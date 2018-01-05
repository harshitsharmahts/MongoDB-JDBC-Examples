import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Iterator;

public class MongoFind
{
	private static final String HOST = "localhost";
	private static final int PORT = 27017;

	public static void main(String[] args)
	{
		//  creating mongo client
		MongoClient mongoClient = new MongoClient(HOST,PORT);

		//  accessing database
		MongoDatabase mongoDatabase = mongoClient.getDatabase("foobar");

		//  retrieving collection
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("blog");

		//
		FindIterable<Document> findIterable = mongoCollection.find();

		//
		Iterator<Document> iterator = findIterable.iterator();

		while (iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
	}
}
