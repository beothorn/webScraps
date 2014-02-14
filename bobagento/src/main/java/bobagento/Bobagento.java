package bobagento;

import java.util.List;

import webToJava.annotations.PageURL;
import webToJava.annotations.Selector;
import webToJava.elements.HTML;
import webToJava.elements.Link;

@PageURL("http://bobagento.com/")
public class Bobagento {
	@Selector("#header-menu") static public class HeaderMenu {
		@Selector("a") public List<String> links;
	}

	@Selector(".post") static public class Post {
		@Selector(".tit h2") public String titulo;
		@Selector(".entry") public HTML texto;
	}

	@Selector("#footer small") public String footer;
	
	public List<Post> posts;
	public HeaderMenu header;
	
	@Selector("#footer small") public Link<Bobagento> nextPage;
}
