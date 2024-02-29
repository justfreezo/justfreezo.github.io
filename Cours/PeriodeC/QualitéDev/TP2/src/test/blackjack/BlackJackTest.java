package test.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import blackjack.BlackJack;

class BlackJackTest {

	@Test
	void test() {
		BlackJack bj = new BlackJack();
		assertEquals(21, bj.play(22, 21));
		assertEquals(21, bj.play(21, 22));

	}

}
