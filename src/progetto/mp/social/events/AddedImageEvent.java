package progetto.mp.social.events;

import progetto.mp.social.Postable;

public final class AddedImageEvent extends SocialEvent{

	public AddedImageEvent(Postable component) {
		super(component);
	}

	@Override
	public void accept(SocialEventVisitor visitor) {
		visitor.visitAddedImage(this);
	}

}
