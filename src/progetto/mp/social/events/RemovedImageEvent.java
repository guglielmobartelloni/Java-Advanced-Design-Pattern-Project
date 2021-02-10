package progetto.mp.social.events;

import progetto.mp.social.Postable;

public final class RemovedImageEvent extends SocialEvent {

	public RemovedImageEvent(Postable component) {
		super(component);
	}

	@Override
	public void accept(SocialEventVisitor visitor) {
		visitor.visitRemovedImage(this);
	}

}
