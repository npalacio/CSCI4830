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
		//request.setAttribute("groceryItems", list.getItems());
		//this.getServletConfig().getServletContext().setAttribute("groceryList", list);
		//getServletContext().getRequestDispatcher("/WEB-INF/pages/groceryList.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/GroceryList");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		list = (IGroceryList) this.getServletConfig().getServletContext().getAttribute("groceryList");
		System.out.println(list);
		String itemName = request.getParameter("name");
		System.out.println("Item inputted: " + itemName);
		double price = 0;
		try{
			String temp = request.getParameter("price");
			System.out.println("Price inputted: " + temp);
			price = Double.parseDouble(temp);
		} catch(NumberFormatException e) {
			String msg = "Price needs to be a number";
			System.out.println("ERROR: " + msg);
		}
		if(itemName.isEmpty()){
			System.out.println("ERROR: Item name cannot be empty");
		} else if(price != 0){
			list.addItem(itemName, price);
			System.out.println("Added " + itemName + " to the list");
		}
		System.out.println("Redirecting to servlet GroceryList");
		response.sendRedirect(request.getContextPath() + "/GroceryList");
	}

}
