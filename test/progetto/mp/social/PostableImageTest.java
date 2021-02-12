package progetto.mp.social;


import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
public class PostableImageTest {

	@Test
	public void testGetContent() {
		assertThat(new PostableImage("C:/path/to/image").getContent()).isEqualTo("C:/path/to/image");
	}
	
	
	@Test
	public void testGetContentWithEmptyPath() {
		assertThatIllegalArgumentException().isThrownBy(() -> new PostableImage("").getContent()).withMessage("The image path cannot be empty");
	}

}
