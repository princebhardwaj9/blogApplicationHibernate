package controller;

import java.io.IOException;
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
 * Servlet implementation class EditBlogController
 */
@WebServlet(urlPatterns = "/edit")
public class EditBlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBlogController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		try {
			showEditForm(request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("showEditForm");
//		BlogDao blogdao = new BlogDao();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
//		Blog existingBlog = blogdao.selectBlog(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/blogListView.jsp");
		request.setAttribute("title", id);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String blogtitle = request.getParameter("title");
		String blogDesc = request.getParameter("description");
		LocalDate postedOn = LocalDate.now();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("doPost id"+id);
		
		Blog blog = new Blog();
		blog.setBlogid(id);
		blog.setBlogtitle(blogtitle);
		blog.setBlogDesc(blogDesc);
		blog.setPostedOn(postedOn);
		
		BlogDao blogdao = new BlogDao();
		try {
			blogdao.updateBlog(blog);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("allBlogs");
	}

}
