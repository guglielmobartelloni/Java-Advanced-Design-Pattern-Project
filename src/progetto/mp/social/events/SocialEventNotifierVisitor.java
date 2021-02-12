package progetto.mp.social.events;

import progetto.mp.social.PostablePrintVisitor;
import progetto.mp.social.utils.NotificationSender;

public final class SocialEventNotifierVisitor implements SocialEventVisitor {

	private String recipient;
	private NotificationSender senderService;

	public SocialEventNotifierVisitor(NotificationSender senderService, String recipient) {
		this.senderService = senderService;
		this.recipient = recipient;
	}

	@Override
	public void visitAddedPost(AddedPostEvent event) {
		senderService.send("New Post: \n" + event.getComponent().accept(new PostablePrintVisitor()), recipient);
	}

	@Override
	public void visitAddedContent(AddedContentToPostEvent event) {
		senderService.send("New content in a post: \n" + event.getComponent().accept(new PostablePrintVisitor()), recipient);
	}

	@Override
	public void visitRemovedPost(RemovedPostEvent event) {
		senderService.send("A post has been removed: \n" + event.getComponent().accept(new PostablePrintVisitor()), recipient);
	}

	@Override
	public void visitRemovedContent(RemovedContentToPostEvent event) {
		senderService.send("A content in a post has been removed: \n" + event.getComponent().accept(new PostablePrintVisitor()), recipient);

	}

}
