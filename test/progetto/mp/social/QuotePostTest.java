package progetto.mp.social;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class QuotePostTest {

	@Test
	public void testGetContent() {
		assertThat(new QuotePost("this is a test").getContent()).isEqualTo("this is a test");
	}

}
