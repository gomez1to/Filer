import java.io.File;
import java.io.IOError;
import java.io.IOException;

public class FunFiles {


    //constructor
    public FunFiles(){
        //findFiles();
        createFile();
    }

    //methods
    /*
    finds all files in a specified path
     */
    public void findFiles(){
        File myPath = new File ("C:\\Users\\gomezmorales.jan\\Documents");
        String [] allFiles= myPath.list();

        //cycles through a list of files and folders to print them
        for (String fileNames: allFiles){
            System.out.println(fileNames);
        }
    }

    /*
    create a file if it doesn't already exist
     */
    public void createFile(){
        File myFile = new File("test.txt");
        try {
            if (myFile.createNewFile()){
                System.out.println("created ez");
            }else{
                System.out.println("no can do");
            }
        }catch(IOException e){
            System.out.println("no no no");
            e.printStackTrace();
        }
    }

}
