package progetto.mp.social;

import progetto.mp.social.utils.Media;

public abstract class PostWithMediaDecorator extends Post {

	private Media media;

	public PostWithMediaDecorator(Post ,Media media) {
		super(content);
		this.media = media;
	}
	
	@Override
	public String getContent() {
		return super.getContent()+ "\n " + media.getSource();
	}

}
