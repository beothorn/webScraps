package legendasTV;

import webGrude.annotations.Selector;
import webGrude.elements.Link;

@Selector(".item")
public class Legenda {
	
	@Selector("a")
	public Link linkPraLegenda;

}
