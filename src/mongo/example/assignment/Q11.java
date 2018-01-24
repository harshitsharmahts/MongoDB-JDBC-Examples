/**
 * Find the restaurants that do not prepare any
 * cuisine of 'American' and their grade score more
 * than 70 and latitude less than -65.754168.
 */
package mongo.example.assignment;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Iterator;

public class Q11 {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient(C.HOST,C.PORT_NUMBER);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(C.DATABASE_NAME);
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(C.COLLECTION_NAME);

        /*
         *
         * {
         *   "cuisine" : {
         *      $ne : "American"
         *   },
         *   "grades.score" : {
         *      $gt : 70
         *   },
         *   "address.coord.0" : {
         *      $lt : -65.754168
         *   }
         * }
         *
         * */

        Document query = new Document("cuisine",new Document("$ne","American"))
                .append("grades.score",new Document("$gt",70))
                .append("address.coord.0",new Document("$lt",-65.754168));

        FindIterable<Document> findIterable = mongoCollection.find(query);

        Iterator<Document> iterator = findIterable.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
            System.out.println();
        }
    }
}
