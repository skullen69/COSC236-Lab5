package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

	private String name;
	private ArrayList<Book> borrowedBooks; // Book class dependency
	
	public Member(String name) {
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public ArrayList<Book> getBorrowedBooks() { 
		return borrowedBooks;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Member: " + name;
	}
	
	public boolean hasBorrowed(Book book) {
		return borrowedBooks.contains(book);
	}
	
	public void addBook(Book book) {
		borrowedBooks.add(book);
	}
	
	public void removeBook(Book book) {
		borrowedBooks.remove(book);
	}
	
	public void borrowBook(Book book, Library lib) {
		BorrowingService borrowingService = new BorrowingService();
		BorrowingBookResult result = borrowingService.borrowBook(this, book, lib);
		System.out.println(result.getBorrowingMessage());
	}
	public void returnBook(Book book, Library lib) {
		BorrowingService borrowingService = new BorrowingService();
		BorrowingBookResult result = borrowingService.returnBook(this, book, lib);
		System.out.println(result.getBorrowingMessage());
		
	}
	public void listBorrowedBooks() {
		for (Book book : borrowedBooks)
			System.out.println(book); // book.toString()
	}
	public int borrowedBooksCount() {
		return borrowedBooks.size();
	}
	public void returnAllBooks(Library lib) {
		BorrowingService bs = new BorrowingService();
		for (Book b : new ArrayList<>(borrowedBooks)) {
			bs.returnBook(this, b, lib);
		}
	}
}
