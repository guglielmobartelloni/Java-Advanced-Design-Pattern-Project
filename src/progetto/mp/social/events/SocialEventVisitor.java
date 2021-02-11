package progetto.mp.social.events;

public interface SocialEventVisitor {
	void visitAddedPost(SocialEvent event);

	void visitAddedContent(SocialEvent event);

	void visitRemovedPost(SocialEvent event);

	void visitRemovedContent(SocialEvent event);
}
