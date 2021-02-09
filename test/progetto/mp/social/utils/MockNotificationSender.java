package progetto.mp.social.utils;

/**
 * This class is for testing only
 *
 */
public class MockNotificationSender extends NotificationSender {

	/**
	 * The message that is going to be sent
	 */
	private String sendingMessage;

	public MockNotificationSender() {
		this.sendingMessage = new String();
	}

	/**
	 * Method that adds to the message the name of the recipient
	 */
	@Override
	public void send(String message, String recipient) {
		this.sendingMessage ="Hello "+recipient+  "\n " + message ;
	}

	@Override
	public String toString() {
		return sendingMessage;
	}

}
