package blog;

import java.util.List;

import org.jsoup.nodes.Element;

import webGrude.annotations.Link;
import webGrude.annotations.Page;
import webGrude.annotations.Selector;
import webGrude.elements.Visitable;

@Page("http://www.naosalvo.com.br/")
public class NaoSalvo {
	
	@Selector("[class=post full]") static public class NaoSalvoPost {
		@Selector(".post-title") public String titulo;
		@Selector(".post-data") public Element texto;
	}
	
	public List<NaoSalvoPost> posts;
	
	@Selector(".nextpostslink") @Link(NaoSalvo.class) public Visitable<NaoSalvo> nextPage;
	
}