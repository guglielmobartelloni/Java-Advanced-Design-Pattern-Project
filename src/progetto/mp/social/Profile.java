package progetto.mp.social;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Iterator;

import progetto.mp.social.events.AddedPostEvent;
import progetto.mp.social.events.RemovedPostEvent;
import progetto.mp.social.events.SocialEvent;
import progetto.mp.social.events.SocialEventNotifierVisitor;
import progetto.mp.social.utils.NotificationSender;

public class Profile implements SocialObserver, SocialSubject {

	private String surname;
	private Collection<Post> posts = new ArrayList<>();
	private Collection<SocialObserver> observers = new ArrayList<>();
	private NotificationSender senderService;

	public Profile(String surname, NotificationSender senderService) {
		this.surname = surname;
		this.senderService = senderService;
	}

	/**
	 * Only for testing
	 */
	Collection<SocialObserver> getObservers(){
		return observers;
	}
	
	public void addPost(Post post) {
		posts.add(post);
		notifyObservers(new AddedPostEvent(post));
	}

	public void removePost(Post post) {
		posts.remove(post);
		notifyObservers(new RemovedPostEvent(post));
	}

	/**
	 * Only for testing
	 */
	Collection<Post> getPostsCollection() {
		return posts;
	}

	public Iterator<Post> getPosts() {
		return posts.iterator();
	}

	@Override
	public void notifyChange(SocialEvent event) {
		event.accept(new SocialEventNotifierVisitor(senderService, surname));
	}

	@Override
	public void attach(SocialObserver observer) {
		observers.add(observer);
	}

	@Override
	public void detach(SocialObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(SocialEvent event) {
		observers.forEach(o -> o.notifyChange(event));
	}

}
