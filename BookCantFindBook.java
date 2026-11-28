package lab5.tests;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Book;
import lab5.BorrowingService;
import lab5.Library;
import lab5.Member;
import lab5.PaperBook;

public class BookCantFindBook {
	private BorrowingService bs = BorrowingService.getInstance();
	private Library lib = new Library();
	
	Member mem;
	Book b = new PaperBook("Dune");
	
	@BeforeEach
	void setUp() throws Exception {
		mem = new Member("Alice", bs);
		b.setIsAvailable(true);
	}
	@Test
	void cantFindBook() {
		assertTrue(b.getIsAvailable(), "Book must be available");
		lib.removeBook(b.getTitle());
		assertTrue(bs.borrowBook(mem, b, lib).isSuccess() == false && bs.borrowBook(mem, b, lib).getBorrowingMessage().equals(b + " cannot be found in the library..."), "Book can't be found.");
	}
}
