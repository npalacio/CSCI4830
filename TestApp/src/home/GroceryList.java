package home;

import java.util.List;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

public class GroceryList {

	List<GroceryItem> items;
	
	public GroceryList() {
		List<GroceryItem> items = new ArrayList<GroceryItem>();
		items.add(new GroceryItem("milk", 3.99));
		items.add(new GroceryItem("eggs", 1.99));
		items.add(new GroceryItem("cheese", 4.85));
		items.add(new GroceryItem("bread", 2.49));
		items.add(new GroceryItem("ketchup", 2.99));
		items.add(new GroceryItem("ham", 12.95));
	}

	public List<GroceryItem> getItems() {
		return items;
	}

	public void setItems(List<GroceryItem> items) {
		this.items = items;
	}
}