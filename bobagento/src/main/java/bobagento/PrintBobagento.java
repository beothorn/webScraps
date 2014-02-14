package bobagento;

import java.util.List;

import webToJava.Browser;

public class PrintBobagento {

	public static void main(final String[] args) {
		final Bobagento bobagento = Browser.open(Bobagento.class);
		
		final List<String> links = bobagento.header.links;
		final StringBuilder menu = new StringBuilder();
		for (final String opcao : links) {
			menu.append(opcao+" | ");
		}
		System.out.println(menu.toString().trim());
		
		final List<Post> posts = bobagento.posts;
		for (final Post post : posts) {
			System.out.println("--------------------------------");
			System.out.println(post.titulo);
			System.out.println();
			System.out.println(post.texto);
		}
		System.out.println(bobagento.footer);
	}

}
