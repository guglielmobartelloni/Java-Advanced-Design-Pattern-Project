package progetto.mp.social.events;


import org.junit.Before;
import org.junit.Test;

import progetto.mp.social.Post;
import progetto.mp.social.PostableImage;
import progetto.mp.social.PostableText;
import progetto.mp.social.utils.MockNotificationSender;

import static org.assertj.core.api.Assertions.*;
public class SocialEventNotifierVisitorTest {

	private MockNotificationSender senderService;
	private SocialEventNotifierVisitor visitor;
	
	@Before
	public void setup() {
		senderService=new MockNotificationSender();
		visitor=new SocialEventNotifierVisitor(senderService,"aRecipient");
	}
	
	@Test
	public void testAddedPostEvent() {
		SocialEvent event=new AddedPostEvent(new Post(new PostableText("this is a postable text"), new PostableImage("c://path/to/file")));
		event.accept(visitor);
		assertThat(senderService.toString()).isEqualTo("Hello aRecipient\n"
				+ " New Post: \n"
				+ "Post: \n"
				+ "this is a postable text\n"
				+ "Image: c://path/to/file\n"
				+ "");
	}

	@Test
	public void testRemovedPostEvent() {
		SocialEvent event=new RemovedPostEvent(new Post(new PostableText("this is a postable text"), new PostableImage("c://path/to/file")));
		event.accept(visitor);
		assertThat(senderService.toString()).isEqualTo("Hello aRecipient\n"
				+ " A post has been removed: \n"
				+ "Post: \n"
				+ "this is a postable text\n"
				+ "Image: c://path/to/file\n"
				+ "");
	}

	@Test
	public void testAddedContentToPostEvent() {
		SocialEvent event=new AddedContentToPostEvent(new PostableText("this is a postable text"));
		event.accept(visitor);
		assertThat(senderService.toString()).isEqualTo("Hello aRecipient\n"
				+ " New content in a post: \n"
				+ "this is a postable text\n"
				+ "");
	}

	@Test
	public void testRemovedContentToPostEvent() {
		SocialEvent event=new RemovedContentToPostEvent(new PostableText("this is a postable text"));
		event.accept(visitor);
		assertThat(senderService.toString()).isEqualTo("Hello aRecipient\n"
				+ " A content in a post has been removed: \n"
				+ "this is a postable text\n"
				+ "");
	}
}
