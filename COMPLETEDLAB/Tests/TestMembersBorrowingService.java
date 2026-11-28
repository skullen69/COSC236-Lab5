package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lab5.BorrowingService;
import lab5.Member;

public class TestMembersBorrowingService {
	BorrowingService bs = BorrowingService.getInstance();
	
	@Test
	void TestMemberServices() {
		Member m1 = new Member("Member 1", bs);
		Member m2 = new Member("Member 2", bs);
		assertEquals(m1.getService(), m2.getService(), "Members have two different borrowing services");
	}
}
