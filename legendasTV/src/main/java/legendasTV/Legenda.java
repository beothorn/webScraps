package legendasTV;

import webToJava.annotations.Selector;
import webToJava.elements.Link;

@Selector(".item")
public class Legenda {
	
	@Selector("a")
	public Link linkPraLegenda;

}
