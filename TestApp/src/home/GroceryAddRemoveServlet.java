package home;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GroceryAddRemoveServlet
 */
@WebServlet("/AddRemove")
public class GroceryAddRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	@Inject
	private IGroceryList list;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		list = (IGroceryList) this.getServletConfig().getServletContext().getAttribute("groceryList");
		String itemName = request.getParameter("name");
		if(itemName != null && !itemName.isEmpty()){
			System.out.println("Grocery list before removing: " + list.count());
			list.removeItem(itemName);
			System.out.println("Grocery list after removing " + list.count());
		}
		request.setAttribute("groceryItems", list.getItems());
		getServletContext().getRequestDispatcher("/WEB-INF/pages/groceryList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
