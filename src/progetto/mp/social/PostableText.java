package progetto.mp.social;

public class PostableText implements Postable {

	private String content;

	public PostableText(String content) {
		if (content.isEmpty()) {
			throw new IllegalArgumentException("The text to convert cannot be empty");
		}
		this.content = content;
	}

	@Override
	public String getContent() {
		return content;
	}

	@Override
	public <T> T accept(PostableVisitor<T> visitor) {
		return visitor.visitPostableText(this);
	}

}
