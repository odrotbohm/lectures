package example;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class MyController {

	private final Greeter greeter;

	public MyController(Greeter greeter) {
		this.greeter = greeter;
	}

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	String myMethod(@RequestParam Optional<String> name, Model model) {

		String whoToGreet = name.map(it -> greeter.greet(it)).orElse("World");

		model.addAttribute("name", whoToGreet);
		return "hello";
	}
}
