package bobagento;

import java.util.List;

import webToJava.annotations.PageURL;
import webToJava.annotations.Selector;

@PageURL("http://bobagento.com/")
public class Bobagento {
	@Selector("#header-menu") static public class HeaderMenu {
		@Selector("a") public List<String> links;
	}
	@Selector(".post") static public class Post {		
		@Selector(".tit h2") public String titulo;
		@Selector(".entry") public String texto;
	}
	@Selector("#footer small") public String footer;
	public List<Post> posts;
	public HeaderMenu header;
}
