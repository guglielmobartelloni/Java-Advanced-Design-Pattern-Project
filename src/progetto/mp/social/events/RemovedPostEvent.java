package progetto.mp.social.events;

import progetto.mp.social.Postable;

public final class RemovedPostEvent extends SocialEvent {

	public RemovedPostEvent(Postable component) {
		super(component);
	}

	@Override
	public void accept(SocialEventVisitor visitor) {
		visitor.visitRemovedPost(this);
	}

}
