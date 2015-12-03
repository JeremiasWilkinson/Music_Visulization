package prj5;

import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


/**
 * This class represent a list it extends comparator and implements
 * iterator so every object of this list needs to have a compare
 * method to help the user compare them
 * the iterator allow the user to traverse the list
 * efficiently
 * @author Edgar Han (edgarh)
 * @author Shannon Hsu (shsu) 
 * @author Broulaye Doumbia (broulaye)
 * @version 11-20-2015
 * @param <T> represent the object of the linked list
 */
public class LinkedList<T extends 
    Comparator<? super Object>> implements Iterable<T> {

    /**
     * represent the node class 
     * @author Broulaye Doumbia (broulaye)
     *
     */
    private class Node {
        private T data;
        private Node next;
        
        
        /**
         * constructor that create a node with a
         * given value by the user
         * @param item represent the given value
         */
        public Node(T item) {
            this(item, null);
        }
        
        /**
         * constructor that create a node with a 
         * given value and pointing to a giving 
         * node by the user
         * @param datum represent the given value
         * @param node represent the given node
         */
        public Node(T datum, Node node) {
            data = datum;
            next = node;
        }
        
        /**
         * get the next node
         * @return the next node
         */
        public Node getNext() {
            return next;
        }
        
        /**
         * get the data of a node
         * @return the data of the node
         */
        public T getData() {
            return data;
        }
        
        /**
         * set the data of a node to a given
         * value by the user
         * @param other represent the given value
         
        public void setData(T other) {
            data = other;
        }
        */
        /**
         * set the next Node a node to a given
         * node by the user
         * @param node represent the given node
         */
        public void setNext(Node node) {
            next = node;
        }
    } // end node class
    
    
    private Node head;
    @SuppressWarnings("unused")
    private Node tail;
    private int size;
    
    /**
     * add a given entry to the top of list
     * @param newEntry represent the entry to be added
     */
    public void add(T newEntry) {
        if (newEntry == null) {
            throw new 
            IllegalArgumentException("Illegal value "
                    + "given to the node");
        }
        Node newNode = new Node(newEntry);
        newNode.setNext(head);
        if (isEmpty()) {
            tail = newNode;
        }
        size++;
        head = newNode;
    }
    
    /**
     * constructor that create an empty list
     */
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * add a given entry to a given position in the list
     * @param position represent the given position
     * @param newEntry represent the given entry
     */
    public void add(int position, T newEntry) {
        if (newEntry == null) {
            throw new IllegalArgumentException(
                    "Illegal value given to the node");
        }
        if ((position >= 1) && (position <= size + 1)) {
            Node newNode = new Node(newEntry);
            if (position == 1) {
                newNode.setNext(head);
                head = newNode;
            }
            else {
                Node nodeBefore = getNodeAt(position - 1);
                Node nodeAfter = nodeBefore.next;
                newNode.setNext(nodeAfter);
                nodeBefore.setNext(newNode);
            }
            size++;        
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
    
    
    /**
     * These methods are to sort the list i will explain 
     * when we see each other
     * @return
     
    public Node getHead() {
        if(!isEmpty()) {
            return head;
        }
        
        else {
            return null;
        } 
    }
    */
    
    /**
     * remove the entry at the given position
     * @param index represent the given position
     * @return the entry removed
     */
    public T remove(int index) {
        T result = null;
        if ((index >= 1) && (index <= size)) {
            if (index == 1) {
                result = head.getData();
                head = head.getNext();
            }
            else {
                Node nodeBefore = getNodeAt(index - 1);
                Node nodeToRemove = nodeBefore.getNext();
                result = nodeToRemove.getData();
                Node nodeAfter = nodeToRemove.getNext();
                nodeBefore.setNext(nodeAfter);
            }
            size--;
            return result;
        } // end if
        else {
            throw new IndexOutOfBoundsException("Illegal Position"
                    + " given to remove operation");
        }
    }
    
    /**
     * get the entry at the top of the lisst
     * @return the entry at the top
     */
    public T getFront() {
        T result = null;
        if (!isEmpty()) {
            result = head.getData();
        } // end if
        return result;
    } // end getFront
    
    /**
     * clear the list
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * check if the list is empty
     * @return true if the list is empty
     */
    public boolean isEmpty() {
        return size < 1;
    }
    
    /**
     * get the size of the list
     * @return the size of the list
     */
    public int size() {
        return size;
    }
    
    /**
     * check if the list contain a given entry
     * @param data represent the entry to look for
     * @return true if the list contain the entry
     */
    public boolean contains(T data) {
        Node nodeToFind = new Node(data);
        Node node = head;
        boolean found = false;
        while (node != null) {
            if (node.data.equals(nodeToFind.data)) {
                found = true;
                break;
            }
            node = node.next;
        }
        return found;
    }
    
    /**
    public Node getEntry(T data) {
        Node NodeToFind = new Node(data);
        Node Node = head;
        Node returnedNode = null;
        while(Node != null) {
            if(Node.data.equals(NodeToFind.data)) {
                returnedNode = Node;
                break;
            }
            Node = Node.next;
        }
        return returnedNode;
    }
    */
    
    /**
     * get the node at the given position
     * @param position represent the position of the node
     * @return the node at the given position
     */
    private Node getNodeAt(int position) {
        Node currentNode = head;
        for (int i = 1; i < position; i++) {
            currentNode = currentNode.next;
        }
        
        return currentNode;
    }
    
    /**
     * change the list to an array
     * @return an array representation of the list
     
    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[size];
        int index = 0;
        Node currentNode = head;
        while ((index < size) && (currentNode != null)) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNext();
            index++;
        }
        return result;
    }
     */
    /**
     * get a string representation of the list
     * @return a string representation of the list
     */
    public String toString() {
        String result = "";
        if (!isEmpty()) {
            Node tmp = head;
            for (int i = 1; i <= size(); i++) {
                result += tmp.getData().toString();
                if (tmp.getNext() != null) {
                    result += ", ";
                }
                tmp = tmp.next;
            }
        }
        return result;
    } // end toString
    
    /**
     * get the entry at the given position
     * @param position represent position of the entry
     * @return entry at the given position
     */
    public T getEntry(int position) {
        if ((position >= 1) && (position <= size)) {
            return getNodeAt(position).getData();
        }
        else {
            throw new IndexOutOfBoundsException("Illegal Position"
                    + " given to getEntry operation");
        }
        
    }
    
    
    /**
     * insert a node in the list depending on 
     * a specific type
     * @param nodeToInsert represent to insert
     * @param type represent the type
     */
    private void insertInOrder(Node nodeToInsert, Type type) {
        T item = nodeToInsert.data;
        Node currentNode = head;
        Node previousNode = null;
        while ((currentNode != null) && 
                (item.compare(currentNode.getData(), type) > 0) ) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        
        if (previousNode != null) {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
        else {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
        }
    }
    
    /**
     * sort the list according to a specific type
     * @param type represent the type the list need to 
     * be sort by
     */
    public void insertionSort(Type type) {
        if (size() > 1) {
            Node unsortedPart = head.getNext();
            head.setNext(null);
            while (unsortedPart != null) {
                Node nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.getNext();
                insertInOrder(nodeToInsert, type);
            }
        }
        
        else {
            throw new EmptyStackException();
        }
    }  
    
    @Override
    /**
     * get an iterator to traverse the list
     * @return an iterator to traverse the list
     */
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
    
    /**
     * get an iterator to traverse the list
     * @return an iterator to traverse the list in
     * reverse order
     */
    public Iterator<T> reverseIterator() {
        return new RLinkedListIterator();
    }
    
    /** 
     * Creates a new iterator that goes forwards and backwards. 
     * @return ListIterator<T> object
     
    public ListIterator<T> fBIterator() {
        return new FBIterator(); 
    }
    */
    /** 
     * Creates a new iterator that goes forwards and backwards. 
     * @return an iterator that traverses the list forwards and backwards 
     */
    public ListIterator<T> listIterator() {
        return new FBIterator(); 
    }
    
    
    /**
     * This inner class implements iterator to help user iterate through a List
     * 
     * @author Broulaye Doumbia
     * @version 11-18-2015
     *
     */
    private class LinkedListIterator implements Iterator<T> {

        private Node nextNode;

        /**
         * constructor to instantiate an object of iterator
         */
        private LinkedListIterator() {
            nextNode = head;
        }

        @Override
        /**
         * determine if the list has another person
         */
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        /**
         * advance to the next person in the list
         */
        public T next() {
            if (hasNext()) {
                Node returnedNode = nextNode;
                nextNode = nextNode.getNext();
                return returnedNode.getData();
            } 
            else {
                throw new NoSuchElementException();
            }
        }
    }
      
    private class RLinkedListIterator implements Iterator<T> {

        private Node nextNode;
        private int length;

        /**
         * constructor to instantiate an object of iterator
         */
        private RLinkedListIterator() {
            length = size;
            nextNode = getNodeAt(length);
        }

        @Override
        /**
         * determine if the list has another entry 
         */
        public boolean hasNext() {
            return length > 0;
        }

        @Override
        /**
         * advance to the next entry in the list
         */
        public T next() {
            if (hasNext()) {
                Node returnedNode = nextNode;
                length--;
                nextNode = getNodeAt(length);
                return returnedNode.getData();
            } 
            else {
                throw new NoSuchElementException();
            }
        }        
    }
    
    /** 
     * This iterator traverses the list both forwards and backwards. 
     * @author Shannon Hsu (shsu)
     * @version 2015.11.30
     */
    private class FBIterator implements ListIterator<T> {
        private Node nextNode; 
        private Node prevNode; 
        private int nextIndex; 
        private int prevIndex; 

        /** 
         * Creates a new iterator. 
         */
        private FBIterator() {
            nextNode = head; 
            prevNode = null; 
            nextIndex = 1; 
            prevIndex = 0; 
        }

        /** 
         * Determines if there is another entry in the list. 
         * @return True if there is another entry, false otherwise. 
         */
        public boolean hasNext() {
            return nextNode != null;
        }

        /** 
         * Returns the next entry and moves the iterator forward. 
         * @return The next entry. 
         */
        public T next() {
            if (hasNext()) {                
                Node returned = getNodeAt(nextIndex); 
                prevNode = returned; 
                nextNode = returned.getNext(); 
                nextIndex++; 
                prevIndex++; 
                return returned.getData();
            }
            else {
                throw new NoSuchElementException(); 
            }
        }

        /** 
         * Determines if there is a previous entry in the list. 
         * @return True if there is a previous entry, false otherwise. 
         */
        public boolean hasPrevious() {
            //return prevIndex > 0;  
            return prevNode != null; 
        }

        /** 
         * Returns the previous entry and moves the iterator backwards. 
         * @return The previous entry. 
         */
        public T previous() {
            if (hasPrevious()) {
                Node returned = getNodeAt(prevIndex);
                nextNode = returned; 
                prevIndex--;   
                nextIndex--; 
                prevNode = getNodeAt(prevIndex); 
                if (nextIndex == 1) {
                    prevNode = null; 
                }
                return returned.getData();
            }
            else {
                throw new NoSuchElementException(); 
            }
        }

        /** 
         * Returns the index of the next entry. 
         * @return The index of the next entry. 
         */
        public int nextIndex() {
            return nextIndex; 
        }

        /** 
         * Returns the index of the previous entry. 
         * @return The index of the previous entry. 
         */
        public int previousIndex() {
            return prevIndex; 
        }

        /** 
         * Removes the next entry.
         * @throws UnsupportedOperationException
         * because the method is not supported by the list. 
         */
        public void remove() {
            throw new UnsupportedOperationException("This method"
                    + " is not supported.");            
        }

        /** 
         * Sets the next entry. 
         * @throws UnsupportedOperationException
         * because the method is not supported 
         * by the list. 
         * @param obj represent nothing because
         * the method is not supported
         */
        public void set(T obj) {
            throw new UnsupportedOperationException("This method"
                    + " is not supported.");            
        }
        
        /** 
         * Adds a new entry. 
         * @throws UnsupportedOperationException
         * because the method is not supported 
         * by the list.
         * @param obj doesn't represent anything
         * because the method is not supported
         */
        public void add(T obj) {
            throw new UnsupportedOperationException("This"
                    + " method is not supported.");            
        }
    }     
} // end class