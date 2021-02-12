package progetto.mp.social;


import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class PostableTextTest {

	@Test
	public void testGetContent() {
		assertThat(new PostableText("this is a text").getContent()).isEqualTo("this is a text");
	}

}
