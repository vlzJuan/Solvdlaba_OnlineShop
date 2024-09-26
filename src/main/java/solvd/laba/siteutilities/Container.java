package solvd.laba.siteutilities;


import solvd.laba.exceptions.IndexOutOfRangeException;
import solvd.laba.exceptions.ItemNotInStockException;
import solvd.laba.interfaces.IndexableByMenu;
import solvd.laba.interfaces.SearchableStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 * Class dedicated for the inventory stock for the site.
 * This might be easily replaced with access to a Database way down in this course.
 */
public abstract class Container<T extends IndexableByMenu> implements SearchableStorage<T> {

    //  Attributes:
    protected LocalDate lastUpdate;
    public ArrayList<T> inventory;

    /**
     * Constructor for an inventory, with only a list of products to initialize it.
     * It initializes the creation date as the date on which the object is instantiated.
     *
     * @param baseInventory,    the initial products to store
     */
    public Container(ArrayList<T> baseInventory){
        this.lastUpdate = LocalDate.now();
        this.inventory = new ArrayList<>(baseInventory);
    }

    /**
     * Default constructor. Similar to the first constructor, but initializes
     * the inventory as an empty arraylist.
     */
    public Container(){
        this.lastUpdate = LocalDate.now();
        this.inventory = new ArrayList<>();
    }


    //////////////// FUNCTIONAL METHODS

    /**
     * Method used to add a new product to the list.
     * If such a product exists, add its stock to the one already in the inventory.
     * @param product   , the product to be added to the inventory.
     */
    public void add(T product){
        this.inventory.add(product);
        this.lastUpdate = LocalDate.now();
    }

    /**
     * Method used to remove a product from inventory altogether.
     * @param product   , the product to be removed from the inventory.
     */
    public void remove(T product){

        if(!this.inventory.contains(product)){
            throw new ItemNotInStockException("Error: No such item in this " + this.getClass());
        }
        this.inventory.remove(product);
        this.lastUpdate = LocalDate.now();
    }


    /**
     * Overriden method toString(), to show the products stored in the Inventory.
     */
    protected String toString(String descriptor){
        StringBuilder retornable = new StringBuilder();
        retornable.append(format(descriptor + "\n{\n",
                this.lastUpdate.toString()));
        for(T prod:this.inventory){
            retornable.append(prod.toString()).append("\n");
        }
        retornable.append("}");
        return retornable.toString();
    }

    public String menuDescriptor(String initialString) {

        StringBuilder retornable = new StringBuilder();
        retornable.append(initialString+"\n");
        int i=0;
        for(T object:inventory){
            retornable.append(i + " - " + object.descriptorForMenu() + "\n");
            i = i+1;
        }
        retornable.append("'-1' - Exit the menu.\n");
        return retornable.toString();
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

        StringBuilder retornable = new StringBuilder();
        retornable.append("Select the object to choose:\n");
        int i=0;
        for(T object:inventory){
            retornable.append(i + " - " + object.descriptorForMenu() + "\n");
        }
        retornable.append("'-1' - Exit the menu.");
        return retornable.toString();
    }


    /**
     * A method that returns the instance stored in the
     *
     * @param index , the
     * @return  The correct index
     * @throws  IndexOutOfRangeException  , when the passed index is not accesible.
     */
    public T retrieve(int index){
        if(index<0 || index>=this.size()){
            throw new IndexOutOfRangeException("Error: Index not within the selectable bounds");
        }
        return inventory.get(index);
    }

    /**
     * Method used to determine the internal size of this container.
     *
     * @return  an integer representing the size of the internal arrayList for
     *          the stored product within this instance.
     */
    public int size(){
        return this.inventory.size();
    }


    /**
     * Stream used for the inventory.
     * @return a stream of all the elements within the inventory
     */
    public Stream<T> containedItemsStream(){
        return this.inventory.stream();
    }


    public Stream<String> menuDescriptorIndexedStream() {
        // Create an IntStream for indices and map them to their respective descriptors
        return IntStream.range(0, inventory.size())
                .mapToObj(i -> i + " - " + inventory.get(i).descriptorForMenu());
    }





}
