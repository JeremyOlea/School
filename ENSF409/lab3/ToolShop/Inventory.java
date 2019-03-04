import java.util.*;

public class Inventory {
   private static ArrayList<Tool> tools;
	public void addTool(Tool tool) {
		tools.add(tool);
	}
	public void deleteTool(Tool tool) {
		tools.remove(tool);
	}
	public Inventory(ArrayList<Tool> tools) {
		this.tools = tools;
	}

   public void increment(String name, int quantity) {
	   // int id = tool.getId();
	   Tool item = search(name);
	   item.increaseQuantity(quantity);
	   
   }
   
//    public int decrement(String name, int quantity) {
// 	  // int id = tool.getId();
// 	   Tool item = search(name);
// 	   if (item == null) {
// 		   System.out.printf("Item does no exist!\n");
// 		   return 0;
// 	   }
// 	   if(item.getQuantity() >= quantity) {
// 			item.decreaseQuantity(quantity);  
// 			return 1;
// 	   }
// 	   else
// 	   	return -1;
	    
//    }
   
   public Tool search(String name) {
	   for(int i = 0; i < tools.size(); i++) {
		   if(name.toLowerCase().equals(tools.get(i).getName().toLowerCase())) {
			   return tools.get(i);
		   }
	   }
	   return null;

   }
   
   public Tool search(int id) {
	   for(int i = 0; i < tools.size() - 1; i++) {
		   if(id == tools.get(i).getId()) {
			   return tools.get(i);
		   }
	   }
	   return null;
   }

   public ArrayList<Tool> getTools() {
	   return tools;
   }

//    public void linkSuppliers () {
// 	   for(int i = 0; i < inventory.size(); i++) {
// 		   inventory.get(i).setSupplier();
// 	   }
//    }


}