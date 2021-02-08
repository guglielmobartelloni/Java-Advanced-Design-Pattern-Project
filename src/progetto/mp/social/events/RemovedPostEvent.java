package progetto.mp.social.events;

import progetto.mp.social.Component;

public final class RemovedPostEvent extends SocialEvent {

	public RemovedPostEvent(Component component) {
		super(component);
	}

	@Override
	public void accept(SocialEventVisitor visitor) {
		visitor.visitRemovedPost(this);
	}

}
