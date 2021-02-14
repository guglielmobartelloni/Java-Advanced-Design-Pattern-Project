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
	private Collection<Post> posts = new ArrayList<>();
	private NotificationSender senderService;

	public Profile(String surname, NotificationSender senderService) {
		this.surname = surname;
		this.senderService = senderService;
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

}
