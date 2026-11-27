package lab5;

public class BorrowingService implements BorrowingServiceAPI {
	@Override
	public boolean borrowBook(Member member, Book book) {
		if (member.hasBorrowed(book) || !book.getIsAvailable()) {
			return false;
		}
		book.setIsAvailable(false);
		member.addBook(book);
		return true;
		
	}
	
	
	@Override
	public boolean returnBook(Member member, Book book) {
		if (!member.hasBorrowed(book)) {
			return false;
		}
		book.setIsAvailable(true);
		member.removeBook(book);
		return true;
	}
}
