package progetto.mp.social;

public abstract class Component {
	private String content;
	
	public Component(String content) {
		this.content=content;
	}
	
	public String getContent() {
		return content;
	}

}
