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

/**
 * Class to represent the nodes of the binary search tree.
 * 
 * @author Michelle Jensen (mejensen5)
 */
public class CampTreeNode {

  private Camper data;
  private CampTreeNode leftNode;
  private CampTreeNode rightNode;

  /**
   * Constructor for an empty CampTreeNode
   */
  public CampTreeNode() {
    data = null;
    leftNode = null;
    rightNode = null;
  }

  /**
   * Getter for data field.
   * 
   * @return The data of this CampTreeNode
   */
  public Camper getData() {
    return data;
  }

  /**
   * Getter for leftNode field.
   * 
   * @return The leftNode of this CampTreeNode
   */
  public CampTreeNode getLeftNode() {
    return leftNode;
  }

  /**
   * Getter for rightNode field.
   * 
   * @return The rightNode of this CampTreeNode
   */
  public CampTreeNode getRightNode() {
    return rightNode;
  }

  /**
   * Setter for data field
   * 
   * @param camper, the Camper that the data field will be set to
   */
  public void setData(Camper camper) {
    data = camper;
  }

  /**
   * Setter for leftNode field
   * 
   * @param node, the CampTreeNode that the leftNode field will be set to
   */
  public void setLeftNode(CampTreeNode node) {
    leftNode = node;
  }

  /**
   * Setter for rightNode field
   * 
   * @param node, the CampTreeNode that the rightNode field will be set to
   */
  public void setRightNode(CampTreeNode node) {
    rightNode = node;
  }

}