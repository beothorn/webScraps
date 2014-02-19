package rss;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Foo {
	
	public static void main(final String[] args) {
		Foo.test();
	}
	
	public static String test() {
		final XStream xstream = new XStream(new DomDriver());

		xstream.alias("rss",Rss.class); 
		xstream.alias("channel",Channel.class); 
		xstream.alias("item",Item.class); 
		xstream.addImplicitCollection(Channel.class, "item"); 
		xstream.useAttributeFor(Rss.class, "version");
		
		final Rss rss = new Rss();
		
		final Channel channel = new Channel();
		channel
			.setTitle("RSS Title")
			.setDescription("This is an example of an RSS feed")
			.setLink("http://www.someexamplerssdomain.com/main.html")
			.setLastBuildDate("Mon, 06 Sep 2010 00:01:00 +0000 ")
			.setPubDate("Mon, 06 Sep 2009 16:20:00 +0000 ")
			.setTtl("1800")
			.setGenerator("")
			.setLanguage("")
		;
		
		rss
			.setVersion("2.0")
			.setChannel(channel);
		
		final Item item = new Item();
		item
			.setTitle("Example entry")
			.setDescription("<h1>Foo</h1>")
			.setLink("http://www.wikipedia.org/")
			.setPubDate("Mon, 06 Sep 2009 16:20:00 +0000 ")
			.setGuid("unique string per item")
		;
		
		channel.addItem(item);
		
		final String xml = xstream.toXML(rss);
		final String rssOutput = 
				"<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"+xml;
		System.out.println(rssOutput);
		return rssOutput;		
	}

}
