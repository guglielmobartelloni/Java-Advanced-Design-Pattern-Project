package progetto.mp.social;

import org.junit.Before;

import org.junit.Test;

import progetto.mp.social.utils.MockNotificationSender;

import static org.assertj.core.api.Assertions.*;

public class ProfileTest {

	private Profile profile;

	@Before
	public void setup() {
		MockNotificationSender senderService = new MockNotificationSender();
		this.profile = new Profile("testProfile", senderService);
	}

	@Test
	public void testAddPost() {
		Post post = new QuotePost("this is a test post");
		profile.addPost(post);
		assertThat(profile.getPostsCollection()).containsExactly(post);
	}

	@Test
	public void testRemovePost() {
		Post postOne = new QuotePost("this is a test post one");
		Post postTwo = new QuotePost("this is a test two");
		profile.addPost(postTwo);
		profile.addPost(postOne);
		profile.removePost(postOne);
		assertThat(profile.getPostsCollection()).containsExactly(postTwo);
	}
	
	@Test
	public void testAttachProfile() {
		Profile aProfile = new Profile("aProfile", new MockNotificationSender());
		profile.attach(aProfile);
		Profile anotherProfile = new Profile("anotherProfile", new MockNotificationSender());
		profile.attach(anotherProfile);
		
		assertThat(profile.getObservers()).containsExactly(aProfile,anotherProfile);
		
	}

	@Test
	public void testDetachProfile() {
		Profile aProfile = new Profile("aProfile", new MockNotificationSender());
		profile.attach(aProfile);
		Profile anotherProfile = new Profile("anotherProfile", new MockNotificationSender());
		profile.attach(anotherProfile);
		
		profile.detach(anotherProfile);
		assertThat(profile.getObservers()).containsExactly(aProfile);
		profile.detach(aProfile);
		assertThat(profile.getObservers()).isEmpty();
		
	}

	@Test
	public void testAddedPostEvent() {
		MockNotificationSender senderService = new MockNotificationSender();
		MockNotificationSender anotherSenderService = new MockNotificationSender();

		profile.attach(new Profile("aProfileObserver", senderService));
		profile.attach(new Profile("anotherProfileObserver", anotherSenderService));

		profile.addPost(new QuotePost("this is a quote post"));
		assertThat(senderService.toString()).isEqualTo("Hello aProfileObserver\n" + " New Post: this is a quote post");
		assertThat(anotherSenderService.toString()).isEqualTo("Hello anotherProfileObserver\n" + " New Post: this is a quote post");

		profile.addPost(new QuotePost("this is another quote post"));
		assertThat(senderService.toString()).isEqualTo("Hello aProfileObserver\n" + " New Post: this is another quote post");
		assertThat(anotherSenderService.toString())
				.isEqualTo("Hello anotherProfileObserver\n" + " New Post: this is another quote post");
	}

	@Test
	public void testRemovedPostEvent() {
		MockNotificationSender senderService = new MockNotificationSender();
		MockNotificationSender anotherSenderService = new MockNotificationSender();
		profile.attach(new Profile("anotherProfileObserver", anotherSenderService));
		profile.attach(new Profile("aProfileObserver", senderService));

		QuotePost aPost = new QuotePost("this is a quote post");
		QuotePost aSecondPost = new QuotePost("this is a second quote post");
		profile.addPost(aPost);
		profile.addPost(aSecondPost);

		profile.removePost(aPost);
		assertThat(senderService.toString())
				.isEqualTo("Hello aProfileObserver\n" + " A post has been removed: this is a quote post");
		assertThat(anotherSenderService.toString())
				.isEqualTo("Hello anotherProfileObserver\n" + " A post has been removed: this is a quote post");

		profile.removePost(aSecondPost);
		assertThat(senderService.toString())
				.isEqualTo("Hello aProfileObserver\n" + " A post has been removed: this is a second quote post");
		assertThat(anotherSenderService.toString())
				.isEqualTo("Hello anotherProfileObserver\n" + " A post has been removed: this is a second quote post");
	}
	
	
	@Test
	public void testGetPosts() {
		QuotePost aPost = new QuotePost("this is a post");
		profile.addPost(aPost);
		QuotePost aSecondPost = new QuotePost("this is another post");
		profile.addPost(aSecondPost);
		
		assertThat(profile.getPosts()).toIterable().containsExactly(aPost,aSecondPost);
	}
}
