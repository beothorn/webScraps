package bobagento;

import java.util.List;

import org.jsoup.nodes.Element;

import webGrude.annotations.Page;
import webGrude.annotations.Selector;
import webGrude.elements.Link;

@Page("http://bobagento.com/")
public class Bobagento {
	@Selector("#header-menu") static public class HeaderMenu {
		@Selector("a") public List<String> links;
	}

	@Selector(".post") static public class Post {
		@Selector(".tit h2") public String titulo;
		@Selector(".entry") public Element texto;
	}

	@Selector("#footer small") public String footer;
	
	public List<Post> posts;
	public HeaderMenu header;
	
	@Selector("#footer small") public Link<Bobagento> nextPage;
}
