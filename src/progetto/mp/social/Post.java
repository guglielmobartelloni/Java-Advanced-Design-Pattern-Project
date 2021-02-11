package progetto.mp.social;

import java.util.ArrayList;
import java.util.Collection;

import progetto.mp.social.events.AddedContentToPostEvent;
import progetto.mp.social.events.RemovedContentToPostEvent;

public class Post extends SocialSubject implements Postable {

	private Collection<Postable> contents=new ArrayList<>();

	public Post(Postable... postables) {
		for(Postable postable:postables) {
			contents.add(postable);
		}
	}
	
	public Post(Collection<Postable> postables) {
		postables.forEach(e -> contents.add(e));
	}

	/**
	 * Empty post
	 */
	public Post() {
	}
	
	@Override
	public String getContent() {
		StringBuilder content = new StringBuilder("");
		contents.forEach(e -> {
			content.append(e.getContent());
			content.append("\n");
		});
		return content.toString();
	}

	public void addContent(Postable postable) {
		contents.add(postable);
		notifyObservers(new AddedContentToPostEvent(postable));
	}

	public void removeContent(Postable postable) {
		contents.remove(postable);
		notifyObservers(new RemovedContentToPostEvent(postable));
	}

	protected Collection<Postable> getContents() {
		return contents;
	}
}
