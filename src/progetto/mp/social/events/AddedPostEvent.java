package progetto.mp.social.events;

import progetto.mp.social.Component;

public final class AddedPostEvent extends SocialEvent {

	public AddedPostEvent(Component component) {
		super(component);
	}

	@Override
	public void accept(SocialEventVisitor visitor) {
		visitor.visitAddedPost(this);
	}

}
