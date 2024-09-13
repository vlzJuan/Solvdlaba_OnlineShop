package solvd.laba.siteutilities;


import solvd.laba.exceptions.ItemNotInStockException;
import solvd.laba.exceptions.NotEnoughStockException;
import solvd.laba.products.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Class dedicated for the inventory stock for the site.
 * This might be easily replaced with access to a Database way down in this course.
 */
public class Inventory extends Container<Product> {



    /**
     * Constructor for an inventory, with only a list of products to initialize it.
     * It initializes the creation date as the date on which the object is instantiated.
     *
     * @param baseInventory,    the initial products to store
     */
    public Inventory(Collection<Product> baseInventory){
        super(new ArrayList<>(baseInventory));
    }

    /**
     * Default constructor. Similar to the first constructor, but initializes
     * the inventory as an empty arraylist.
     */
    public Inventory(){
        this.lastUpdate = LocalDate.now();
        this.inventory = new ArrayList<>();
    }


    //////////////// FUNCTIONAL METHODS

    /**
     * Method used to add a new product to the list.
     * If such a product exists, add its stock to the one already in the inventory.
     * @param product   , the product to be added to the inventory.
     */
    public void addProduct(Product product){
        super.add(product);
    }

    /**
     * Method used to remove a product from inventory altogether.
     * @param product   , the product to be removed from the inventory.
     */
    public void removeProduct(Product product){
        super.remove(product);
    }

    /**
     * Method used for taking an amount of a certain product out of the inventory.
     *
     * @param product   , the product to look for in the inventory.
     * @param amount    , the amount of product to take from the inventory.
     */
    public void takeProduct(Product product, int amount){
        if (this.inventory.contains(product)){
            if(product.hasStock(amount)){
                product.removeStock(amount);
            }
            else{
                throw new NotEnoughStockException("Error: Not enough stock for the request.");
            }
        }
        else{
            throw new ItemNotInStockException("Error: There is no such product in this container.");
        }
    }


    /**
     * Overriden method toString(), to show the products stored in the Inventory.
     */
    @Override
    public String toString(){
        return super.toString("Inventory. Last update: " + this.lastUpdate.toString());
    }



    ////// METHODS FROM INTERFACE 'SearchableStorage':

    /**
     * A constructor for a String that shows the objects in a list menu.
     *
     * @return  A descriptive String that shows the options within the Searchable,
     *          with indexes to access them.
     */
    @Override
    public String menuDescriptor() {
        return super.menuDescriptor("Select the object to choose:\n");
    }




}
