package progetto.mp.social.events;

public interface SocialEventVisitor {
	void visitAddedPost(SocialEvent event);

	void visitAddedComment(SocialEvent event);

	void visitRemovedPost(SocialEvent event);

	void visitRemovedComment(SocialEvent event);
}
