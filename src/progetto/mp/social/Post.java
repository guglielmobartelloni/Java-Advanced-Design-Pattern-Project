package progetto.mp.social;

import java.util.Collection;

public class Post extends SocialSubject implements Postable {

	private Collection<Postable> contents;

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
	}

	public void removeContent(Postable postable) {
		contents.remove(postable);
	}

	public Collection<Postable> getContents() {
		return contents;
	}
}
