package bobagento;

import webToJava.annotations.Selector;

@Selector(".post")
public class Post {
	
	@Selector(".tit h2")
	public String titulo;
	
	@Selector(".entry")
	public String texto;

}
