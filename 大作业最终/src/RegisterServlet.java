import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("come in register");
			 String password = request.getParameter("password");
			 String name = request.getParameter("firstname");
			 String repassword = request.getParameter("repassword");
			 
			 String names = request.getParameter("lastname");
			 String email = request.getParameter("email");
			 String phone = request.getParameter("phone");
			 System.out.println(password+name+repassword
					 + names+email+phone);
			 if (!TextUtils.textIsNull(password) 
				&&!TextUtils.textIsNull(name)
				&&!TextUtils.textIsNull(repassword) 
				&&!TextUtils.textIsNull(names) 
				&&!TextUtils.textIsNull(email) 
				&&!TextUtils.textIsNull(phone)
				&& password.equals(repassword)) {
				 System.out.println("×¢²á³É¹¦");
				request.getSession().setAttribute("username", name);
				request.getSession().setAttribute("password", password);
				 
			}
			 Enumeration<String> attributeNames = request.getSession().getAttributeNames();
			 while (attributeNames.hasMoreElements()) {
					String string = (String) attributeNames.nextElement();
					System.out.println(string);
				}
	}

}
