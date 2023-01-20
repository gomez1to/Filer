import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FunFiles {
    //attributes

    Scanner myScanner = new Scanner(System.in);

    boolean addToFile = false;
    boolean overwriteFile = false;
    //constructor
    public FunFiles() {
        findFiles();
        createFile();
        //writeToFile();
        readFile();
        namePerson();
        addOrOverwrite();

    }

    public ArrayList<String> persons = new ArrayList<String>(); //creating Arraylist used later in methods
    File myFile = new File("TBT");

    //methods
    /*
    finds all files in a specified path
     */
    public void findFiles() {
        File myPath = new File("C:\\Users\\gomezmorales.jan\\Documents");
        String[] allFiles = myPath.list();

        //cycles through a list of files and folders to print them
        for (String fileNames : allFiles) {
            System.out.println(fileNames);
        }
    }

    /*
    create a file if it doesn't already exist
     */
    public void createFile() {
        File myFile = new File("test.txt");
        try {
            if (myFile.createNewFile()) {
                System.out.println("created ez");
            } else {
                System.out.println("no can do");
            }
        } catch (IOException e) {
            System.out.println("no no no");
            e.printStackTrace();
        }
    }


    /*
    method to write in file
     */

    public void addOrOverwrite(){
        //frågar om man vill lägga till något till filen eller skriva över
        System.out.println("Do you want to add test to the file or overwrite it? (1: add, 2: overwrite)");

        //Läser av svaret och avgör om den ska lägga till något eller skriva över
        String ans = myScanner.next();
        if (ans.equals("1")){
            writeToFile(true);
        }
        else if (ans.equals("2")){
            writeToFile(false);

        }
        //om man inte svarat 1 eller 2 så skriver programet ut dethär:
        else{
            System.out.println("You need to select add or overwrite");
            addOrOverwrite();
        }
    }
    public void writeToFile(boolean shouldAppend) {
        try {
            //Filewriter will append the data in the file
            FileWriter myWriter = new FileWriter("test.txt", shouldAppend);
            System.out.println("pls write");
            String text = myScanner.nextLine();
            myWriter.write(text);
            myWriter.close();
            System.out.println("message written");


        } catch (IOException e) {
            System.out.println("Can't do this bish");
            e.printStackTrace();
        }
    }


    /*
    Read data from a given file
     */
    public void readFile() {
        File myFile = new File("test.txt");
        try {
            Scanner myScan = new Scanner(myFile);
            while (myScan.hasNextLine()) {
                String data = myScan.nextLine();
                System.out.println(data);
            }

            myScan.close();
        } catch (FileNotFoundException e) {
            System.out.println("can not do this shit");
            e.printStackTrace();
        }
    }

    //saves person in list
    public void namePerson() {
        for (String person : persons) {
            try {
                FileWriter myWriter = new FileWriter("persons.txt");
                myWriter.write(person + "/n");
                myWriter.close();
            } catch (IOException e) {
                System.out.println("not possible to write");
                e.printStackTrace();
            }
        }
        System.out.println("You wrote to the file:D.");
    }

    //finds the longest world in the file
   /* public String findLongest() {
        String longestWord = "";
        String current;
        try {
            Scanner sc = new Scanner("words.txt");

            //while scaner still can, compare current with longest yet.
            while (sc.hasNext()) {
                current = sc.next();
                if (current.length() > longestWord.length()) {
                    longestWord = current;
                }

            }
            System.out.println("\n"+longestWord+"\n");
        }
        catch (Exception e){
            System.out.println("No");
        }
        return longestWord;
    }
*/
}