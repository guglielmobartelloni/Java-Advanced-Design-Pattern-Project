package progetto.mp.social;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class PostableTextTest {

	@Test
	public void testGetContent() {
		assertThat(new PostableText("this is a text").getContent()).isEqualTo("this is a text");
	}

	@Test
	public void testGetEmptyContent() {
		assertThatIllegalArgumentException().isThrownBy(() -> new PostableText("").getContent()).withMessage("The text to convert cannot be empty");
	}


}
