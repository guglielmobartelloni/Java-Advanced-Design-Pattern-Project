package progetto.mp.social.events;

import progetto.mp.social.utils.NotificationSender;

public final class SocialEventNotifierVisitor implements SocialEventVisitor {

	private String recipient;
	private NotificationSender senderService;

	public SocialEventNotifierVisitor(NotificationSender senderService, String recipient) {
		this.senderService = senderService;
		this.recipient = recipient;
	}

	@Override
	public void visitAddedPost(SocialEvent event) {
		senderService.send("New Post: " + event.getComponent().getContent(), recipient);
	}

	@Override
	public void visitAddedContent(SocialEvent event) {
		senderService.send("New content in a post: " + event.getComponent().getContent(), recipient);
	}

	@Override
	public void visitRemovedPost(SocialEvent event) {
		senderService.send("A post has been removed: " + event.getComponent().getContent(), recipient);
	}

	@Override
	public void visitRemovedContent(SocialEvent event) {
		senderService.send("A content in a post has been removed: " + event.getComponent().getContent(), recipient);

	}

}
