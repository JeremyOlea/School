import java.util.*;
import java.io.*;
/**
* @author Michael Jeremy Olea
* @version 1.0
* @since Febuary 7th, 2019
*/
public class FrontEnd {
    /**
     * Sets up the shop and runs the Menu for the user
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Tool> tools = createToolList("items.txt");
        ArrayList<Supplier> suppliers = createSupplierList("suppliers.txt");
        toolsToSuppliers(tools, suppliers);
        Inventory inventory = new Inventory(tools);
        ArrayList<Order> dailyOrders = new ArrayList<>();
        Shop shop = new Shop(inventory, suppliers, dailyOrders);
        Menu(shop);
    }

    /**
     * Operations that the user can do
     * @param shop the shop that the user will be shopping at
     */
    public static void Menu(Shop shop) {
        Boolean isRunning = true;
        Scanner scan = new Scanner(System.in);
        while(isRunning) {
            System.out.printf("\nMenu: Please select one\n\n");
            System.out.printf("1. List all tools\n");
            System.out.printf("2. Search for tool by Name\n");
            System.out.printf("3. Search for tool by ID\n");
            System.out.printf("4. Check item quantity\n");
            System.out.printf("5. Decrease quantity\n");
            System.out.printf("6. Quit\n");
            int input = scan.nextInt();
            int itemId = -1;
            String name = "";
            int quantity;
            Tool info;
            int selection;
            switch(input) {
                case 1:
                    System.out.println(shop.getInventory().getTools());
                    break;

                case 2:
                    Scanner readCase2 = new Scanner(System.in);
                    System.out.printf("Which item (name)?\n");
                    name = readCase2.nextLine();
                    info = shop.getInventory().search(name);
                    if(info == null) {
                        System.out.printf("\nitem does not exist\n");
                    }
                    else{
                        System.out.println("\n" + info.toString());
                    }
                    break;

                case 3:
                    Scanner readCase3 = new Scanner(System.in);
                    System.out.printf("Which item (id)?\n");
                    itemId = readCase3.nextInt();
                    info = shop.getInventory().search(itemId);
                    if(info == null) {
                        System.out.printf("\nitem does not exist\n");
                    }
                    else{
                        System.out.println("\n" + info.toString());
                    }
                    break;

                case 4:
                    Scanner readCase4 = new Scanner(System.in);
                    System.out.printf("Enter 0 to select by name and 1 to select by id\n");
                    selection = readCase4.nextInt();
                    readCase4.nextLine();
                    if(selection == 0) {
                        System.out.printf("Which item?\n");
                        name = readCase4.nextLine().toLowerCase();
                        quantity = shop.checkStock(name);
                        if(quantity != -1) 
                            System.out.printf("\nThere are %d %s(s) in stock!\n", quantity, name);
                    }
                    else {
                        System.out.printf("Which item?\n");
                        itemId = readCase4.nextInt();
                        quantity = shop.checkStock(itemId);
                        if(quantity != -1) 
                            System.out.printf("\nThere are %d %s(s) in stock!\n", quantity, shop.getInventory().search(itemId).getName());
                    }
                    
                    break;

                case 5:
                    Scanner readCase5 = new Scanner(System.in);
                    int isValid;
                    System.out.printf("Enter 0 to select by name and 1 to select by id\n");
                    selection = readCase5.nextInt();
                    readCase5.nextLine();
                    System.out.printf("Which item?\n");
                    if(selection == 0) {
                        name = readCase5.nextLine().toLowerCase();
                        //readCase5.nextLine();
                        System.out.printf("How much?\n");
                        quantity = readCase5.nextInt();
                        isValid = shop.buyItem(name, quantity);
                        shop.checkStock(name);
                    }
                    else {
                        itemId = readCase5.nextInt();
                        System.out.printf("How much?\n");
                        readCase5.nextLine();
                        quantity = readCase5.nextInt();
                        isValid = shop.buyItem(itemId, quantity);
                        shop.checkStock(itemId);
                    }
                        
                    if(isValid == -1) {
                        System.out.printf("\nSorry, item of that quantity not available\n");
                    }
                    else if(isValid == 1) {
                        int stock;
                        if(selection == 0)
                            stock = shop.checkStock(name);
                        else
                            stock = shop.checkStock(itemId);
                        System.out.printf("\nItem was successfully bought!\n");
                    }

                    break;

                case 6:
                    isRunning = false;
                    scan.close();
                    break;

                default:
                    System.out.printf("\nInvalid Input\n");
                    break;

            }
        }
        

    }

    /**
     * Creates the list of suppliers for the shop from a file
     * @param filename file used to enter values of supplier
     * @return completed arraylist of suppliers
     */
    public static ArrayList<Supplier> createSupplierList(String filename) {
        try {
            File supplierFile = new File(filename);
            Scanner read = new Scanner(supplierFile);
            ArrayList<Supplier> suppliers= new ArrayList<>();

            while(read.hasNextLine()) {
                String s = read.nextLine();
                String[] line = s.split(";");
                Supplier supplier = new Supplier(Integer.parseInt(line[0]), line[1], line[2], line[3]);
                suppliers.add(supplier);
            }
        read.close();
        return suppliers;
        } 
        catch (FileNotFoundException f) {
            System.out.printf("\nFile not found\n");
            return null;
        }

    }

    /**
     * Creates the list of tools for the shop from a file
     * @param filename file used to enter values of tools
     * @return completed array of tools
     */
    public static ArrayList<Tool> createToolList(String filename) {
        try {
            File toolFile = new File(filename);
            Scanner read = new Scanner(toolFile);
            ArrayList<Tool> tools = new ArrayList<>();

            while(read.hasNextLine()) {
                String s = read.nextLine();
                String[] line = s.split(";");
                Tool tool = new Tool(Integer.parseInt(line[0]), line[1], Integer.parseInt(line[2]), Double.parseDouble(line[3]), Integer.parseInt(line[4]));
                tools.add(tool);
            }
            read.close();
            return tools;
        }
        catch (FileNotFoundException f) {
            System.out.printf("\nFile not found\n");
            return null;
        }
    }

    /**
     * Matches all tools to their respective suppliers
     * @param tools all tools in the shop
     * @param suppliers all suppliers that have given tools to a shop
     */
    public static void toolsToSuppliers(ArrayList<Tool> tools, ArrayList<Supplier> suppliers) {
        for(int i = 0; i < tools.size(); i++) {
            for(int j = 0; j < suppliers.size(); j++) {
                if(tools.get(i).getSupplierId() == suppliers.get(j).getId()) {
                    tools.get(i).setSupplier(suppliers.get(j));
                    break;
                }
            }
        }
    }
}    


