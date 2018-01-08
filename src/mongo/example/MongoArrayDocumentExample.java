/**
 * @author : Harshit Sharma
 */

package mongo.example;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MongoArrayDocumentExample
{
	private static final String HOST = "localhost";
	private static final int PORT = 27017;
	private static final String DATABASE_NAME = "foobar";
	private static final String COLLECTION_NAME  = "blog";

	public static void main(String[] args)
	{
		MongoClient mongoClient = new MongoClient(HOST,PORT);
		MongoDatabase mongoDatabase = mongoClient.getDatabase(DATABASE_NAME);
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(COLLECTION_NAME);

		List<Document> fruits = new ArrayList<>();
		fruits.add(new Document("name", "clara").append("age" , 12));
		fruits.add(new Document("name", "henry").append("age" , 13));
		fruits.add(new Document("name", "cisco").append("age" , 14));
		fruits.add(new Document("name", "kathy").append("age" , 15));

		Document document = new Document("name" , "Ramon")
	                       .append("age",42)
						   .append("kids",fruits);

		mongoCollection.insertOne(document);
		System.out.println("Inserted.");

		FindIterable<Document> findIterable = mongoCollection.find();

		Iterator<Document> iterator = findIterable.iterator();

		while(iterator.hasNext())
		{
			System.out.println(iterator.next().get("kids"));    //accessing embedded document
		}

		System.out.println("Executed.");
	}
}
