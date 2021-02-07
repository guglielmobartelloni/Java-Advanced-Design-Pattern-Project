package progetto.mp.social;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import progetto.mp.social.utils.NotificationSender;

public class Profile extends AbstractSubject implements AbstractObserver {

	private String surname;
	private Collection<Post> posts=new ArrayList<>();
	private NotificationSender senderService;
	
	public Profile(String surname,NotificationSender senderService) {
		this.surname = surname;
		this.senderService = senderService;
	}
	
	/**
	 * Only for testing
	 */
	String getSurname(){
		return surname; 
	}
	
	
	public void addPost(Post post) {
		posts.add(post);
		notifyObservers();
	}
	public void removePost(Post post) {
		posts.remove(post);
		notifyObservers();
	}

	/**
	 * Only for testing
	 */
	Collection<Post> getPostsCollection(){
		return posts;
	}
	
	public Iterator<Post> getPosts(){
		return posts.iterator();
	}
	@Override
	public void notifyChange() {
		senderService.send("Nuovo post",surname);
	}

}
