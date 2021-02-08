package progetto.mp.social;

import progetto.mp.social.events.SocialEvent;

public interface SocialObserver {
	void notifyChange(SocialEvent event);
}
