package lab5;


// Part 8 Task 2
public class PaperBookFactory extends BookFactory {
	public Book createBook(String name) {
		return new PaperBook(name);
	}
}
