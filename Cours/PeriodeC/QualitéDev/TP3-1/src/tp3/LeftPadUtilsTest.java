package tp3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LeftPadUtilsTest {

	@Test
	void test() {
		assertNull(LeftPadUtils.leftPad(null, 5, "-")); // str null
		assertEquals("-----", LeftPadUtils.leftPad("", 5, "-")); // str vide
		assertEquals("abc", LeftPadUtils.leftPad("abc", -1, "-")); // size négatif
		assertEquals("  abc", LeftPadUtils.leftPad("abc", 5, null)); // padStr null
		assertEquals("  abc", LeftPadUtils.leftPad("abc", 5, "")); // padStr vide
		
		assertEquals("--abc", LeftPadUtils.leftPad("abc", 5, "-")); // str non vide, size positif, padStr non vide
		assertEquals("#@abc", LeftPadUtils.leftPad("abc", 5, "#@!")); // pour la couverture de code
		assertEquals("#@abc", LeftPadUtils.leftPad("abc", 5, "#@")); // pour la couverture de code
		
		assertSame("abc", LeftPadUtils.leftPad("abc", 0, "-")); // size == 0
		assertSame("abc", LeftPadUtils.leftPad("abc", 2, "-"));
		assertSame("abc", LeftPadUtils.leftPad("abc", 3, "-")); // size == len(str)
		
	}

}
