package bobagento;

import static webGrude.Browser.open;

import java.util.List;

import bobagento.Bobagento.Post;

public class PrintBobagento {

	private static final int PAGES = 3;

	public static void main(final String[] args) {
		Bobagento bobagento = open(Bobagento.class);

		for (int i = 0; i < PAGES; i++) {
			printPosts(bobagento);
			bobagento = bobagento.nextPage.visit();
		}
	}

	private static void printPosts(final Bobagento bobagento) {
		final List<Post> posts = bobagento.posts;
		for (final Post post : posts) {
			System.out.println("--------------------------------");
			System.out.println(post.titulo);
//			System.out.println();
//			System.out.println(post.texto.html());
		}
	}

}
