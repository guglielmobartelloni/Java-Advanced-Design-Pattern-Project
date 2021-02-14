package progetto.mp.social;

import org.junit.Before;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class PostableNonRecursivePrintVisitorTest {

	private PostableNonRecursivePrintVisitor visitor;

	@Before
	public void setup() {
		visitor = new PostableNonRecursivePrintVisitor();
	}

	@Test
	public void testVisitPost() {
		Post post = new Post("aPost", new PostableText("this is a text"), new Post("aNestedPost",
				new PostableText("this is a text inside a post"), new PostableAsciiImage("image")));
		assertThat(post.accept(visitor)).isEqualTo("Post: aPost\n" + "this is a text\n" + "Post: aNestedPost");
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
