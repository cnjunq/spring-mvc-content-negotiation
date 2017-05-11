package io.junq.examples.spring.web;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.junq.examples.spring.model.User;

@Controller
public class UserRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);
	
    Map<Long, User> usersMap = new HashMap<>();
    
    @ModelAttribute("users")
    public void initUsers() {
    	User annie = new User("Annie", "annie@sample.com", "18600090009");
    	annie.setId(1L);
    	
    	User bill = new User("Bill", "bill@sample.com", "13900010001");
    	bill.setId(2L);
    	
    	User carter = new User("Carter", "carter@sample.com", "13700020002");
    	carter.setId(3L);
    	
    	usersMap.put(annie.getId(), annie);
    	usersMap.put(bill.getId(), bill);
    	usersMap.put(carter.getId(), carter);
    }

	@RequestMapping(value = "/users/{id}", produces = { "application/json",
			"application/xml" }, method = RequestMethod.GET)
	public @ResponseBody User getUserById(@PathVariable long id) {
		LOGGER.debug("try to get user info " + id);
		User user = usersMap.get(id);
		//TODO user not found
		return user;
	}

}
