package progetto.mp.social;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import progetto.mp.social.events.AddedContentToPostEvent;
import progetto.mp.social.events.RemovedContentToPostEvent;

public class Post extends SocialSubject implements Postable {

	private Collection<Postable> contents = new ArrayList<>();

	public Post(Postable... postables) {
		for (Postable postable : postables) {
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
		return this.accept(new PostablePrintVisitor());
	}

	public void addContent(Postable postable) {
		contents.add(postable);
		notifyObservers(new AddedContentToPostEvent(postable));
	}

	public void removeContent(Postable postable) {
		contents.remove(postable);
		notifyObservers(new RemovedContentToPostEvent(postable));
	}

	public Iterator<Postable> iterator() {
		return contents.iterator();
	}

	/**
	 * Only for testing
	 */
	Collection<Postable> getContents() {
		return contents;
	}

	@Override
	public <T> T accept(PostableVisitor<T> visitor) {
		return visitor.visitPost(this);
	}
}
