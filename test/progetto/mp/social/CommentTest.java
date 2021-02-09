package progetto.mp.social;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class CommentTest {

	@Test
	public void testGetContent() {
		assertThat(new Comment("this is a comment").getContent()).isEqualTo("this is a comment");
	}

}
