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
		Post post = new Post("aPost", new PostableText("this is a test post"));
		profile.addPost(post);
		assertThat(profile.getPostsCollection()).containsExactly(post);
	}

	@Test
	public void testAddAndRemovePost() {
		Post postOne = new Post("aPost", new PostableText("this is a test post one"));
		Post postTwo = new Post("anotherPost", new PostableText("this is a test two"));
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

		assertThat(profile.getObservers()).containsExactly(aProfile, anotherProfile);

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

		profile.addPost(new Post("aPost", new PostableText("this is a quote post")));
		assertThat(senderService.toString()).isEqualTo(
				"Hello aProfileObserver\n" + " New Post: \n" + "Post: aPost\n" + "this is a quote post\n" + "");
		assertThat(anotherSenderService.toString()).isEqualTo(
				"Hello anotherProfileObserver\n" + " New Post: \n" + "Post: aPost\n" + "this is a quote post\n" + "");

		profile.addPost(new Post("anotherPost", new PostableText("this is another quote post")));
		assertThat(senderService.toString()).isEqualTo("Hello aProfileObserver\n" + " New Post: \n"
				+ "Post: anotherPost\n" + "this is another quote post\n" + "");
		assertThat(anotherSenderService.toString()).isEqualTo("Hello anotherProfileObserver\n" + " New Post: \n"
				+ "Post: anotherPost\n" + "this is another quote post\n" + "");
	}

	@Test
	public void testRemovedPostEvent() {
		MockNotificationSender senderService = new MockNotificationSender();
		MockNotificationSender anotherSenderService = new MockNotificationSender();
		profile.attach(new Profile("anotherProfileObserver", anotherSenderService));
		profile.attach(new Profile("aProfileObserver", senderService));

		Post aPost = new Post("aPost", new PostableText("this is a quote post"));
		Post aSecondPost = new Post("aSecondPost", new PostableText("this is a second quote post"));
		profile.addPost(aPost);
		profile.addPost(aSecondPost);

		profile.removePost(aPost);
		assertThat(senderService.toString()).isEqualTo("Hello aProfileObserver\n" + " A post has been removed: \n"
				+ "Post: aPost\n" + "this is a quote post\n" + "");
		assertThat(anotherSenderService.toString()).isEqualTo("Hello anotherProfileObserver\n"
				+ " A post has been removed: \n" + "Post: aPost\n" + "this is a quote post\n" + "");

		profile.removePost(aSecondPost);
		assertThat(senderService.toString()).isEqualTo("Hello aProfileObserver\n" + " A post has been removed: \n"
				+ "Post: aSecondPost\n" + "this is a second quote post\n" + "");
		assertThat(anotherSenderService.toString()).isEqualTo("Hello anotherProfileObserver\n"
				+ " A post has been removed: \n" + "Post: aSecondPost\n" + "this is a second quote post\n" + "");
	}

	@Test
	public void testGetPosts() {
		Post aPost = new Post("aPost", new PostableText("this is a post"));
		profile.addPost(aPost);
		Post aSecondPost = new Post("anotherPost", new PostableText("this is another post"));
		profile.addPost(aSecondPost);

		assertThat(profile.getPosts()).toIterable().containsExactly(aPost, aSecondPost);
	}
}
