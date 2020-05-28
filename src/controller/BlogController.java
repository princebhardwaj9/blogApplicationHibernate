package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogDao;
import model.Blog;

/**
 * Servlet implementation class BlogController
 */
@WebServlet(urlPatterns = {"/BlogController"})
public class BlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogListView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blogtitle = request.getParameter("title");
		String blogDesc = request.getParameter("description");
		LocalDate postedOn = LocalDate.now();
		
//		System.out.println(blogtitle+"-"+blogDesc+"="+postedOn);
		
		Blog blog = new Blog();
		blog.setBlogtitle(blogtitle);
		blog.setBlogDesc(blogDesc);
		blog.setPostedOn(postedOn);
		
		BlogDao blogdao = new BlogDao();
		try {
			blogdao.insertBlog(blog);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("allBlogs");
//		response.sendRedirect("allBlogs");
//		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
//		rd.forward(request, response);
	}

}
