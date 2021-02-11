package progetto.mp.social.events;

import progetto.mp.social.Postable;

public final class RemovedContentToPostEvent extends SocialEvent {

	public RemovedContentToPostEvent(Postable component) {
		super(component);
	}

	@Override
	public void accept(SocialEventVisitor visitor) {
		visitor.visitRemovedContent(this);
	}

}
