package progetto.mp.social;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class PostableAsciiImageTest {

	@Test
	public void testGetContent() {
		assertThat(new PostableAsciiImage("test").getContent()).isEqualTo(
				"             $$                                $$                                                   \n"
						+ "            $$$                               $$$                                                   \n"
						+ "            $$$                               $$$                                                   \n"
						+ "            $$$                               $$$                                                   \n"
						+ "          $$$$$$$    $$$$$$$     $$$$$$$$$  $$$$$$$                                                 \n"
						+ "          $$$$$$$   $$$$$$$$$   $$$$$$$$$$$ $$$$$$$                                                 \n"
						+ "          $$$$$$$  $$$$$$$$$$$  $$$$$$$$$$$ $$$$$$$                                                 \n"
						+ "            $$$    $$$$$$$$$$$  $$$$   $$$$   $$$                                                   \n"
						+ "            $$$    $$$$   $$$$  $$$$$$$       $$$                                                   \n"
						+ "            $$$    $$$$$$$$$$$  $$$$$$$$$$    $$$                                                   \n"
						+ "            $$$    $$$$$$$$$$$  $$$$$$$$$$$   $$$                                                   \n"
						+ "            $$$    $$$$           $$$$$$$$$   $$$                                                   \n"
						+ "            $$$$   $$$$              $$$$$$   $$$$                                                  \n"
						+ "            $$$$$  $$$$$$$$$$$  $$$$   $$$$   $$$$$                                                 \n"
						+ "            $$$$$  $$$$$$$$$$$  $$$$$$$$$$$   $$$$$                                                 \n"
						+ "            $$$$$   $$$$$$$$$    $$$$$$$$$$   $$$$$                                                 \n"
						+ "            $$$$$    $$$$$$$      $$$$$$$$    $$$$$                                                 \n"
						+ "");
	}

	@Test
	public void testGetContentWithEmptyText() {
		assertThatIllegalArgumentException().isThrownBy(() -> new PostableAsciiImage("").getContent())
				.withMessage("The text to convert cannot be empty");
	}

	@Test
	public void testGetContentWithTextTooLong() {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> new PostableAsciiImage("this is a text too long").getContent())
				.withMessage("The text is too long for being visualized");
	}
}
