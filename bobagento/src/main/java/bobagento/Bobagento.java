package bobagento;

import java.util.List;

import webToJava.Browser;
import webToJava.annotations.PageURL;
import webToJava.annotations.Selector;

@PageURL("http://bobagento.com/")
public class Bobagento {

	public static void main(final String[] args) {
		final Bobagento bobagento = Browser.open(Bobagento.class);
		System.out.println(bobagento.footer);
		System.out.println(bobagento.posts.get(0).titulo);
		System.out.println(bobagento.posts);
	}
	
	@Selector("#footer small")
	public String footer;
	
	public List<Post> posts;
	
	public HeaderMenu header;
	
	public FooBar fooBar;
}
