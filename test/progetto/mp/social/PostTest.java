package progetto.mp.social;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import progetto.mp.social.utils.MockNotificationSender;

public class PostTest {

	private Post post;

	@Before
	public void setup() {
		post = new Post();
	}

	@Test
	public void testAddContent() {
		PostableText aText = new PostableText("this is a second postable");
		post.addContent(aText);
		PostableText anotherText = new PostableText("this is a postable");
		post.addContent(anotherText);
		Post aPost = new Post(new PostableText("this is a text inside a post"),
				new PostableText("this is another text inside a post"),new PostableImage("c:/path/to/file"));
		post.addContent(aPost);

		assertThat(post.getContents()).containsExactly(aText, anotherText, aPost);
	}

	@Test
	public void testAddAndRemoveContent() {
		PostableText aText = new PostableText("this is a second postable");
		post.addContent(aText);
		PostableText anotherText = new PostableText("this is a postable");
		post.addContent(anotherText);
		Post aPost = new Post(new PostableText("this is a text inside a post"),
				new PostableText("this is another text inside a post"));
		post.addContent(aPost);

		post.removeContent(aPost);

		assertThat(post.getContents()).containsExactly(aText, anotherText);
	}

	@Test
	public void testGetContentNonEmptyPost() {
		PostableText aText = new PostableText("this is a second postable");
		post.addContent(aText);
		PostableText anotherText = new PostableText("this is a postable");
		post.addContent(anotherText);
		Post aPost = new Post(new PostableText("this is a text inside a post"),
				new PostableText("this is another text inside a post"),
				new Post(new PostableText("this is a text inside a post inside another post")));
		post.addContent(aPost);

		assertThat(post.getContent()).isEqualTo("Post: \n" + "this is a second postable\n" + "this is a postable\n"
				+ "Post: \n" + "this is a text inside a post\n" + "this is another text inside a post\n" + "Post: \n"
				+ "this is a text inside a post inside another post\n" + "");
	}

	@Test
	public void testGetContentEmptyPost() {
		assertThat(post.getContent()).isEqualTo("Post: \n"
				+ "");
	}

	@Test
	public void testNotifyObserversWithAddContent() {
		MockNotificationSender senderService = new MockNotificationSender();
		post.attach(new Profile("aProfile", senderService));

		PostableText aText = new PostableText("this is a second postable");
		post.addContent(aText);
		assertThat(senderService.toString())
				.isEqualTo("Hello aProfile\n" + " New content in a post: \n" + "this is a second postable\n" + "");

		PostableText anotherText = new PostableText("this is a postable");
		post.addContent(anotherText);
		assertThat(senderService.toString())
				.isEqualTo("Hello aProfile\n"
						+ " New content in a post: \n"
						+ "this is a postable\n"
						+ "");
		Post aPost = new Post(new PostableText("this is a text inside a post"),
				new PostableText("this is another text inside a post"));
		post.addContent(aPost);
		assertThat(senderService.toString())
				.isEqualTo("Hello aProfile\n"
						+ " New content in a post: \n"
						+ "Post: \n"
						+ "this is a text inside a post\n"
						+ "this is another text inside a post\n"
						+ "");

	}

	@Test
	public void testGetContent() {
		PostableText anotherText = new PostableText("this is a postable");
		post.addContent(anotherText);
		PostableText aText = new PostableText("this is a second postable");
		post.addContent(aText);
		Post aPost = new Post(new PostableText("this is a text inside a post"),
				new PostableText("this is another text inside a post"));
		post.addContent(aPost);

		assertThat(post.getContent()).isEqualTo("Post: \n"
				+ "this is a postable\n"
				+ "this is a second postable\n"
				+ "Post: \n"
				+ "this is a text inside a post\n"
				+ "this is another text inside a post\n"
				+ "");
	}

	@Test
	public void testNotifyObserversWithRemoveContent() {
		MockNotificationSender senderService = new MockNotificationSender();
		post.attach(new Profile("aProfile", senderService));

		PostableText aText = new PostableText("this is a second postable");
		post.addContent(aText);

		PostableText anotherText = new PostableText("this is a postable");
		post.addContent(anotherText);
		Post aPost = new Post(new PostableText("this is a text inside a post"),
				new PostableText("this is another text inside a post"));
		post.addContent(aPost);

		post.removeContent(aPost);

		assertThat(senderService.toString())
				.isEqualTo("Hello aProfile\n"
						+ " A content in a post has been removed: \n"
						+ "Post: \n"
						+ "this is a text inside a post\n"
						+ "this is another text inside a post\n"
						+ "");

		post.removeContent(anotherText);

		assertThat(senderService.toString())
				.isEqualTo("Hello aProfile\n"
						+ " A content in a post has been removed: \n"
						+ "this is a postable\n"
						+ "");
	}
}
