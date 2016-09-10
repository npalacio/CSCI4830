package home;

import java.util.Collection;
import java.util.List;

public interface IGroceryList {
	Collection<GroceryItem> getItems();
	public void setItems(List<GroceryItem> items);
	void removeItem(String name);
	void addItem(String item, double price);
	int count();
}
