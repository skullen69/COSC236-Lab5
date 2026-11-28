package lab5;
public class EBook implements Book{
	private boolean isAvailable;
	private String title;
	public EBook(String title) {
		this.title = title;
		this.isAvailable = true;
	}
	@Override
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public boolean getIsAvailable() {
		return isAvailable;
	}

	@Override
	public String getTitle() {
		return title;
	}
	
	public String toString() {
		return "Book: " + title;
	}

}
