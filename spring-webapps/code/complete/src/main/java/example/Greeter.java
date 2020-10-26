package example;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
class Greeter {

	String greet(String input) {

		Assert.notNull(input, "Input must not be null!");

		return input.equals("TU Dresden") ? input.concat(", yay") : input;
	}
}
