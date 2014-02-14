package bobagento;

import java.util.List;

import webToJava.annotations.Selector;

@Selector("header-menu")
public class HeaderMenu {

	@Selector("a")
	public List<String> links;
}
