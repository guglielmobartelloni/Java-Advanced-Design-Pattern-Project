package progetto.mp.social;

import java.util.Iterator;

public class PostableRecursivePrintVisitor implements PostableVisitor<String> {

	@Override
	public String visitPostableImage(PostableAsciiImage image) {
		return "Image: " + image.getContent() + "\n";
	}

	@Override
	public String visitPostableText(PostableText text) {
		return text.getContent() + "\n";
	}

	@Override
	public String visitPost(Post post) {
		String stringToReturn = "Post: " + post.getTitle() + "\n";
		Iterator<Postable> iterator = post.iterator();
		while (iterator.hasNext()) {
			stringToReturn += iterator.next().accept(this);
		}
		return stringToReturn;
	}

}
