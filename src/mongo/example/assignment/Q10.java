/**
 * Find the restaurants which locate in latitude value less than -95.754168.
 */
package mongo.example.assignment;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Iterator;

public class Q10 {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient(C.HOST,C.PORT_NUMBER);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(C.DATABASE_NAME);
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(C.COLLECTION_NAME);

        /*
         *
         * {
         *   "address.coord.0" : {
         *       "$lt" : -95.754168
         *   }
         * }
         *
         * */

        Document query = new Document("address.coord.0",
                new Document("$lt",-95.754168)
        );

        FindIterable<Document> findIterable = mongoCollection.find(query);

        Iterator<Document> iterator = findIterable.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
            System.out.println();
        }
    }
}
