package solvd.laba.serviceclasses;

import solvd.laba.products.Product;
import solvd.laba.siteutilities.Inventory;

public class TestObjectsService {


    /**
     * Constructor for an inventory for the tests.
     * @return  An inventory.
     */
    public static Inventory defaultProductInventory(){

        Inventory inventory = new Inventory();

        inventory.addProduct(new Product("Sprite 500ml", 10, 2.0));
        inventory.addProduct(new Product("Bedsheets", 2, 7.5));
        inventory.addProduct(new Product("Marshmellows", 15, 1.5));
        inventory.addProduct(new Product("Dandelions", 20, 0.5));


        return inventory;
    }




}
