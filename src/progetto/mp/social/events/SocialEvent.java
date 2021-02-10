package progetto.mp.social.events;

import progetto.mp.social.Postable;

public abstract class SocialEvent {

	private Postable component;

	public SocialEvent(Postable component) {
		this.component = component;
	}

	public Postable getComponent() {
		return component;
	}

	public abstract void accept(SocialEventVisitor visitor);
}
