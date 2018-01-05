import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoInsert
{
	private static final int PORT = 27017;
	private static final String HOST = "localhost";
	public static void main(String[] args)
	{
		// Create Client
		MongoClient mongoClient = new MongoClient(HOST,PORT);

		// Use foobar
		MongoDatabase mongoDatabase = mongoClient.getDatabase("foobar");

		// select collection
		MongoCollection<Document> mongoCollection =  mongoDatabase.getCollection("blog");

		// creating document to insert
		Document document = new Document("name", "Harshit")
				                    .append("skills", "java")
				                    .append("age", 19)
				                    .append("url", "https://harshitsharmahts.github.io/");

		// Using
		mongoCollection.insertOne(document);

		System.out.println("Document inserted..");
	}
}
