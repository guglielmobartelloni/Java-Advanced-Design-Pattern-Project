package progetto.mp.social;

import java.util.ArrayList;
import java.util.Collection;

import progetto.mp.social.events.SocialEvent;

public abstract class Post extends Component implements SocialSubject {

	private Collection<SocialObserver> observers = new ArrayList<>();
	private Collection<Comment> comments = new ArrayList<>();

	public void addComment(Comment comment) {
		comments.add(comment);
	}

	public void removeComment(Comment comment) {
		comments.remove(comment);
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

	public Post(String content) {
		super(content);
	}

}
