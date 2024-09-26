package solvd.laba.mainsfortesting;

import solvd.laba.paymentmethods.BankAccount;
import solvd.laba.serviceclasses.TestObjectsService;
import solvd.laba.siteutilities.Inventory;
import solvd.laba.users.Client;

import static solvd.laba.serviceclasses.MenuPromptsService.cartPurchaseMenu;

/**
 * Class used to test all classes (except the abstract ones) can be instantiated.
 */
public class MainApp {


    public static void main(String[] args){


        //  Initialize an inventory with several products:
        Inventory inventory = TestObjectsService.defaultProductInventory();

        BankAccount testAccount = new BankAccount(
                1000, 1, 100, "PabloCash");

        Client testClient = new Client("Pablo", "007", testAccount);

        cartPurchaseMenu(testClient, inventory);


    }


}
