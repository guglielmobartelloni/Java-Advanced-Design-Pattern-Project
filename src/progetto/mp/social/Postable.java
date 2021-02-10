package progetto.mp.social;

import java.util.ArrayList;
import java.util.Collection;

import progetto.mp.social.events.SocialEvent;

public abstract class Postable implements SocialSubject{
	private Content content;
	
	private Collection<SocialObserver> observers = new ArrayList<>();

	public Postable(Content content) {
		this.content=content;
	}

	public Content getContent() {
		return content;
	}
	
	public void attach(SocialObserver observer) {
		observers.add(observer);
	}

	public void detach(SocialObserver observer) {
		observers.remove(observer);
	}

	public void notifyObservers(SocialEvent event) {
		observers.forEach(e -> e.notifyChange(event));
	}

}
