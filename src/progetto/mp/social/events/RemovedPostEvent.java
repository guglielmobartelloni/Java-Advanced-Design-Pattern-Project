package progetto.mp.social.events;

import progetto.mp.social.Post;

public final class RemovedPostEvent extends SocialEvent {

	public RemovedPostEvent(Post component) {
		super(component);
	}

	@Override
	public void accept(SocialEventVisitor visitor) {
		visitor.visitRemovedPost(this);
	}

}
