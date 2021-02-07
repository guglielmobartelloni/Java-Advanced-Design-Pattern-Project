package progetto.mp.social;

import java.util.Collection;

import progetto.mp.social.utils.NotificationSender;

public class Profile extends AbstractSubject implements AbstractObserver {

	private String surname;
	private Collection<Post> posts;
	private NotificationSender senderService;
	
	public Profile(String surname,NotificationSender senderService) {
		this.surname = surname;
		this.senderService = senderService;
	}
	
	//For testing
	String getSurname(){
		return surname; 
	}
	
	
	public void addPost(Post post) {
		posts.add(post);
		notifyObservers();
	}

	@Override
	public void notifyChange() {
		senderService.send("Nuovo post");
	}

}
