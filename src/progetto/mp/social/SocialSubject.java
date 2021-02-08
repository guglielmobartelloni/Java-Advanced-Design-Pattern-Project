package progetto.mp.social;

import progetto.mp.social.events.SocialEvent;

public interface SocialSubject {
	
	public void attach(SocialObserver observer);
	
	public void detach(SocialObserver observer);
	
	public void notifyObservers(SocialEvent event);
}
