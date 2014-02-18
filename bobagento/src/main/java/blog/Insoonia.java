package blog;

import java.util.List;

import org.jsoup.nodes.Element;

import webGrude.annotations.Link;
import webGrude.annotations.Page;
import webGrude.annotations.Selector;
import webGrude.elements.Visitable;

@Page("http://www.insoonia.com/")
public class Insoonia {

	@Selector(".post .post") static public class InsooniaPost{
		@Selector(".post-titulo") public String titulo;
		@Selector(".post-content") public Element texto;
	}

	public List<InsooniaPost> posts;
	
	@Selector(".nextpostslink") @Link(Insoonia.class) public Visitable<Insoonia> nextPage;
	

}
