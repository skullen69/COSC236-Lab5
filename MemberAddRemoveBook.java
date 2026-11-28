package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Book;
import lab5.BorrowingService;
import lab5.Member;
import lab5.PaperBook;

public class MemberAddRemoveBook {
	
	private BorrowingService bs = BorrowingService.getInstance();
	Member mem1;
	Member mem2;
	Book b1 = new PaperBook("Dune");
	Book b2 = new PaperBook("1984");
	
	@BeforeEach
	void setUp() throws Exception {
		mem1 = new Member("Alice", bs);
		mem2 = new Member("Bob", bs);
	}
	
	@Test
	void addBook() {
		assertEquals(mem1.borrowedBooksCount(), 0, "Borrowed book should be zero");
		mem1.addBook(b1);
		assertEquals(mem1.borrowedBooksCount(), 1, "Borrowed book should be one");
		assertEquals(mem2.borrowedBooksCount(), 0, "Borrowed book should be zero");
		mem2.addBook(b2);
		assertEquals(mem2.borrowedBooksCount(), 1, "Borrowed book should be one");
	}
	
	@Test
	void removeBook() {
		assertEquals(mem1.borrowedBooksCount(), 0, "Borrowed book should be zero");
		mem1.addBook(b1);
		assertEquals(mem1.borrowedBooksCount(), 1, "Borrowed book should be one");
		mem1.removeBook(b1);
		assertEquals(mem1.borrowedBooksCount(), 0, "Borrowed book should be zero");
	}
}
