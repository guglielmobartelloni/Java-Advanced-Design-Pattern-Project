package progetto.mp.social;


import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
public class PostableStringVisitorTest {
	
	private PostablePrintVisitor visitor;
	
	@Before
	public void setup() {
		visitor=new PostablePrintVisitor();
	}
	

	@Test
	public void testVisitPost() {
		Post post = new Post(new PostableText("this is a text"),new Post(new PostableText("this is a text inside a post"),new PostableImage("c://path/to/image")));
		assertThat(post.accept(visitor)).isEqualTo("Post: \n"
				+ "this is a text\n"
				+ "Post: \n"
				+ "this is a text inside a post\n"
				+ "Image: c://path/to/image\n"
				+ "");
	}

	@Test
	public void testVisitPostableImage() {
		PostableImage image = new PostableImage("c://path/to/image");
		assertThat(image.accept(visitor)).isEqualTo("Image: c://path/to/image\n"
				+ "");
	}

@Test
	public void testVisitPostableText() {
		PostableText text = new PostableText("this is a text");
		assertThat(text.accept(visitor)).isEqualTo("this is a text\n" + "");
	}
}
