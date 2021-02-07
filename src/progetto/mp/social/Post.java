package progetto.mp.social;

public abstract class Post {
	protected String content;

	public Post(String content) {
		this.content = content;
	}
	
	public abstract String getContent();
	
	

}
