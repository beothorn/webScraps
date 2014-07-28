package www.blog;

import java.util.List;

import webGrude.Browser;
import webGrude.annotations.Page;
import webGrude.annotations.Selector;
import webGrude.elements.Link;

import com.google.gson.annotations.Expose;

@Page("http://www.naosalvo.com.br/")
public class NaoSalvo {

    public static NaoSalvo open(){
        return Browser.get(NaoSalvo.class);
    }

	@Selector("[class=post full]")
    static public class NaoSalvoPost {

        @Expose
		@Selector(".post-title")
        public String titulo = "default";

        @Expose
        @Selector(value=".post-data", attr="html")
        public String texto = "default";
        
    }

    @Expose
	public List<NaoSalvoPost> posts;
	
	@Selector(".nextpostslink")
    private Link<NaoSalvo> nextPage;

    public NaoSalvo next(){
        return nextPage.visit();
    }

    private NaoSalvo(){}
}