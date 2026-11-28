package lab5;

public class LibrarianController {
	
	private Library library; // Library dependency
	private BorrowingService borrowingService;
	// Part 8 Task 3
	private BookFactory audioBookFactory;
	private BookFactory paperBookFactory;
	private BookFactory eBookFactory;
	public LibrarianController( ) {
		this.borrowingService = BorrowingService.getInstance();
		this.library = new Library(); // Constructor injection
		// Part 8 Task 3
		this.audioBookFactory = new AudioBookFactory();
		this.paperBookFactory = new PaperBookFactory();
		this.eBookFactory = new EBookFactory();
	}
	public Library getLibrary() {
		return this.library;
	}
	public void showBooks() {
		library.showBooks();
	}
	public void showMembers() {
		library.showMembers();
	}
	public void addBook(BookFactory factory, String title) {
		library.addBook(factory.createBook(title));
	}
	public void addPaperBook(String title) {
		addBook(paperBookFactory, title);  // Book class constructor dependency
	}
	public void addEBook(String title) {
		addBook(eBookFactory, title);  // Book class constructor dependency
	}
	public void addAudioBook(String title) {
		addBook(audioBookFactory, title);;  // Book class constructor dependency
	}
	public void addMember(String name) {
		library.addMember(new Member(name, borrowingService)); // Member class constructor dependency
	}
	public void removeBook(String title) {
		library.removeBook(title); // remove 
	}
	public void removeMember(String name) {
		library.removeMember(name);
	}
	public void showMember(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			System.out.println(member);
		else 
			System.out.println("Member " + name + " not found.");
	}
	public void showBook(String title) {
		Book book = library.findBookByTitle(title);
		if (book != null)
			System.out.println(book);
		else 
			System.out.println("Book " + title + " not found.");
	}
	public void showMemberBooks(String name) {
		Member member = library.findMemberByName(name);
		if (member != null)
			member.listBorrowedBooks();
		else 
			System.out.println("Member " + name + " not found.");
	}
	
	public void borrowBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); // use library for search
		Book book = library.findBookByTitle(title);  // use library for search
		if (book != null && member != null)
			member.borrowBook(book, this.library); // member borrows a book, not library 
		else 	
			System.out.println("Either book " + title + " or member " + name + " not found.");
	}
	
	public void returnBookByMember(String title, String name) {
		Member member = library.findMemberByName(name); // use library for search
		Book book = library.findBookByTitle(title); // use library for search 
		if (book != null && member != null)
			member.returnBook(book, this.library); // members returns book. 
		else  	
			System.out.println("Either book " + title + " or member " + name + " not found.");
	}
}
