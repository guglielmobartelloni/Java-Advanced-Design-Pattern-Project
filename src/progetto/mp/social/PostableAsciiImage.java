package progetto.mp.social;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class PostableAsciiImage implements Postable {

	private String textToConvert;

	public PostableAsciiImage(String textToConvertInAscii) {
		checkRequisites(textToConvertInAscii);
		this.textToConvert = textToConvertInAscii;
	}

	private void checkRequisites(String textToConvertInAscii) {
		if (textToConvertInAscii.isEmpty()) {
			throw new IllegalArgumentException("The text to convert cannot be empty");
		}

		if (textToConvertInAscii.length()>8) {
			throw new IllegalArgumentException("The text is too long for being visualized");
		}
	}

	@Override
	public String getContent() {
		return convertTextToAsciiImage();
	}


	@Override
	public <T> T accept(PostableVisitor<T> visitor) {
		return visitor.visitPostableImage(this);
	}

	private String convertTextToAsciiImage() {
		int width = 100;
		int height = 30;

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setFont(new Font("SansSerif", Font.BOLD, 24));

		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.drawString(textToConvert, 10, 20);


			StringBuilder outputAsciiText = new StringBuilder();
		for (int y = 0; y < height; y++) {
			StringBuilder partialAsciiText = new StringBuilder();
			for (int x = 0; x < width; x++) {
				partialAsciiText.append(image.getRGB(x, y) == -16777216 ? " " : "$");
			}
			if (partialAsciiText.toString().trim().isEmpty()) {
				continue;
			}
			outputAsciiText.append(partialAsciiText.toString());
			outputAsciiText.append("\n");
		}
		return outputAsciiText.toString();
	}
}
