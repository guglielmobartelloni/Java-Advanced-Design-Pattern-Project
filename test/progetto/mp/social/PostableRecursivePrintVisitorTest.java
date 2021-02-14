package progetto.mp.social;

import org.junit.Before;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class PostableRecursivePrintVisitorTest {

	private PostableRecursivePrintVisitor visitor;

	@Before
	public void setup() {
		visitor = new PostableRecursivePrintVisitor();
	}

	@Test
	public void testVisitPost() {
		Post post = new Post("aPost", new PostableText("this is a text"), new Post("aNestedPost",
				new PostableText("this is a text inside a post"), new PostableAsciiImage("image")));
		assertThat(post.accept(visitor)).isEqualTo("Post: aPost\n" + "this is a text\n" + "Post: aNestedPost\n"
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
				+ "\n" + "");
	}

	@Test
	public void testVisitPostableImage() {
		PostableAsciiImage image = new PostableAsciiImage("image");
		assertThat(image.accept(visitor)).isEqualTo(
				"Image:             $$$                                                                                     \n"
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
						+ "\n" + "");
	}

	@Test
	public void testVisitPostableText() {
		PostableText text = new PostableText("this is a text");
		assertThat(text.accept(visitor)).isEqualTo("this is a text\n" + "");
	}

}
