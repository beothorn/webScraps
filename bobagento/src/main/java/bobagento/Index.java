package bobagento;

import static webGrude.Browser.open;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rss.Channel;
import rss.Item;
import webGrude.annotations.Page;
import blog.Bobagento;
import blog.Bobagento.BobagentoPost;
import blog.NaoSalvo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Index extends HttpServlet {
	
	private static final long serialVersionUID = -4915999199672417058L;

	public static void main(final String[] args) {
		final NaoSalvo naoSalvo = open(NaoSalvo.class);
		for (final blog.NaoSalvo.NaoSalvoPost post : naoSalvo.posts) {
			System.out.println("<h1>");
			System.out.println(post.titulo);
			System.out.println("</h1>");
			System.out.println(post.texto.html());
		}
	}
	
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
		writePage(response);
//		writeRss(response);
	}

	private void writeRss(final HttpServletResponse response) {
		response.setContentType("application/rss+xml");
		final XStream xstream = new XStream(new DomDriver());

		xstream.alias("channel",Channel.class); 
		xstream.alias("item",Item.class); 
		xstream.addImplicitCollection(Channel.class, "item"); 
		
		final Channel channel = new Channel();
		channel
			.setTitle("RSS Title")
			.setDescription("This is an example of an RSS feed")
			.setLink("http://www.someexamplerssdomain.com/main.html")
			.setLastBuildDate("Mon, 06 Sep 2010 00:01:00 +0000 ")
			.setPubDate("Mon, 06 Sep 2009 16:20:00 +0000 ")
//			.setTtl("1800")
//			.setGenerator("")
//			.setLanguage("")
		;
		
		
		final Bobagento bobagento = open(Bobagento.class);
		int count = 0;
		for (final BobagentoPost  post : bobagento.posts) {
			final String[] split = post.data.split("/");
			final Item item = new Item();
			item
				.setTitle(post.titulo)
				.setDescription(post.texto.html())
				.setLink(Bobagento.class.getAnnotation(Page.class).value())
				.setPubDate("Mon, 06 Sep 2009 16:20:" + String.format("%02d", count%60) + " +0000 ")
				.setGuid("unique string per item"+count)
			;
			channel.addItem(item);
			count++;
		}
		
		
		
		final String xml = xstream.toXML(channel);
		final String rssOutput = 
				"<?xml version=\"1.0\" encoding=\"iso-8859-1\" ?>\n" + 
				"<rss version=\"2.0\">\n"+
				xml+
				"\n</rss>";
		
		
		PrintWriter out;
		try {
			out = response.getWriter();
		} catch (final IOException e) {
			return;
		}
		out.print(rssOutput);
	}
	
	private void writePage(final HttpServletResponse response) {
		response.setContentType("text/html");
		PrintWriter out;
		try {
			out = response.getWriter();
		} catch (final IOException e) {
			return;
		}
		
		out.print("<html>\n"
				+ "<style>\n"
				+ "body {\n" + 
				"	margin:50px 0px; padding:0px;\n" + 
				"	text-align:center;\n" + 
				"	}\n" + 
				"	\n" +
				".post{\n"+
				"	border:1px dashed #333;\n" + 
				"	background-color:#eee;\n" +
				"	margin:15px auto;\n" + 
				"	text-align:center;\n" + 
				"	padding:15px;\n" + 
				"}\n" + 
				"#Content {\n" + 
				"	width:900px;\n" + 
				"	margin:0px auto;\n" + 
				"	text-align:left;\n" + 
				"	padding:15px;\n" + 
				"	}"
				+ "</style>\n"
				+ "\n<body>\n"
				+ "<div id=\"Content\">\n");
		
		final Bobagento bobagento = open(Bobagento.class);
		for (final BobagentoPost  post : bobagento.posts) {
			out.print("<div class=\"post\">\n");
			out.print("<h1>");
			out.print(post.titulo);
			out.print("</h1>");
			out.print(post.texto.html());
			out.print("</div>\n");
		}
		
//		final NaoSalvo naoSalvo = open(NaoSalvo.class);
//		for (final blog.NaoSalvo.NaoSalvoPost post : naoSalvo.posts) {
//			out.print("<h1>");
//			out.print(post.titulo);
//			out.print("</h1>");
//			out.print(post.texto.html());
//		}
//		
		out.print("</div>\n</body>\n</html>");
	}

}
