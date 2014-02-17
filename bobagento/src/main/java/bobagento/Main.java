package bobagento;

import javax.servlet.MultipartConfigElement;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
	
	private static Server server;

	public static void main(final String[] args) throws Exception
    {
        server = new Server(8000);
        final ServerConnector connector = new ServerConnector(server);
		connector.setPort(8000);
		server.setConnectors(new Connector[] { connector });
		final ServletContextHandler servletContext = getIndexServletContext();
		setHandlers(servletContext);
         
        server.start();
        server.join();
    }
	
	private static ServletContextHandler getIndexServletContext() {
		final ServletContextHandler context = new ServletContextHandler();
		context.setContextPath("/");
		final ServletHolder mainHolder = new ServletHolder(new Index());
		mainHolder.getRegistration().setMultipartConfig(new MultipartConfigElement("/tmp", 1048576, 1048576, 262144));
		context.addServlet(mainHolder, "/");
		return context;
	}

	private static void setHandlers(final Handler... handlerArray) {
		final HandlerCollection handlers = new HandlerCollection();
		handlers.setHandlers(handlerArray);
		server.setHandler(handlers);
	}
}
