package lab5;

public class BorrowingService implements BorrowingServiceAPI {
	private static BorrowingService instance;
	private int borrowingLimit;
	private BorrowingService() {
		borrowingLimit = 3;
	}
	
	public static synchronized BorrowingService getInstance() {
		if (instance == null) {
			instance = new BorrowingService();
		}
		return instance;
	}
	
	@Override
	public BorrowingBookResult borrowBook(Member member, Book book, Library lib) {
		if (member == null || book == null) {
			return new BorrowingBookResult(false, "Invalid member or book");
		}
		if (member.hasBorrowed(book)) {
			return new BorrowingBookResult(false, "Cannot borrow " + book + ". " + member + " has this book already.");
		}
		if (!book.getIsAvailable()) {
			return new BorrowingBookResult(false, "Cannot borrow " + book + ". It is unavailable.");
		}
		if (lib.findBookByTitle(book.getTitle()) == null) {
			return new BorrowingBookResult(false, book + " cannot be found in the library...");
		}
		if (member.getBorrowedBooks().size() >= borrowingLimit) {
			return new BorrowingBookResult(false, member + " has reached their borrowing limit.");
		}
		book.setIsAvailable(false);
		member.addBook(book);
		return new BorrowingBookResult(true, book + " has been borrowed...");
		
	}
	
	
	@Override
	public BorrowingBookResult returnBook(Member member, Book book, Library lib) {
		if (!member.hasBorrowed(book)) {
			return new BorrowingBookResult(false, book + " has not been borrowed.");
		}
		if (book.getIsAvailable()) {
			return new BorrowingBookResult(false, book + " has already been returned");
		}
		if (member == null || book == null) {
			return new BorrowingBookResult(false, "Invalid member or book");
		}
		book.setIsAvailable(true);
		member.removeBook(book);
		return new BorrowingBookResult(true, book + " has been returned...");
	}
}
