package www;

import webGrude.Browser;
import webGrude.annotations.Page;
import webGrude.annotations.Selector;
import webGrude.elements.Link;

import java.util.List;

@Page("http://thepiratebay.se/search/{0}/0/7/0")
public class PirateBay {

    public static PirateBay search(String term){
        return Browser.get(PirateBay.class, term);
    }

    private PirateBay(){}

    @Selector(value = "#searchResult tbody tr td a[href*=magnet]", attr = "href")
    public List<String> magnets;
    
    @Selector("a:has(img[alt=Next])")
    private Link<PirateBay> next;
    
    public PirateBay nextPage(){
    	if(next == null)
    		return null;
    	return next.visit();
    }
    
    public static void main(String[] args) {
        PirateBay search = PirateBay.search("ubuntu");
        while(search!=null){
        	search.magnets.forEach(System.out::println);
        	search = search.nextPage();
        }
    }

}