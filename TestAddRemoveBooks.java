package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Book;
import lab5.BorrowingService;
import lab5.Library;
import lab5.Member;
import lab5.PaperBook;



class TestAddRemoveBooks {
	
	private Library lib;
	private BorrowingService bs = BorrowingService.getInstance();
	
	@BeforeEach
	void setUp() throws Exception {
		 this.lib = new Library(); // empty library for each test
	}

	Book book1 = new PaperBook("Dune");
	Book book2 = new PaperBook("1984");
	Book book3 = new PaperBook("Moby Dick");
	
	Member member = new Member("Grady Booch", bs);
	
	@Test
	void AddBooks() {
		
		assertEquals(lib.booksCount(), 0, "Should be no books in library");	
		lib.addBook(book1);
		lib.addBook(book2);
		lib.addBook(book3);
		assertEquals(lib.booksCount(), 3, "There should be 3 books in the library");
	}
	
	@Test
	void RemoveBooksBook() {
		
		AddBooks();
		assertEquals(lib.booksCount(), 3, "There should be 3 books in the library");
		lib.removeBook(book2);
		lib.removeBook(book3);
		assertEquals(lib.booksCount(), 1, "There should be only one book left in the library");
		// Validating correctness by adding more books and double checking book count.
		lib.addBook(new PaperBook("Harry Potter"));
		lib.addBook(new PaperBook("The Hobbit"));
		assertEquals(lib.booksCount(), 3, "There should be only three books left in the library");
	}
	
	@Test
	void RemoveBooksString() {
		
		AddBooks();
		assertEquals(lib.booksCount(), 3, "There should be 3 books in the library");
		lib.removeBook("Dune");
		assertEquals(lib.booksCount(), 2, "There should be only two book left in the library");
	}
	
	@Test
	void RemoveBorrowedBook() {
		
		AddBooks();
		assertEquals(lib.booksCount(), 3, "There should be 3 books in the library");
		
		member.borrowBook(book1, lib);
		assertEquals(member.borrowedBooksCount(), 1, "Should be 1 borrowed book");
		
		lib.removeBook(book1.getTitle());
		assertEquals(lib.booksCount(), 2, "There should be only two book left in the library");
		
		assertEquals(member.borrowedBooksCount(), 1, "The book should stay with member"); // 
		
		Book b = member.getBorrowedBooks().get(0); // the only book
		assertEquals(b, book1,"The owned book should be the removed book");
	}
	
	
}
