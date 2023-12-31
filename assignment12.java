import java.util.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.*;

public class assignment12 {

	public static void main(String[] args) {
		
		System.out.println("Hello World");
		
		// Can pass this uri obj to below mongoclient constructor
		MongoClientURI connUri = new MongoClientURI("mongodb://10.10.10.176");
		
		
		// Connect with mongodb server
		MongoClient mongoClient = new MongoClient(connUri);
		
		
		// Get existing or create database
		MongoDatabase db = mongoClient.getDatabase("31109_db");
		
		
		// List the existing collections
		for(String name : db.listCollectionNames()) {
			System.out.println(name);
		}
		System.out.println();
		
		
		// Create a new collection (Note: It will give error if collection already exists)
		// db.createCollection("connectivity_test");
		
		
		// Create collection object to perform CRUD
		MongoCollection collection = db.getCollection("connectivity_test");
		
		
		// 1] CREATE
		Document doc1 = new Document("name", "Bhupendra Jogi");
		collection.insertOne(doc1);
		Document doc2 = new Document("name", "Elvish Bhai");
		collection.insertOne(doc2);
		System.out.println();
		
		
		// 2] READ
		FindIterable itf = collection.find();
		MongoCursor it = itf.iterator();
		System.out.println("Reading");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
		
		
		// 3] UPDATE
		collection.updateOne( Filters.eq("name", "Elvish Bhai"), Updates.set("name", "Elvish Bhaiiiii....") );
		System.out.println();
		System.out.println("After Update");
		FindIterable itf1 = collection.find();
		MongoCursor it1 = itf1.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		
		// 4] DELETE
		collection.deleteMany( Filters.eq("name", "Bhupendra Jogi"));
		System.out.println();
		System.out.println("After Delete");
		FindIterable itf2 = collection.find();
		MongoCursor it2 = itf1.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		
	}

}























