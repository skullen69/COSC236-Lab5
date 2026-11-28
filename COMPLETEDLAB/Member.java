package lab5;

import java.util.ArrayList;

public class Member {

	private String name;
	private ArrayList<Book> borrowedBooks; // Book class dependency
	private BorrowingService borrowingService;
	
	public Member(String name, BorrowingService service) {
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
		this.borrowingService = service;
	}
	public String getName() {
		return name;
	}
	public ArrayList<Book> getBorrowedBooks() { 
		return borrowedBooks;
	}
	public BorrowingService getService() {
		return this.borrowingService;
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
		BorrowingBookResult result = this.borrowingService.borrowBook(this, book, lib);
		System.out.println(result.getBorrowingMessage());
	}
	public void returnBook(Book book, Library lib) {
		BorrowingBookResult result = this.borrowingService.returnBook(this, book, lib);
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
		for (Book b : new ArrayList<>(borrowedBooks)) {
			this.borrowingService.returnBook(this, b, lib);
		}
	}
}
