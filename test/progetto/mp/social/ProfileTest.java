package progetto.mp.social;


import org.junit.Before;
import org.junit.Test;

import progetto.mp.social.utils.MockNotificationSender;

import static org.assertj.core.api.Assertions.*;


public class ProfileTest {
	
	private Profile profile;

	@Before
	public void setup() {
		this.profile=new Profile("testProfile",new MockNotificationSender());
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
	

	
}
