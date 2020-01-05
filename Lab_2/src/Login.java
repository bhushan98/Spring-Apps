

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username = "Bhushan";
	private String password = "Bhushan";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputUsername = request.getParameter("username");
		String inputPassword = request.getParameter("password");
		
		if(username.equals(inputUsername) && password.equals(inputPassword)){
			request.getRequestDispatcher("/success.html").forward(request, response); 
		} else {
			request.getRequestDispatcher("/failure.html").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
