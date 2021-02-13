package progetto.mp.social;

public interface PostableVisitor<T> {
	T visitPostableImage(PostableAsciiImage image);

	T visitPostableText(PostableText text);

	T visitPost(Post post);
}
