package progetto.mp.social.utils;

public abstract class NotificationSender {
	
	
	protected String recipient;
	public NotificationSender(String recipient) {
		this.recipient = recipient;
	}
	
	 public abstract void send(String message);
}
