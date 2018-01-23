package mongo.example.assignment;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Iterator;

public class Q9 {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient(C.HOST,C.PORT_NUMBER);
        MongoDatabase mongoDatabase = mongoClient.getDatabase(C.DATABASE_NAME);
        MongoCollection<Document> mongoCollection = mongoDatabase.getCollection(C.COLLECTION_NAME);

        /*
         *
         * {
         *   "grades.score" : {
         *       "gt" : 80,
         *       "lt" : 100
         *   }
         * }
         *
         * */
        Document query = new Document("grades.score",
                new Document("$gt",80)
                        .append("$lt",100)
        );

        FindIterable<Document> findIterable = mongoCollection.find(query);

        Iterator<Document> iterator = findIterable.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
            System.out.println();
        }
    }
}
