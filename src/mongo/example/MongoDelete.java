/**
 * @author : Harshit Sharma
 */

package mongo.example;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Iterator;

public class MongoDelete
{
	private static final String HOST = "localhost";
	private static final int PORT = 27017;
	private static final String DATABASE_NAME = "foobar";
	private static final String COLLECTION_NAME  = "blog";

	public static void main(String[] args)
	{
		//  mongo client
		MongoClient mongoClient  = new MongoClient(HOST,PORT);

		//  use database
		MongoDatabase mongoDatabase = mongoClient.getDatabase(DATABASE_NAME);

		//  selection collection to use
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(COLLECTION_NAME);

		//  deleting query
		mongoCollection.deleteOne(Filters.eq("name","Harshit"));

		//  to check changes
		FindIterable<Document> findIterable = mongoCollection.find();

		//
		Iterator<Document> iterator = findIterable.iterator();

		//
		while(iterator.hasNext())
			System.out.println(iterator.next());
	}
}
