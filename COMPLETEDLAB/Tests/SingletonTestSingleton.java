package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lab5.BorrowingService;

public class SingletonTestSingleton {
	@Test
	void TestSingleton() {
		BorrowingService bs1 = BorrowingService.getInstance();
		BorrowingService bs2 = BorrowingService.getInstance();
		assertEquals(bs1, bs2, "Two Singleton instances detected");
	}
}
