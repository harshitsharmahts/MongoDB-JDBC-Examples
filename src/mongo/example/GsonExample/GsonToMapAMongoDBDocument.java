package mongo.example.GsonExample;

import com.google.gson.Gson;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Iterator;

public class GsonToMapAMongoDBDocument
{
	private static final String HOST = "localhost";
	private static final int PORT = 27017;
	private static final String DATABASE_NAME = "foobar";
	private static final String COLLECTION_NAME  = "blog";

	public static void main(String[] args)
	{
		MongoClient mongoClient = new MongoClient(HOST,PORT);
		MongoDatabase mongoDatabase = mongoClient.getDatabase(DATABASE_NAME);
		MongoCollection mongoCollection = mongoDatabase.getCollection(COLLECTION_NAME);

		Document document = new Document("name", "Harshit Sharma")
		                    .append("age",19)
							.append("email", "harshitsharmahts@gmail.com")
							.append("phone","+91 9587910916");

		mongoCollection.insertOne(document);

		FindIterable<DBObject> findIterable = mongoCollection.find(Filters.eq("name","Harshit Sharma"));

		Iterator<DBObject> iterator = findIterable.iterator();

		Gson gson = new Gson();

//		Person person = gson.fromJson(iterator.next().toString(),Person.class);

		System.out.println(iterator.next().toString());
	}
}