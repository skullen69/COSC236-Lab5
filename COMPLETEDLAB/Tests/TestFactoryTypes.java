package lab5.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lab5.AudioBook;
import lab5.AudioBookFactory;
import lab5.BookFactory;
import lab5.EBook;
import lab5.EBookFactory;
import lab5.LibrarianController;
import lab5.PaperBook;
import lab5.PaperBookFactory;

public class TestFactoryTypes {
	private LibrarianController libCon = new LibrarianController();
	@Test
	void factoryTypesTests() {
		libCon.addBook(new PaperBookFactory(), "Dune");
		assertEquals(libCon.getLibrary().findBookByTitle("Dune").toString(), "Book: Dune");
		libCon.addBook(new AudioBookFactory(), "1984");
		assertEquals(libCon.getLibrary().findBookByTitle("Dune").toString(), "Book: Dune");
		libCon.addBook(new EBookFactory(), "Moby Dick");
		assertEquals(libCon.getLibrary().findBookByTitle("Dune").toString(), "Book: Dune");
		
		assertTrue(libCon.getLibrary().findBookByTitle("Dune") instanceof PaperBook);
		assertTrue(libCon.getLibrary().findBookByTitle("1984") instanceof AudioBook);
		assertTrue(libCon.getLibrary().findBookByTitle("Moby Dick") instanceof EBook);
		
	}
}
