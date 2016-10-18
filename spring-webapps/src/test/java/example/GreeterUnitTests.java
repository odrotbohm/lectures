package example;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class GreeterUnitTests {

	@Test
	public void augmentsYayToTuDresden() {

		Greeter greeter = new Greeter();

		assertThat(greeter.greet("TU Dresden")).isEqualTo("TU Dresden, yay");
	}
}
