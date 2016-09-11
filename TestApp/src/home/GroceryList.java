package home;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import javax.enterprise.context.ApplicationScoped;

//import com.mysql.jdbc.Connection;
import java.sql.*;

@ApplicationScoped
public class GroceryList implements IGroceryList{

	Collection<GroceryItem> items;

	public GroceryList() {
		System.out.println("Creating new grocery list");
	}

	public Collection<GroceryItem> getItems() {
		synchronized (this){
			Connection conn = JDBCTest.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			this.items = new LinkedList<GroceryItem>();
			String groceryListQuery = "SELECT Name, Price FROM List;";
			try
			{
				ps = conn.prepareStatement(groceryListQuery);
				rs = ps.executeQuery();

				while(rs.next())
				{
					this.items.add(new GroceryItem(rs.getString("Name"), rs.getDouble("Price")));
					//this.bandId = rs.getInt("BandID");
					//String removeMembers = "delete from BandMusicians where BandID = ?";

				}
				rs.close();
				//ps.close();	
				//conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			} try {
				ps.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			return items;
		}
	}

	public void setItems(List<GroceryItem> items) {
		this.items = items;
	}

	public void removeItem(String name){
//		for(GroceryItem item : items) {
//			if(name.equals(item.getItem())){
//				//items.remove(item);
//				//System.out.println("Item Successfully Removed");
//				return;
//			}
//		}
//		System.out.println("Item not found");
		synchronized (this){
			
			Connection conn = JDBCTest.getConnection();
			PreparedStatement ps = null;
			//ResultSet rs = null;
			//this.items = new LinkedList<GroceryItem>();
			String groceryListRemoveQuery = "DELETE FROM List WHERE Name = ?;";
			try
			{
				ps = conn.prepareStatement(groceryListRemoveQuery);
				ps.setString(1, name);
				ps.executeUpdate();

				//conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			} try {
				ps.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void addItem(String item, double price){
		//items.add(new GroceryItem(item, price));
		synchronized (this){
			
			Connection conn = JDBCTest.getConnection();
			PreparedStatement ps = null;
			//ResultSet rs = null;
			//this.items = new LinkedList<GroceryItem>();
			String groceryListAddQuery = "insert into List (name, price) values (?, ?);";
			try
			{
				ps = conn.prepareStatement(groceryListAddQuery);
				ps.setString(1, item);
				ps.setDouble(2, price);
				ps.executeUpdate();

				//conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			} try {
				ps.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public int count(){
		return items.size();
	}
}
