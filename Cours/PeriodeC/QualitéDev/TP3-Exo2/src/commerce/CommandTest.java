package commerce;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CommandTest {

	private static Stream<Arguments> provideforCommand() {
	    return Stream.of(
	      Arguments.of(200., 5., false, 180.),	    // R1 ON R2 ON R4 OFF
	      Arguments.of(199.9, 5., false, 199.9),    // R1 OFF R2 ON R4 OFF
	      Arguments.of(200., 4.9, false, 180.),     // R1 ON R2 OFF R4 OFF
	      Arguments.of(199.9, 4.9, false, 199.9),   // R1 OFF R2 OFF R4 OFF
	      
	      Arguments.of(100., 5., false, 105.),	    // R3 ON R2 ON R4 OFF
	      Arguments.of(100.1, 5., false, 100.1),    // R3 OFF R2 ON R4 OFF
	      Arguments.of(100., 4.9, false, 100.),     // R3 ON R2 OFF R4 OFF
	      Arguments.of(100.1, 4.9, false, 100.1),   // R3 OFF R2 OFF R4 OFF
	      
	      Arguments.of(200., 5., true, 174.6),	    // R1 ON R2 ON R4 ON
	      Arguments.of(199.9, 5., true, 193.9),     // R1 OFF R2 ON R4 ON
	      Arguments.of(200, 4.9, true, 170.),       // R1 ON R2 OFF R4 ON R5 true
	      Arguments.of(199.9, 4.9, true, 193.9),    // R1 OFF R2 OFF R4 ON
	      
	      Arguments.of(100., 5., true, 102.),	    // R3 ON R2 ON R4 ON
	      Arguments.of(100.1, 5., true, 97.09),     // R3 OFF R2 ON R4 ON
	      Arguments.of(100., 4.9, true, 97.),       // R3 ON R2 OFF R4 ON
	      Arguments.of(100.1, 4.9, true, 97.09)     // R3 OFF R2 OFF R4 ON
	    );
	}
	
	@ParameterizedTest
	@MethodSource("provideforCommand")
	void testPrice(double price, double weight, boolean card, double expected) {
	    assertEquals(expected, new Command(price, weight, card).total(), 0.01);
	}

}
