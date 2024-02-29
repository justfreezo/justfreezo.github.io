package tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LeftPadUtilsTest {

	@Test
	void test() {
		assertNull(LeftPadUtils.leftPad(null, 3, "-"));
		assertEquals("---", LeftPadUtils.leftPad("", 3, "-"));
		
		assertEquals("----abc", LeftPadUtils.leftPad("abc", 7, "-"));
		assertEquals("abc", LeftPadUtils.leftPad("abc", -1, "-"));
		
		assertEquals(" abc", LeftPadUtils.leftPad("abc", 4, null));
		assertEquals("   abc", LeftPadUtils.leftPad("abc", 6, ""));
		
		assertEquals("123abc", LeftPadUtils.leftPad("abc", 6, "1234"));
	}
}