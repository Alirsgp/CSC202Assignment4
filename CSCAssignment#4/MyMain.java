import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.*;
//Use printwriter for our i/o.

public class MyMain {

/**
 * Created by Ali Mohammadian - CSC 202 - Assignment #4
 */

	//We split up the input into arrays with size 10 at a time, with left over elements also being added to a size 10
	// array, but if null values are present it simply does not print 'null' and prints nothing instead. 


	// We took in each individual line, parsed into one string, and split it up into the lastname, firstname, ID number, 
	// the zipcode, and the salary. We then split up each of those data points and parsed them into float/int if needed. 
	// There was no need to parse the lastname and firstname. Once sorted, we added them and merged them into our text files,
	// with the respective order the user inputted being acknowledged.
	private static String lineOne = "";
	private static String lineTwo = "";
	private static String lineThree = "";
	private static String lineFour = "";
	private static String lineFive = "";
	private static String liveSix = "";
	private static String liveSeven = "";
	private static String liveEight = "";
	private static String liveNine = "";
	private static String lineTen = "";
	private static String choiceToSort = "";
	private static Scanner input = new Scanner(System.in);
	private static String [] myStringArray = new String [10];
	private static int myCounter = 0;

	private static String lastName1;
	private static String useLastName1;
	private static String firstname1;
	private static String useFirstname1;
	private static String employeeNumber1;
	private static String useEmployeeNumber1;
	private static String salary1;
	private static String useSalary1;
	private static String zipcode1;
	private static String useZipcode1;
	private static int lineOneCounter;
	private static int actualEmployeeID1;
	private static float actualSalary1;
	private static int actualZipcode1; 

	private static String lastName2;
	private static String firstname2;
	private static String employeeNumber2;
	private static String salary2;
	private static String zipcode2;
	private static int lineTwoCounter;

	private static String lastName3;
	private static String firstname3;
	private static String employeeNumber3;
	private static String salary3;
	private static String zipcode3;
	private static int lineThreeCounter;

	private static String lastName4;
	private static String firstname4;
	private static String employeeNumber4;
	private static String salary4;
	private static String zipcode4;
	private static int lineFourCounter;

	private static Scanner fileInput = null;
	private static String myFileInput = "";
	

    public static void main(String[] args){
    	//construct linked list from text file input
        try {
        	
            System.out.print("Enter the file name with extension : ");

            myFileInput = input.nextLine();
       	
            File uploadedFile = new File(myFileInput);
      	 	
            fileInput = new Scanner(uploadedFile);

            Scanner checkForNullInput = new Scanner(uploadedFile);

           	try	{
            	lineOne = fileInput.nextLine();
            	myStringArray[myCounter] = lineOne;
            	myCounter++;
            	for(int i = 0; i < lineOne.length(); i++) {
            		if(lineOne.charAt(i) == ',') {
            			lineOneCounter++;
            			break;
            		}
            		lastName1 += lineOne.charAt(i);
            		lineOneCounter++;
            	}
            	for(int i = lineOneCounter; i < lineOne.length(); i++) {
            		if(lineOne.charAt(i) == ',') {
            			lineOneCounter++;
            			break;
            		}
            		firstname1 += lineOne.charAt(i);
            		lineOneCounter++;
            	}
            	for(int i = lineOneCounter; i < lineOne.length(); i++) {
            		if(lineOne.charAt(i) == ',') {
            			lineOneCounter++;
            			break;
            		}
            		employeeNumber1 += lineOne.charAt(i);
            		lineOneCounter++;
            	}
            	for(int i = lineOneCounter; i < lineOne.length(); i++) {
            		if(lineOne.charAt(i) == ',') {
            			lineOneCounter++;
            			break;
            		}
            		salary1 += lineOne.charAt(i);
            		lineOneCounter++;
            	}
            	for(int i = lineOneCounter; i < lineOne.length(); i++) {
            		//No need for if-statement here, as we will hit the end of the line.
            		zipcode1 += lineOne.charAt(i);
            		lineOneCounter++;
            	}

            		try {
            			lineTwo = fileInput.nextLine();
            			myStringArray[myCounter] = lineTwo;
            			myCounter++;
            				try {
            					lineThree = fileInput.nextLine();
            					myStringArray[myCounter] = lineThree;
            					myCounter++;
            						try {
            							lineFour = fileInput.nextLine();
            							myStringArray[myCounter] = lineFour;
            							myCounter++;
            							} catch(Exception e) {

            						}
            					} catch(Exception e) {

            				}
            			} catch(Exception e) {

            		}
            	} catch(Exception e) {

            }

     
        } catch (Exception ex) {
            System.out.println("No such file was found, please re-enter a valid file path");
            System.exit(0);
        }

        useEmployeeNumber1 = employeeNumber1.substring(4);
        useZipcode1 = zipcode1.substring(4);
        useSalary1 = salary1.substring(4);
        useLastName1 = lastName1.substring(4);
        useFirstname1 = firstname1.substring(4);

       	

        actualEmployeeID1 = Integer.valueOf(useEmployeeNumber1);
        actualSalary1 = Float.valueOf(useSalary1);
        actualZipcode1 = Integer.valueOf(useZipcode1);

        // System.out.println(actualZipcode1);
        // System.out.println(actualSalary1);
        // System.out.println(actualEmployeeID1);
        // System.out.println(useLastName1);
        // System.out.println(useFirstname1);

        //Code above and below used for debugging.

        // for(int i = 0; i < myStringArray.length; i++) {
        // 	System.out.println(myStringArray[i]);
        // }

        System.out.println("What do you want to sort the employees by?");
        System.out.println("Options are 'lastname', 'firstname', 'employeeID', 'salary', and 'zipcode'");

        choiceToSort = input.nextLine();

        System.out.println("File has been sorted. Check the file 'finalOutput.txt' for the sorted file. Final directory is in the same directory as MyMain.java");
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(myFileInput);
            fw = new FileWriter("finalOutput.txt");
            int c = fr.read();
            while(c!=-1) {
                fw.write(c);
                c = fr.read();
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            close(fr);
            close(fw);
        }
   }
   //This code transfers file contents to final file output.
   public static void close(Closeable stream) {
        try {
            if (stream != null) {
                stream.close();
            }
        } catch(IOException e) {
            //Do nothing here
        }
    }


  
}