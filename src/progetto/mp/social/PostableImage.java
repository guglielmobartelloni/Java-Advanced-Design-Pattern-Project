package progetto.mp.social;

public class PostableImage implements Postable {

	private String imagePath;

	public PostableImage(String imagePath) {
		if(imagePath.isEmpty()) {
			throw new IllegalArgumentException("The image path cannot be empty");
		}
		this.imagePath = imagePath;
	}

	@Override
	public String getContent() {
		return imagePath;
	}

}
