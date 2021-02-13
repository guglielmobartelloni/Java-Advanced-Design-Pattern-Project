package progetto.mp.social;


import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
public class PostablePrintVisitorTest {
	
	private PostablePrintVisitor visitor;
	
	@Before
	public void setup() {
		visitor=new PostablePrintVisitor();
	}
	

	@Test
	public void testVisitPost() {
		Post post = new Post(new PostableText("this is a text"),new Post(new PostableText("this is a text inside a post"),new PostableAsciiImage("image")));
		assertThat(post.accept(visitor)).isEqualTo("Post: \n"
				+ "this is a text\n"
				+ "Post: \n"
				+ "this is a text inside a post\n"
				+ "Image:             $$$                                                                                     \n"
				+ "            $$$                                                                                     \n"
				+ "            $$$                                                                                     \n"
				+ "            $$$    $$$$$$$$$ $$$$$$     $$$$$$$$$     $$$$$$$$$$     $$$$$$$                        \n"
				+ "            $$$    $$$$$$$$$$$$$$$$$   $$$$$$$$$$$   $$$$$$$$$$$    $$$$$$$$$                       \n"
				+ "            $$$    $$$$$$$$$$$$$$$$$   $$$$$$$$$$$  $$$$$$$$$$$$   $$$$$$$$$$$                      \n"
				+ "            $$$    $$$$$$$$$$$$$$$$$   $$$$   $$$$  $$$$$$$$$$$$   $$$$$$$$$$$                      \n"
				+ "            $$$    $$$$  $$$$$  $$$$          $$$$  $$$$    $$$$   $$$$   $$$$                      \n"
				+ "            $$$    $$$$  $$$$$  $$$$     $$$$$$$$$  $$$$    $$$$   $$$$$$$$$$$                      \n"
				+ "            $$$    $$$$   $$$$   $$$    $$$$$$$$$$  $$$$    $$$$   $$$$$$$$$$$                      \n"
				+ "            $$$    $$$    $$$    $$$   $$$$$$$$$$$  $$$$    $$$$   $$$$                             \n"
				+ "            $$$    $$$    $$$    $$$   $$$$$  $$$$  $$$$    $$$$   $$$$                             \n"
				+ "            $$$    $$$    $$$    $$$   $$$$   $$$$$ $$$$$$$$$$$$   $$$$$$$$$$$                      \n"
				+ "            $$$    $$$    $$$    $$$   $$$$$$$$$$$$ $$$$$$$$$$$$   $$$$$$$$$$$                      \n"
				+ "            $$$    $$$    $$$    $$$   $$$$$$$$$$$$  $$$$$$$$$$$    $$$$$$$$$                       \n"
				+ "            $$$    $$$    $$$    $$$    $$$$$$$$$$$   $$$$$$$$$$     $$$$$$$                        \n"
				+ "                                                            $$$$                                    \n"
				+ "                                                   $$$$$$$$$$$$$                                    \n"
				+ "                                                    $$$$$$$$$$$$                                    \n"
				+ "                                                    $$$$$$$$$$$$                                    \n"
				+ "                                                     $$$$$$$$$                                      \n"
				+ "\n"
				+ "");
	}

	@Test
	public void testVisitPostableImage() {
		PostableAsciiImage image = new PostableAsciiImage("image");
		assertThat(image.accept(visitor)).isEqualTo("Image:             $$$                                                                                     \n"
				+ "            $$$                                                                                     \n"
				+ "            $$$                                                                                     \n"
				+ "            $$$    $$$$$$$$$ $$$$$$     $$$$$$$$$     $$$$$$$$$$     $$$$$$$                        \n"
				+ "            $$$    $$$$$$$$$$$$$$$$$   $$$$$$$$$$$   $$$$$$$$$$$    $$$$$$$$$                       \n"
				+ "            $$$    $$$$$$$$$$$$$$$$$   $$$$$$$$$$$  $$$$$$$$$$$$   $$$$$$$$$$$                      \n"
				+ "            $$$    $$$$$$$$$$$$$$$$$   $$$$   $$$$  $$$$$$$$$$$$   $$$$$$$$$$$                      \n"
				+ "            $$$    $$$$  $$$$$  $$$$          $$$$  $$$$    $$$$   $$$$   $$$$                      \n"
				+ "            $$$    $$$$  $$$$$  $$$$     $$$$$$$$$  $$$$    $$$$   $$$$$$$$$$$                      \n"
				+ "            $$$    $$$$   $$$$   $$$    $$$$$$$$$$  $$$$    $$$$   $$$$$$$$$$$                      \n"
				+ "            $$$    $$$    $$$    $$$   $$$$$$$$$$$  $$$$    $$$$   $$$$                             \n"
				+ "            $$$    $$$    $$$    $$$   $$$$$  $$$$  $$$$    $$$$   $$$$                             \n"
				+ "            $$$    $$$    $$$    $$$   $$$$   $$$$$ $$$$$$$$$$$$   $$$$$$$$$$$                      \n"
				+ "            $$$    $$$    $$$    $$$   $$$$$$$$$$$$ $$$$$$$$$$$$   $$$$$$$$$$$                      \n"
				+ "            $$$    $$$    $$$    $$$   $$$$$$$$$$$$  $$$$$$$$$$$    $$$$$$$$$                       \n"
				+ "            $$$    $$$    $$$    $$$    $$$$$$$$$$$   $$$$$$$$$$     $$$$$$$                        \n"
				+ "                                                            $$$$                                    \n"
				+ "                                                   $$$$$$$$$$$$$                                    \n"
				+ "                                                    $$$$$$$$$$$$                                    \n"
				+ "                                                    $$$$$$$$$$$$                                    \n"
				+ "                                                     $$$$$$$$$                                      \n"
				+ "\n"
				+ "");
	}

@Test
	public void testVisitPostableText() {
		PostableText text = new PostableText("this is a text");
		assertThat(text.accept(visitor)).isEqualTo("this is a text\n" + "");
	}
}
