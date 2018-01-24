/**
 * Find the restaurants which do not prepare any
 * cuisine of 'American ' and achieved a grade point
 * 'A' not belongs to the borough Brooklyn.
 * The document must be displayed according
 * to the cuisine in descending order
 */
package mongo.example.assignment;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Iterator;

public class Q13 {
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
         *   "grades.grade" : "A",,
         *   "borough" : {
         *      $ne : Brooklyn
         *   }
         * }
         *
         * */

        Document query = new Document("cuisine",new Document("$ne","American"))
                .append("grades.grade","A")
                .append("borough",new Document("$ne","Brooklyn"));

        FindIterable<Document> findIterable = mongoCollection.find(query).sort(new Document("cuisine",-1));

        Iterator<Document> iterator = findIterable.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
            System.out.println();
        }
    }
}
