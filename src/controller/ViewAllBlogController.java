package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BlogDao;
import model.Blog;

/**
 * Servlet implementation class ViewAllBlogController
 */
@WebServlet("/allBlogs")
public class ViewAllBlogController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllBlogController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Blog List");
		BlogDao blogDao = new BlogDao();
		List<Blog> allBlogList = blogDao.selectAllBlog();
		for(Blog blogsList: allBlogList) {
			System.out.println(blogsList.getBlogid());
			System.out.println(blogsList.getBlogtitle());
			System.out.println(blogsList.getBlogtitle());
			System.out.println(blogsList.getPostedOn());
		}
		request.setAttribute("allBlogList", allBlogList);
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
