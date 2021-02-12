package progetto.mp.social.events;

import progetto.mp.social.Post;

public final class AddedPostEvent extends SocialEvent {

	public AddedPostEvent(Post component) {
		super(component);
	}

	@Override
	public void accept(SocialEventVisitor visitor) {
		visitor.visitAddedPost(this);
	}

}
