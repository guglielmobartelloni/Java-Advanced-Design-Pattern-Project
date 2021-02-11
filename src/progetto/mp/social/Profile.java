package progetto.mp.social;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Iterator;

import progetto.mp.social.events.AddedPostEvent;
import progetto.mp.social.events.RemovedPostEvent;
import progetto.mp.social.events.SocialEvent;
import progetto.mp.social.events.SocialEventNotifierVisitor;
import progetto.mp.social.utils.NotificationSender;

public class Profile extends SocialSubject implements SocialObserver {

	private String surname;
	private Collection<Postable> posts = new ArrayList<>();
	private NotificationSender senderService;

	public Profile(String surname, NotificationSender senderService) {
		this.surname = surname;
		this.senderService = senderService;
	}

	
	public void addPost(Postable post) {
		posts.add(post);
		notifyObservers(new AddedPostEvent(post));
	}

	public void removePost(Postable post) {
		posts.remove(post);
		notifyObservers(new RemovedPostEvent(post));
	}

	/**
	 * Only for testing
	 */
	Collection<Postable> getPostsCollection() {
		return posts;
	}

	public Iterator<Postable> getPosts() {
		return posts.iterator();
	}

	@Override
	public void notifyChange(SocialEvent event) {
		event.accept(new SocialEventNotifierVisitor(senderService, surname));
	}


}
