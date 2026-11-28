package lab5;

// Part 8 Task 2
public class EBookFactory extends BookFactory {
	public Book createBook(String name) {
		return new EBook(name);
	}
}
