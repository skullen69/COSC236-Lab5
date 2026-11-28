package lab5;

public class BorrowingBookResult {
	private boolean isSuccess;
	private String borrowingMessage;
	
	public BorrowingBookResult(boolean isSuccess, String borrowingMessage) {
		this.isSuccess = isSuccess;
		this.borrowingMessage = borrowingMessage;
	}
	
	/**
	 * @return the isSuccess
	 */
	public boolean isSuccess() {
		return isSuccess;
	}
	/**
	 * @param isSuccess the isSuccess to set
	 */
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	/**
	 * @return the borrowingMessage
	 */
	public String getBorrowingMessage() {
		return borrowingMessage;
	}
	/**
	 * @param borrowingMessage the borrowingMessage to set
	 */
	public void setBorrowingMessage(String borrowingMessage) {
		this.borrowingMessage = borrowingMessage;
	}
	
	
}
