package progetto.mp.social.utils;


/**
 * This class is for testing only
 *
 */
public class MockNotificationSender extends NotificationSender {

	/**
	 * The message that is going to be sent
	 */
	private String message;

	public MockNotificationSender() {
		this.message = new String();
	}

	/**
	 * Method for testing
	 * 
	 */
	String getMessage() {
		return this.message;
	}

	/**
	 * Method that adds to the message the name of the recipient
	 */
	@Override
	public void send(String message, String recipient) {
		this.message += recipient + " " + message;
	}
	
	
	@Override
	public String toString() {
		return message;
	}

}
