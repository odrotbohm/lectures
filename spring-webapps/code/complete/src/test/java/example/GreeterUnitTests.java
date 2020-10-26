package example;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GreeterUnitTests {

	@Test
	public void augmentsYayToTuDresden() {

		var greeter = new Greeter();

		assertThat(greeter.greet("TU Dresden")).isEqualTo("TU Dresden, yay");
	}
}
