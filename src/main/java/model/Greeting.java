package model;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class Greeting {

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

	/**
	 * Convert Greeting object to DBObject
	 * 
	 * @param greeting convert object
	 * @return DBObject that represents Greeting object
	 */
	public static final DBObject getDBObject(Greeting greeting) {
		return new BasicDBObject("_id", greeting.getId()).append("name", greeting.getContent());
	}
}
