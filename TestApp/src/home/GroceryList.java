package home;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GroceryList {

	Collection<GroceryItem> items;
	
	public GroceryList() {
		Collection<GroceryItem> items = new ArrayList<GroceryItem>();
		items.add(new GroceryItem("milk", 3.99));
		items.add(new GroceryItem("eggs", 1.99));
		items.add(new GroceryItem("cheese", 4.85));
		items.add(new GroceryItem("bread", 2.49));
		items.add(new GroceryItem("ketchup", 2.99));
		items.add(new GroceryItem("ham", 12.95));
		this.items = items;
	}

	public Collection<GroceryItem> getItems() {
		return items;
	}

	public void setItems(List<GroceryItem> items) {
		this.items = items;
	}
	
	public void removeItem(String name){
		for(GroceryItem item : items) {
			if(name.equals(item.getItem())){
				items.remove(item);
				break;
			}
		}
	}
	
	public void addItem(String item, double price){
		items.add(new GroceryItem(item, price));
	}
}
