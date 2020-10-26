package example;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class MyController {

	private final Greeter greeter;

	public MyController(Greeter greeter) {
		this.greeter = greeter;
	}

	@GetMapping("/hello")
	String myMethod(@RequestParam Optional<String> name, Model model) {

		var whoToGreet = name.map(it -> greeter.greet(it)).orElse("World");

		model.addAttribute("name", whoToGreet);
		return "hello";
	}
}
