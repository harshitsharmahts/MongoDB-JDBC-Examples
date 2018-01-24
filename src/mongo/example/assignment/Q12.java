/**
 * Find the restaurants which do not prepare any
 * cuisine of 'American' and achieved a score more
 * than 70 and located in the longitude less than -65.754168.
 */
package mongo.example.assignment;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Iterator;

public class Q12 {
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
         *   "address.coord.1" : {
         *      $lt : -65.754168
         *   }
         * }
         *
         * */

        Document query = new Document("cuisine",new Document("$ne","American"))
                .append("grades.score",new Document("$gt",70))
                .append("address.coord.1",new Document("$lt",-65.754168));

        FindIterable<Document> findIterable = mongoCollection.find(query);

        Iterator<Document> iterator = findIterable.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
            System.out.println();
        }
    }
}
