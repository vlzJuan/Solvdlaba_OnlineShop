package solvd.laba.serviceclasses;

import solvd.laba.enums.ProductCategory;
import solvd.laba.products.Product;
import solvd.laba.siteutilities.Inventory;

public class TestObjectsService {


    /**
     * Constructor for an inventory for the tests.
     * @return  An inventory.
     */
    public static Inventory defaultProductInventory(){

        Inventory inventory = new Inventory();

        inventory.addProduct(new Product("Sprite 500ml",
                10, 2.0, ProductCategory.DRINK));
        inventory.addProduct(new Product("Bedsheets",
                2, 7.5, ProductCategory.TEXTILE));
        inventory.addProduct(new Product("Marshmallows 20u",
                15, 1.5, ProductCategory.FOOD));
        inventory.addProduct(new Product("Capacitors 10uF",
                20, 0.5, ProductCategory.ELECTRONICS));
        inventory.addProduct(new Product("Wires 1mm diameter, red",
                20, 0.5, ProductCategory.ELECTRONICS));
        inventory.addProduct(new Product("Black Coffee beans",
                20, 0.5, ProductCategory.FOOD));


        return inventory;
    }


}
