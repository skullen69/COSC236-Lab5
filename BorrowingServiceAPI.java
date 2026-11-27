package lab5;

public interface BorrowingServiceAPI {
	public BorrowingBookResult borrowBook(Member member, Book book, Library lib);
	
	public BorrowingBookResult returnBook(Member member, Book book, Library lib);
}
