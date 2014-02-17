package bobagento;

import static webGrude.Browser.open;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import blog.Bobagento;
import blog.Bobagento.BobagentoPost;
import blog.NaoSalvo;

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
		response.setContentType("text/html");
		PrintWriter out;
		try {
			out = response.getWriter();
		} catch (final IOException e) {
			return;
		}
		
		out.print("<html>\n<body>");
		
		final Bobagento bobagento = open(Bobagento.class);
		for (final BobagentoPost  post : bobagento.posts) {
			out.print("<h1>");
			out.print(post.titulo);
			out.print("</h1>");
			out.print(post.texto.html());
		}
		
		final NaoSalvo naoSalvo = open(NaoSalvo.class);
		for (final blog.NaoSalvo.NaoSalvoPost post : naoSalvo.posts) {
			out.print("<h1>");
			out.print(post.titulo);
			out.print("</h1>");
			out.print(post.texto.html());
		}
		
		out.print("</body>\n</html>");
	}

}
