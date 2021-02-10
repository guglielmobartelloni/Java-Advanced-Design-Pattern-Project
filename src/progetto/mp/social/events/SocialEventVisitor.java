package progetto.mp.social.events;

public interface SocialEventVisitor {
	void visitAddedPost(SocialEvent event);

	void visitAddedImage(SocialEvent event);

	void visitRemovedPost(SocialEvent event);

	void visitRemovedImage(SocialEvent event);
}
