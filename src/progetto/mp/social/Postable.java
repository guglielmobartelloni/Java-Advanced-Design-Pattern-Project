package progetto.mp.social;

public interface Postable {
	String getContent();

	<T> T accept(PostableVisitor<T> visitor);
}
