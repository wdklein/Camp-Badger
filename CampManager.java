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
 * This class models a camp manager, that has the power to enroll, unenroll, or count the number of
 * students. This class relies heavily on CamperBST.java to execute these commands, using the BST.
 * 
 * @author Willie Klein (wdklein)
 *
 */
public class CampManager {

  private CamperBST campers;
  private final static String[] CABIN_NAMES =
      new String[] {"Otter Overpass", "Wolverine Woodland", "Badger Bunkhouse"};

  /**
   * Constructor for the CampManager by initializing the campers field
   * 
   */
  public CampManager() {

    // Creates a new CamperBST object
    this.campers = new CamperBST();
  }

  /**
   * Prints statistics based on the current "state" of the camp. The statistics to be printed is the
   * total number of campers.
   * 
   */
  public void printStatistics() {

    // Prints zero if none have been enrolled yet
    if (campers == null) {
      System.out.println("0");
      return;
    }
    // Prints size of the campers
    System.out.println(campers.size());
  }

  /**
   * "Enrolls" a camper by determining their cabin and adding them to the tree.
   * 
   * @param newCamper - the camper to be enrolled in the camp
   */
  public void enrollCamper(Camper newCamper) {

    // Assigns the camper their correct cabin
    if (newCamper.getAge() == 8 || newCamper.getAge() == 9) {
      newCamper.assignCabin(CABIN_NAMES[0]);
    }

    if (newCamper.getAge() == 10 || newCamper.getAge() == 11 || newCamper.getAge() == 12) {
      newCamper.assignCabin(CABIN_NAMES[1]);
    }

    if (newCamper.getAge() == 13 || newCamper.getAge() == 14) {
      newCamper.assignCabin(CABIN_NAMES[2]);
    }

    // Calls BST insert method on the camper
    campers.insert(newCamper);
  }

  
  /**
   * "Unenrolls" a camper by removing them from the tree.
   * 
   * @param delCamper - the camper to be deleted from the tree
   * @throws java.util.NoSuchElementException - in the CamperBST class, which this method calls
   */
  public void unenrollCamper(Camper delCamper) throws java.util.NoSuchElementException {

    // Calls BST delete method on camper
    campers.delete(delCamper);

  }

  /**
   * Traverses the tree in the designated order by calling it through the CamperBST class.
   * 
   * @param order - the type of traversal for the tree to perform
   * @return java.util.Iterator<Camper> - the Iterator of Campers from CampBST.traverse()
   */
  public java.util.Iterator<Camper> traverse(java.lang.String order) {

    // Calls BST traverse method on the order parameter
    return campers.traverse(order);
  }
  
}