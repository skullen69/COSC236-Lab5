package lab5;
public class AudioBook implements Book{
	private boolean isAvailable;
	private String title;
	
	public AudioBook(String title) {
		this.title = title;
		this.isAvailable = true;
	}
	@Override
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
		
	}

	@Override
	public boolean getIsAvailable() {
		return this.isAvailable;
	}

	@Override
	public String getTitle() {
		return title;
	}

	public String toString() {
		return "Book: " + title;
	}
}
