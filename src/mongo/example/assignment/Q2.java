/**
 * Display the fields restaurant_id, name,
 * borough and cuisine for all the documents
 * in the collection restaurant.
 */
package mongo.example.assignment;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;

public class Q2 {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient(C.HOST,C.PORT_NUMBER);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(C.DATABASE_NAME);
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(C.COLLECTION_NAME);

        Document query = new Document("$project",
                new Document("restaurant_id",1)
                .append("name",1)
                .append("borough",1)
                .append("cuisine",1)
        );
        ArrayList<Document> arrayList = new ArrayList<Document>();
        arrayList.add(query);

        AggregateIterable<Document> findIterable = mongoCollection.aggregate(arrayList);

        Iterator<Document> iterator = findIterable.iterator();

        while (iterator.hasNext()){
            System.out.println(
                    iterator.next()
            );
            System.out.println();
        }
    }
}
