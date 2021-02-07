package progetto.mp.social;

import java.util.Collection;

public abstract class AbstractSubject {
	private Collection<AbstractObserver> observers;
	
	public void attach(AbstractObserver observer) {
		observers.add(observer);
	}
	
	public void detach(AbstractObserver observer) {
		observers.remove(observer);
	}
	
	public void notifyObservers() {
		observers.forEach(o -> o.notifyChange());
	}
}
