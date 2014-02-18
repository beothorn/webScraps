package blog;

import java.util.List;

import org.jsoup.nodes.Element;

import webGrude.annotations.Link;
import webGrude.annotations.Page;
import webGrude.annotations.Selector;
import webGrude.elements.Visitable;

@Page("http://bobagento.com/")
public class Bobagento {

	@Selector(".post") static public class BobagentoPost{
		@Selector(".tit h2") public String titulo;
		@Selector(".entry") public Element texto;
		@Selector(".data") public String data;
	}

	public List<BobagentoPost> posts;
	
	@Selector(".next") @Link(Bobagento.class) public Visitable<Bobagento> nextPage;
	

}
