package blog;

import java.util.List;

import org.jsoup.nodes.Element;

import webGrude.annotations.Link;
import webGrude.annotations.Page;
import webGrude.annotations.Selector;
import webGrude.elements.Visitable;

@Page("http://www.sedentario.org/")
public class Sedentario {

	@Selector(".post") static public class SedentarioPost{
		@Selector(".tit h2") public String titulo;
		@Selector(".entry") public Element texto;
	}

	public List<SedentarioPost> posts;
	
	@Selector(".next") @Link(Sedentario.class) public Visitable<Sedentario> nextPage;
	

}
