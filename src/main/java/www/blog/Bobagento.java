package www.blog;

import java.util.List;

import webGrude.Browser;
import webGrude.annotations.Page;
import webGrude.annotations.Selector;
import webGrude.elements.Link;

import com.google.gson.annotations.Expose;

@Page("http://bobagento.com/")
public class Bobagento {

	public static Bobagento open(){
        return Browser.get(Bobagento.class);
    }
	
	@Selector(".post") static public class BobagentoPost{
		
		@Expose
		@Selector(".tit h2") 
		public String titulo;
		
		@Expose
		@Selector(value = ".entry", attr = "html") 
		public String texto;
	}

	@Expose
	public List<BobagentoPost> posts;
	
	@Selector(".next") private Link<Bobagento> nextPage;
	
	public Bobagento next(){
        return nextPage.visit();
    }
	
	private Bobagento(){}

}
