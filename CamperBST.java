///////////////////////////////////////////////////////////////////////////////
// ALL STUDENTS COMPLETE THESE SECTIONS
// Title: P09 Camp Badger
// Files: Camper.java, CampTreeNode.java, CamperBST.java, CampManager.java, CampEnrollmentApp.java
// Semester: CS 300 Fall 2019
//
// Author: Willie Klein
// Email: wdklein@wisc.edu
// CS Login: willie
// Lecturer's Name: Gary Dahl
//////////////////// CREDIT OUTSIDE HELP///////////////////////////////////////
//
// Persons: TA's in office hours
//
// Online sources: https://stackoverflow.com/

//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * This class represents a binary search tree which allows for the insertion, deletion and traversal
 * of the tree. This class is the lower level language of CampManager, which calls these methods to
 * enroll, unenroll and print the campers
 * 
 * @author Willie Klein (wdklein)
 *
 */
public class CamperBST {

  public CampTreeNode root;
  private int size;

  /**
   * Constructor initializes the root and size
   */
  public CamperBST() {
    this.root = null;
    this.size = 0;
  }

  /**
   * Returns the current size of the CamperBST
   * 
   * @returns current size of the CamperBST
   */
  public int size() {
    return this.size;
  }

  /**
   * Returns true if the tree is empty, false otherwise
   * 
   * @returns true if empty false otherwise
   */
  public boolean isEmpty() {

    if (size == 0 && root == null) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Starts tree insertion by calling insertHelp() on the root and assigning root to be the subtree
   * returned by that method
   * 
   * @param newCamper - new camper to be added to the tree
   */
  public void insert(Camper newCamper) {
    root = insertHelp(root, newCamper);
    size++;
  }

  /**
   * Recursive helper method to insert.
   * 
   * @param current, The "root" of the subtree we are inserting into, ie the node we are currently
   *        at.
   * @param newCamper, the camper to be inserted into the tree
   * @return the root of the modified subtree we inserted into
   */
  private CampTreeNode insertHelp(CampTreeNode current, Camper newCamper) {

    // if root is null, root = current = newCamper
    if (current == null) {
      current = new CampTreeNode();
      current.setData(newCamper);
      return current;
    }

    // If new camper is less than current, set left of current
    if (newCamper.compareTo(current.getData()) < 0) {
      current.setLeftNode(insertHelp(current.getLeftNode(), newCamper));
    }

    // If new camper is greater than current, set right of current
    else {
      current.setRightNode(insertHelp(current.getRightNode(), newCamper));
    }
    return current;
  }

  /**
   * Prints the contents of this tree in alphabetical order based on the string "lastName,
   * firstName"
   * 
   */
  public void print() {
    printHelp(root);
  }

  /**
   * Recursive helper method of print()
   * 
   * @param current
   */
  private void printHelp(CampTreeNode current) {

    // Return if null
    if (current == null) {
      return;
    }
    // Basically printing out the data as an inorder traversal
    printHelp(current.getLeftNode());
    System.out.println(current.getData());
    printHelp(current.getRightNode());
  }

  /**
   * Deletes a Camper into the binary search tree if it exists.
   * 
   * @param key, the camper to be deleted from the tree
   * @throws NoSuchElementException if it is thrown by deleteHelp
   */
  public void delete(Camper key) throws NoSuchElementException {
    root = deleteHelp(root, key);
    size--;
  }

  /**
   * Recursive helper method to delete.
   * 
   * @param current, The "root" of the subtree we are deleting from, ie the node we are currently
   *        at.
   * @param key, the camper to be deleted from the tree
   * @return the root of the modified subtree we deleted from
   * @throws NoSuchElementException if the camper is not in the tree
   */
  private CampTreeNode deleteHelp(CampTreeNode current, Camper key) {

    // If the camper is not in the tree
    if (current == null) {
      throw new NoSuchElementException("That camper is not enrolled.");
    }

    // Moves to left node if key is less than current
    if (key.compareTo(current.getData()) < 0) {
      current.setLeftNode(deleteHelp(current.getLeftNode(), key));
    }

    // Moves to right node if the key is greater than the current
    else if (key.compareTo(current.getData()) > 0) {
      current.setRightNode(deleteHelp(current.getRightNode(), key));
    }

    // If left node is null, return right node
    else {
      if (current.getLeftNode() == null) {
        return current.getRightNode();
      }

      // If right node is null, return the left node
      else if (current.getRightNode() == null) {
        return current.getLeftNode();
      }

      // Calls helper method getMinNode of the right nodes children and sets that as current
      current.setData(getMinNode(current.getRightNode()));

      // Recursive call to set the right node as new node
      current.setRightNode(deleteHelp(current.getRightNode(), current.getData()));
    }
    return current;
  }

  /**
   * Helper method to deleteHelp to determine minimum node in a tree
   * 
   * @param current - current node in tree
   * @return min node - lesser of 2 nodes
   */
  Camper getMinNode(CampTreeNode current) {

    // Returns right node if left node is null
    if (current.getLeftNode() == null) {
      return current.getData();
    }

    else {
      // Recursive call on the left nodes children to get min
      return getMinNode(current.getLeftNode());
    }
  }


  // LinkedList to maintain current traversal
  private LinkedList<Camper> traversedLList;

  // returns an iterator of camper in the correct order as designated
  public Iterator<Camper> traverse(String order) {

    // first time traversing need to initialize LinkedList
    if (traversedLList == null) {
      traversedLList = new LinkedList<Camper>();
    }

    else {
      // clear the list to start over for a new traversal
      traversedLList.clear();
    }

    traverseHelp(root, order);
    return traversedLList.listIterator();
  }

  /**
   * Recursive helper method to traverse. Will take the current CampTreeNode’s data and add it to
   * traversedLList based on the given order. Then continue to recurse on the correct subtree.
   * 
   * @param current, the root of the current subtree we are traversing
   * @param order, the type of traversal to perform
   */
  private void traverseHelp(CampTreeNode current, String order) {


    if (current != null) {

      // Inorder traversal
      if (order.equals("INORDER")) {

        traverseHelp(current.getLeftNode(), "INORDER");

        // adds node data to linked list
        traversedLList.addLast(current.getData());
        traverseHelp(current.getRightNode(), "INORDER");
      }

      // Preorder traversal
      if (order.equals("PREORDER")) {

        // adds node data to linked list
        traversedLList.addLast(current.getData());

        traverseHelp(current.getLeftNode(), "PREORDER");
        traverseHelp(current.getRightNode(), "PREORDER");
      }

      // Postorder traversal
      if (order.equals("POSTORDER")) {

        traverseHelp(current.getLeftNode(), "POSTORDER");
        traverseHelp(current.getRightNode(), "POSTORDER");

        // adds node data to linked list
        traversedLList.addLast(current.getData());
      }
    }
  }
}
