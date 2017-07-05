package app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

@Service
public class GreetingService {

	private DBCollection collection;

	@SuppressWarnings("deprecation")
	public GreetingService() {

		try {
			// Connect to mongodb server
			MongoClient mongo = new MongoClient("localhost", 27017);

			// Connect to database
			DB db = mongo.getDB("test");
			
			// Getting collection
			collection = db.getCollection("greeting");

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	public List<DBObject> readGreeting(String id) {

		List<DBObject> list = new ArrayList<>();

		if (id.equals("all")) {
			DBCursor cursor = collection.find();
			while (cursor.hasNext()) {
				list.add(cursor.next());
			}
		} else {
			list.add(collection.findOne(id));
		}
		return list;
	}

	public WriteResult createGreeting(Greeting greeting) {
		return collection.save(Greeting.getDBObject(greeting));
	}

	public WriteResult updateGreeting(Greeting greeting) {
		return collection.update(collection.findOne(greeting.getId()), Greeting.getDBObject(greeting));
	}

	public WriteResult deleteGreeting(String id) {
		return collection.remove(collection.findOne(id));
	}
}
