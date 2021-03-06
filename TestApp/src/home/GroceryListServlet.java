package home;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GroceryList
 */
@WebServlet("/GroceryList")
public class GroceryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IGroceryList list = new GroceryList();
	int i = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroceryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//list = new GroceryList();
    	System.out.println(list);
    	//System.out.println("Current list size = " + list.count());
    	System.out.println("Printing current items on list:");
    	for(GroceryItem item : list.getItems()) {
    		System.out.println("\t" + item.getItem());
    	}
    	if(i == 0){
    		this.getServletConfig().getServletContext().setAttribute("groceryList", list);
    		i++;
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
