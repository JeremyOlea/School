import java.util.*;

/**
 * Holds all the tools in the shop and functions to access them
 * @author Micheal Jeremy Olea
 * @version 1.0
 * @since Febuary 7th, 2019
 */
public class Inventory {
	/**
	 * all the tools in the shop
	 */
   private static ArrayList<Tool> tools;
   /**
	* adds a new tool to the shop
	* @param tool the new tool
    */
	public void addTool(Tool tool) {
		tools.add(tool);
	}
	/**
	 * removes a tool from the shop
	 * @param tool the tool to be removed
	 */
	public void deleteTool(Tool tool) {
		tools.remove(tool);
	}

	/**
	 * Constructor for tools
	 * @param tools full ArrayList of tools
	 */
	public Inventory(ArrayList<Tool> tools) {
		this.tools = tools;
	}

	/**
	 * Searches for tool and increases the quantity of that tool
	 * @param name the name of the tool
	 * @param quantity the quantity to increase to tool by
	 */
   public void increment(String name, int quantity) {
	   // int id = tool.getId();
	   Tool item = search(name);
	   item.increaseQuantity(quantity);
	   
   }
   
	/**
	 * Searches for a tool in the inventory by name
	 * @param name the name of the tool
	 * @return Tool that was searched for
	 */
   public Tool search(String name) {
	   for(int i = 0; i < tools.size(); i++) {
		   if(name.toLowerCase().equals(tools.get(i).getName().toLowerCase())) {
			   return tools.get(i);
		   }
	   }
	   return null;

   }
   
   /**
	* Searches for a tool in the inventory by id
	* @param id the id of the tool
	* @return the tool that was searched
    */
   public Tool search(int id) {
	   for(int i = 0; i < tools.size() - 1; i++) {
		   if(id == tools.get(i).getId()) {
			   return tools.get(i);
		   }
	   }
	   return null;
   }

   /**
	* getter for the arraylist of tools
	* @return the arraylist of tools
    */
   public ArrayList<Tool> getTools() {
	   return tools;
   }
}