package lab5.tests;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Book;
import lab5.BorrowingService;
import lab5.LibrarianController;
import lab5.Library;
import lab5.Member;
import lab5.PaperBook;

public class MemberBorrowLimitReached {
	private BorrowingService bs;
	private Library lib = new Library();
	
	
	Member mem;
	Book b1 = new PaperBook("Dune");
	Book b2 = new PaperBook("1984");
	Book b3 = new PaperBook("Harry Potter");
	Book b4 = new PaperBook("Moby Dick");
	
	@BeforeEach
	void setUp() throws Exception {
		mem = new Member("Alice");
		b1.setIsAvailable(true);
		b2.setIsAvailable(true);
		b3.setIsAvailable(true);
		b4.setIsAvailable(true);
		bs = new BorrowingService();
		lib.addBook(b1);
		lib.addBook(b2);
		lib.addBook(b3);
		lib.addBook(b4);
	}
	
	@Test
	void borrowLimitReached() {
		assertTrue(b1.getIsAvailable(), "Book 1 must be available");
		assertTrue(b2.getIsAvailable(), "Book 2 must be available");
		assertTrue(b3.getIsAvailable(), "Book 3 must be available");
		assertTrue(b4.getIsAvailable(), "Book 4 must be available");
		
		bs.borrowBook(mem, b1, lib);
		bs.borrowBook(mem, b2, lib);
		bs.borrowBook(mem, b3, lib);
		assertTrue(bs.borrowBook(mem, b4, lib).isSuccess() == false && bs.borrowBook(mem, b4, lib).getBorrowingMessage().equals(mem + " has reached their borrowing limit."), "Member should be at borrowing limit.");
	}
}
