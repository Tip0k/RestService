package app;

//import org.springframework.data.annotation.Id;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Greeting {

	//@Id
	private String id;
	private String content;

	public Greeting() {
		
	}
	
	public Greeting(String id, String content) {
		this.id = id;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static final DBObject getDBObject(Greeting greeting) {
		return new BasicDBObject("_id", greeting.getId()).append("name", greeting.getContent());
	}
}
