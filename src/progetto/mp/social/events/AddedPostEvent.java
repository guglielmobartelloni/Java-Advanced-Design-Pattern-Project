package progetto.mp.social.events;

import progetto.mp.social.Postable;

public final class AddedPostEvent extends SocialEvent {

	public AddedPostEvent(Postable component) {
		super(component);
	}

	@Override
	public void accept(SocialEventVisitor visitor) {
		visitor.visitAddedPost(this);
	}

}
