package progetto.mp.social.events;

import progetto.mp.social.Component;

public abstract class SocialEvent {

	private Component component;

	public SocialEvent(Component component) {
		this.component = component;
	}

	public Component getComponent() {
		return component;
	}

	abstract void accept(SocialEventVisitor visitor);
}
