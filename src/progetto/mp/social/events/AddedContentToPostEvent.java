package progetto.mp.social.events;

import progetto.mp.social.Postable;

public final class AddedContentToPostEvent extends SocialEvent{

	public AddedContentToPostEvent(Postable component) {
		super(component);
	}

	@Override
	public void accept(SocialEventVisitor visitor) {
		visitor.visitAddedContent(this);
	}

}
