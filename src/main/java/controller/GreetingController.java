package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DBObject;
import com.mongodb.WriteResult;

import model.Greeting;
import service.GreetingService;

@RestController
@RequestMapping("greetings")
public class GreetingController {

	@Autowired
	private GreetingService greetingService;

	/**
	 * Get Greetings list by criteria
	 * @param id Greeting object id or all
	 * @return List<DBObject> of greetings
	 */
	@RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
	public List<DBObject> readGreeting(@PathVariable("id") String id) {
		return greetingService.readGreeting(id);
	}

	/**
	 * Create a new Greeting
	 * @param greeting Greeting object for adding
	 * @return Object WriteResult, that contains request result info
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public WriteResult createGreeting(@RequestBody Greeting greeting) {
		return greetingService.createGreeting(greeting);
	}

	/**
	 * Update an existing Greeting
	 * @param greeting Greeting object for updating
	 * @return Object WriteResult, that contains request result info
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public WriteResult updateGreeting(@RequestBody Greeting greeting) {
		return greetingService.updateGreeting(greeting);
	}

	/**
	 * Remove an Greeting
	 * @param id Greeting id
	 * @return Object WriteResult, that contains request result info
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public WriteResult deleteGreeting(@PathVariable("id") String id) {
		return greetingService.deleteGreeting(id);
	}

}