package progetto.mp.social.utils;

import progetto.mp.social.TextContent;

public class MockTextContent implements TextContent {
	
	
	private String content;


	public MockTextContent(String content) {
		this.content = content;

	}

	
	/**
	 * For testing there is not an implementation for this method
	 */
	@Override
	public void display() {
	}

	
	@Override
	public String toString() {
		return content;
	}

}
