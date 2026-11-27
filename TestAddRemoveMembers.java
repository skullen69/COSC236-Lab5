package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.Book;
import lab5.Library;
import lab5.Member;
import lab5.PaperBook;

class TestAddRemoveMembers {

	
	private Library lib;
	
	@BeforeEach
	void setUp() throws Exception {
		 this.lib = new Library(); // empty library for each test
	}
	
	Member member1 = new Member("Dude");
	Member member2 = new Member("Gal");
	Book book1 = new PaperBook("Dune");
	Book book2 = new PaperBook("1984");
	
	@Test
	void AddMember() {
		
		assertEquals(lib.membersCount(), 0, "Should be no members after initialization");	
		lib.addMember(member1);	
		assertEquals(lib.membersCount(), 1, "One member should have been added");	
		lib.addMember(member2);
		assertEquals(lib.membersCount(), 2, "Two members should have been added");	
		
	}
	
	@Test
	void RemoveMembersMember() {
		
		AddMember();
		assertEquals(lib.membersCount(), 2, "Two members should have been in the library");
		lib.removeMember(member2);
		assertEquals(lib.membersCount(), 1, "Only one member should remain");
	}
	@Test
	void RemoveMemberString() {
		
		AddMember();
		assertEquals(lib.membersCount(), 2, "Two members should have been in the library");
		lib.removeMember("Dude");
		assertEquals(lib.membersCount(), 1, "Only one member should remain");
	}

	
	// Fix
	@Test
	void RemoveMemberWithBooks() {
		
		AddMember();
		assertEquals(lib.membersCount(), 2, "Two members should be in the library");
		lib.addBook(book1);
		lib.addBook(book2);
		assertEquals(lib.booksCount(), 2, "Two books should be in the library");
		
		member1.borrowBook(book1, lib);
		member1.borrowBook(book2, lib);
		assertEquals(member1.borrowedBooksCount(), 2, "Should be two borrowed books");
		assertFalse(book1.getIsAvailable(), "Book should be not available");
		assertFalse(book2.getIsAvailable(), "Book should be not available");
		
		lib.removeMember(member1.getName());
		assertEquals(lib.membersCount(), 1, "Only one member should remain");
		assertEquals(lib.booksCount(), 2, "Two books should be in the library");
		assertTrue(book1.getIsAvailable(), "Book should be available");
		assertTrue(book2.getIsAvailable(), "Book should be available");
				
	}
}
