package solvd.laba.customstructures;
import solvd.laba.exceptions.IndexOutOfRangeException;


/**
 * Custom LinkedList class, storing nodes that wrap a parametrized type.
 * @param <E>   , the Class of objects to be stored in this list.
 */
public class LinkedList<E> {

    /**
     * Private node class, used within this list to wrap stored data.
     */
    private class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    /**
     * Method used to add a new element, to a specific index of the list.
     * @param index     , the index on which the element is to be added
     * @param element   , the data to be added in that position (Wrapped by a node)
     */
    public void add(int index, E element) {
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfRangeException("Index ("+ index + ") not in range ("
                    + this.size() + ").");
        }
        Node aux = new Node(element);
        if (index == 0) {
            aux.next = head;
            head = aux;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            aux.next = current.next;
            current.next = aux;
        }
    }

    /**
     * Method to remove an element by the index.
     * @param index , the position in the linked list of the data to pop.
     * @return  the value stored in the removed index.
     */
    public E remove(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfRangeException("Index ("+ index + ") not in range ("
                    + this.size() + ").");
        }
        Node removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedNode = current.next;
            current.next = current.next.next;
        }
        return removedNode.data;
    }


    /**
     * Method to remove an element by the index. When using pop, the return value
     * of the popped value is irrelevant.
     * @param index , the position in the linked list of the data to pop.
     */
    public void pop(int index) {
        this.remove(index);
    }


    /**
     * Method to remove an object if it is present in the list.
     * This will eliminate the first ocurrence of said object in the list.
     * @param removable , the object to remove.
     * @return  false if the object is not present, true if it was removed correctly.
     */
    public boolean remove(Object removable) {
        boolean ret = false;

        if (head != null) {

            if (head.data.equals(removable)) {
                head = head.next;
                ret = true;
            }
            else {
                Node current = head;
                while (current.next != null) {
                    if (current.next.data.equals(removable)) {
                        current.next = current.next.next;
                        ret = true;
                        break;
                    }
                    current = current.next;
                }
            }
        }
        return ret;
    }

    // Set element at a specific index
    public void set(int index, E element) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfRangeException("Index ("+ index + ") not in range ("
                    + this.size() + ").");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = element;
    }

    // Get element by index
    public E get(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfRangeException("Index ("+ index + ") not in range ("
                    + this.size() + ").");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Modify. I'm unsure if letting the garbage collector is the most optimal way to do this.
    public void clear() {
        head = null;
    }

    public int size() {
        int ret = 0;
        Node aux = head;
        while(aux!=null){
            ret = ret + 1;
            aux = aux.next;
        }
        return ret;
    }

    public String toString(){
        StringBuilder ret = new StringBuilder("List: {\n");
        Node current = head;
        if (head == null){
            ret.append("{Lista vacia}");
        }
        else{
            ret.append(current.data.toString());
            while(current.next!=null){
                current = current.next;
                ret.append(" -> ");
                ret.append(current.data.toString());
            }
            ret.append("}");
        }
        return ret.toString();
    }

}
