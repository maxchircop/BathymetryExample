/**
 * Created by Maximilian Chircop.
 * Date: 03/30/2020
 * Brief: Program that reads in files of generic types
 */

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class ReadFile {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\nTEST PROGRAM:\n");
        String small = "GEBCO_174bytes/gebco_2019_n40.005_s40.0_w-57.22_e-57.215.asc";
        String medium = "GEBCO_980kb/gebco_2019_n26.0_s25.0_w-22.0_e-21.0.asc";
        String large = "GEBCO_4mb/gebco_2019_n27.0_s25.0_w-22.0_e-20.0.asc";
        String extraLarge = "GEBCO_24mb/gebco_2019_n20.0_s15.0_w135.0_e140.0.asc";
        String extraExtraLarge = "GEBCO_885mb/gebco_2019_n90.0_s-90.0_w-45.0_e-40.0.asc";

        Scanner kb = new Scanner(System.in);

        System.out.println("Choose a data set");
        System.out.println("1-174 bytes\n2-980 kb\n3-4 mb\n4-24 mb\n5-885 mb");
        String chosenFile = null;
        int option = kb.nextInt();

        if(option==1){
            chosenFile=small;
        }
        else if(option==2){
            chosenFile=medium;
        }
        else if(option==3){
            chosenFile=large;
        }
        else if(option==4){
            chosenFile=extraLarge;
        }
        else if(option==5){
            chosenFile=extraExtraLarge;
        }
        else{

        }

        System.out.println("Processing...");

        File file = new File(chosenFile);//change this to try different files
        Scanner inputFile = new Scanner(file);
        
        LinkedList dataList = new LinkedList();

        Data data;
        double latitude = -22; // starting xcorner, currently set to file medium
        double longitude = 25;// starting ycorner, currently set to file medium
        double cellSize = 0.004166666667 ;
        double depth=0; //initializing

        int gridCount=0;
        inputFile.nextLine();
        inputFile.nextLine();
        inputFile.nextLine();
        inputFile.nextLine();
        inputFile.nextLine();
        inputFile.nextLine();


        while (inputFile.hasNext()) {
            depth = inputFile.nextDouble();

            data = new Data(latitude, longitude, depth);
            dataList.add(data);
            latitude += cellSize;
            longitude += cellSize;
        }

        inputFile.close();

        dataList.enumerate(); // is currently printing backwards

        /**
        try {
            File inputFile = new File(medium);
            Scanner fileReader = new Scanner(inputFile);

            if (inputFile.exists()) {
                System.out.println("File name: " + inputFile.getName());
                System.out.println("Absolute path: " + inputFile.getAbsolutePath());
                System.out.println("Writeable: " + inputFile.canWrite());
                System.out.println("Readable " + inputFile.canRead());
                System.out.println("File size in bytes " + inputFile.length());
            } else {
                System.out.println("The file does not exist.");
            }
            System.out.println("File contents:\n\n");

            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                System.out.println(data);
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }*/

    }// end of main
}
