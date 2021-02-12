package progetto.mp.social.events;

public interface SocialEventVisitor {
	void visitAddedPost(AddedPostEvent event);

	void visitAddedContent(AddedContentToPostEvent event);

	void visitRemovedPost(RemovedPostEvent event);

	void visitRemovedContent(RemovedContentToPostEvent event);
}
