package progetto.mp.social;


public class PostableText implements Postable {

	private String content;

	public PostableText(String content) {
		this.content = content;
	}

	@Override
	public String getContent() {
		return content;
	}


}
