package progetto.mp.social;

import java.util.ArrayList;
import java.util.Collection;

import progetto.mp.social.events.SocialEvent;

public abstract class SocialSubject {
	private Collection<SocialObserver> observers=new ArrayList<>();

	public void attach(SocialObserver observer) {
		observers.add(observer);
	}

	/**
	 * Only for testing
	 */
	Collection<SocialObserver> getObservers(){
		return observers;
	}
	
	public void detach(SocialObserver observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers(SocialEvent event) {
		observers.forEach(e -> e.notifyChange(event));
	}
}
