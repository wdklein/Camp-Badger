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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class models the application in which campers are enrolled, unenrolled, a list is printed
 * out of all the campers, and the statistics of the number of campers is printed. This is the
 * driver for the program, reading the commands from a .txt file and using all the other classes to
 * execute them. This catches a NoSuchElementException thrown in CamperBST.java and an
 * IllegalArgumentException thrown in Camper.java
 * 
 * @author Willie Klein (wdklein)
 *
 */
public class CampEnrollmentApp {

  /**
   * Driver for the program
   * 
   * @param args
   * @throws IOException - if the file that fileLines reads is not found
   */
  public static void main(String[] args) throws IOException {

    CampManager manager = new CampManager();
    List<String> fileLines = Files.readAllLines(Paths.get("sim.txt"));

    // Handles each line of the .txt file one at a time
    for (int i = 0; i < fileLines.size(); i++) {

      // Splits line based on a single space
      String[] splitArr = fileLines.get(i).split(" ");

      // Handles the Statistics command
      if (splitArr[0].equals("S")) {
        System.out.println("--- Camp Statistics ---");
        System.out.print("Number of Campers: ");
        manager.printStatistics();
        System.out.println("-----------------------");
      }

      // Handles Enroll command
      // Catches IllegalArgumentException if the campers age is not valid
      if (splitArr[0].equals("E")) {
        try {
          manager.enrollCamper(new Camper(splitArr[1], splitArr[2], Integer.parseInt(splitArr[3])));
          System.out.println("Enrollment of " + splitArr[2] + " " + splitArr[1] + " Successful!");
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());

        }
      }

      // Handles Unenroll command
      // Catches a NoSuchElementException if the camper is not at camp
      if (splitArr[0].equals("R")) {
        try {
          manager.unenrollCamper(new Camper(splitArr[1], splitArr[2], 10));
          System.out.println("Unenrollment of " + splitArr[2] + " " + splitArr[1] + " Successful!");
        }

        catch (NoSuchElementException e) {
          System.out.println(e.getMessage());
        }
      }

      // HandlesTraverse command
      if (splitArr[0].equals("T")) {

        // Stores the iterator as a variable to use in each while loop
        Iterator<Camper> itr = manager.traverse(splitArr[1]);

        // INORDER traversal
        if (splitArr[1].equals("INORDER")) {
          System.out.println("--- INORDER Traversal ---");

          while (itr.hasNext()) {
            System.out.println(itr.next());
          }
        }

        // PREORDER traversal
        if (splitArr[1].equals("PREORDER")) {
          System.out.println("--- PREORDER Traversal ---");

          while (itr.hasNext()) {
            System.out.println(itr.next());
          }
        }

        // POSTORDER traversal
        if (splitArr[1].equals("POSTORDER")) {
          System.out.println("--- POSTORDER Traversal ---");

          while (itr.hasNext()) {
            System.out.println(itr.next());
          }
        }
        System.out.println("--------------------------");
      }
    }
  }
}