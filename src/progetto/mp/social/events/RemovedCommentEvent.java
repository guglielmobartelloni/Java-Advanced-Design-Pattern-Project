package progetto.mp.social.events;

import progetto.mp.social.Component;

public final class RemovedCommentEvent extends SocialEvent {

	public RemovedCommentEvent(Component component) {
		super(component);
	}

	@Override
	public void accept(SocialEventVisitor visitor) {
		visitor.visitRemovedComment(this);
	}

}
