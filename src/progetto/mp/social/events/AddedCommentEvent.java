package progetto.mp.social.events;

import progetto.mp.social.Component;

public final class AddedCommentEvent extends SocialEvent{

	public AddedCommentEvent(Component component) {
		super(component);
	}

	@Override
	public void accept(SocialEventVisitor visitor) {
		visitor.visitAddedComment(this);
	}

}
