package servlet;

import javax.servlet.*;
import java.io.IOException;

public class HelloServlet implements Servlet{

	private ServletConfig config;
	
	public HelloServlet(){
		System.out.println("HelloServlet.HelloServlet()");
	}
	@Override
	public void destroy() {
		System.out.println("HelloServlet.destroy()");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("HelloServlet.getServletConfig()");
		return config;
	}

	@Override
	public String getServletInfo() {
		System.out.println("HelloServlet.getServletInfo()");
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("HelloServlet.init()");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		String values = getServletConfig().getInitParameter("admin");
		res.getWriter().write(values);
		System.out.println("HelloServlet.service()");
	}

}
