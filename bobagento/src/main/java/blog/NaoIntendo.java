package blog;

import java.util.List;

import org.jsoup.nodes.Element;

import webGrude.annotations.Page;
import webGrude.annotations.Selector;
import webGrude.elements.Link;

@Page("http://www.naointendo.com.br/")
public class NaoIntendo {

	@Selector(".posts article") static public class NaoIntendoPost {
		@Selector("header h2") public String titulo;
		@Selector(".article-content") public Element texto;
	}
	
	public List<NaoIntendoPost> posts;
	
	@Selector(".next-page") public Link<NaoIntendo> nextPage;
}
