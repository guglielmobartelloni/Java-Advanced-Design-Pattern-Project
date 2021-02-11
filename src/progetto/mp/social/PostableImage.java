package progetto.mp.social;

public class PostableImage implements Postable {

	private String imagePath;

	public PostableImage(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String getContent() {
		return imagePath;
	}

}
