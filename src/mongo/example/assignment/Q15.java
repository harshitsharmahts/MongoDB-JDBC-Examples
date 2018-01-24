/**
 * Find the restaurant Id, name, borough and cuisine
 * for those restaurants which contain 'ces' as last
 * three letters for its name.
 */
package mongo.example.assignment;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Iterator;

public class Q15 {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient(C.HOST,C.PORT_NUMBER);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(C.DATABASE_NAME);
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(C.COLLECTION_NAME);

        /*
         *
         * {
         *   "name" : {
         *      $regex : "ces$"
         *   }
         * }
         *
         * */

        Document query = new Document("name",new Document("$regex","ces$"));

        FindIterable<Document> findIterable = mongoCollection.find(query)
                .projection(new Document("name",1)
                        .append("restaurant_id",1)
                        .append("cuisine",1)
                        .append("borough",1)
                        .append("_id",0)
                );

        Iterator<Document> iterator = findIterable.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
            System.out.println();
        }
    }
}
