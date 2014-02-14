package bobagento;

import java.util.List;

import webToJava.annotations.PageURL;
import webToJava.annotations.Selector;

@PageURL("http://bobagento.com/")
public class Bobagento {

	@Selector("#footer small")
	public String footer;
	
	public List<Post> posts;
	
	public HeaderMenu header;
	
	public FooBar fooBar;
}
