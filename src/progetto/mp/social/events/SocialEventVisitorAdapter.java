package progetto.mp.social.events;

public abstract class SocialEventVisitorAdapter implements SocialEventVisitor {

	/**
	 * Default implementation does nothing.
	 */
	@Override
	public void visitAddedPost(SocialEvent event) {

	}

	/**
	 * Default implementation does nothing.
	 */
	@Override
	public void visitAddedComment(SocialEvent event) {

	}

	/**
	 * Default implementation does nothing.
	 */
	@Override
	public void visitRemovedPost(SocialEvent event) {
	}

	/**
	 * Default implementation does nothing.
	 */
	@Override
	public void visitRemovedComment(SocialEvent event) {
	}

}
