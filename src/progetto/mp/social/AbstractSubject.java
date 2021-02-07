package progetto.mp.social;

import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractSubject {
	private Collection<AbstractObserver> observers=new ArrayList<>();
	
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
