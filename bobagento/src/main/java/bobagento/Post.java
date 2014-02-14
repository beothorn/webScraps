package bobagento;

import webToJava.annotations.Selector;

@Selector(".post")
public class Post {
	
	@Selector(".tit")
	String titulo;
	
	@Selector(".entry")
	String texto;

}
