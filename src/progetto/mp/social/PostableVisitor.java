package progetto.mp.social;

public interface PostableVisitor<T> {
	T visitPostableImage(PostableImage image);

	T visitPostableText(PostableText text);

	T visitPost(Post post);
}
