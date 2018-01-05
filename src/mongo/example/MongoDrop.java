/**
 * @author : Harshit Sharma
 */

package mongo.example;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDrop
{
	private static final String HOST = "localhost";
	private static final int PORT = 27017;
	private static final String DATABASE_NAME = "foobar";
	private static final String COLLECTION_NAME  = "blog";

	public static void main(String[] args)
	{
		// creating mongo client
		MongoClient mongoClient = new MongoClient(HOST,PORT);

		// choose database
		MongoDatabase mongoDatabase = mongoClient.getDatabase(DATABASE_NAME);

		//
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(COLLECTION_NAME);

		//
		mongoCollection.drop();

		//
		System.out.println("Collection has dropped.. :0");

	}
}
