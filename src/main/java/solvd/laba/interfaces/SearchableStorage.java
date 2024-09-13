package solvd.laba.interfaces;

/**
 * Interface 'Searchable'.
 * This interface will be applied to all classes that store multiple Objects of type T,
 * and need to retrieve one of these T-objects
 *
 * @param <T>   , the Object type that this class stores.
 */
public interface SearchableStorage<T>{

    /**
     * A constructor for a String that shows the objects in a list menu.
     *
     * @return  A descriptive String that shows the options within the Searchable,
     *          with indexes to access them.
     */
    String menuDescriptor();


    public static String nonRetrievableMessage(int index) {

        return "Incorrect index (" + index + "), please retry";
    }


    /**
     * A method that returns the instance stored in the
     *
     * @param index , the
     * @return  The correct index
     * @throws  solvd.laba.exceptions.IndexOutOfRangeException, when the index fails.
     */
    public T retrieve(int index);


    /**
     * Method used to determine the internal size of this container.
     *
     * @return  an integer representing the size of the internal arrayList for
     *          the stored product within this instance.
     */
    public int size();


}
