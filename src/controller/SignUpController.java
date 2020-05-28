package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.SignUpValidation;
import dao.UserDao;
import model.Users;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/signup")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("confirm-password");
		String mobile = request.getParameter("mobile");
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		System.out.println(confirmpassword);
		System.out.println(mobile);
		
		SignUpValidation signUpValidation = new SignUpValidation();
		boolean checkUser = signUpValidation.checkUserDetails(email, mobile, password, confirmpassword);
		
		System.out.println(checkUser);
		if(checkUser) {
			
			Users user = new Users();
			user.setName(name);
			user.setEmail(email.toLowerCase());
			user.setContactNumber(mobile);
			user.setPassword(password);
			
			try {
				UserDao userDao = new UserDao();
				int signUpUser = userDao.signupUser(user);
				if(signUpUser!=0) {
					System.out.println("Signup Success");
					request.setAttribute("message", "SignUp successfully you can login");
					RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
					rd.forward(request, response);
				}
				else {
					request.setAttribute("message", "Fill Valid details");
					RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
					rd.forward(request, response);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		else {
			request.setAttribute("message", "Fill Valid details");
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signupView.jsp");
			rd.forward(request, response);
		}
		
	}

}
