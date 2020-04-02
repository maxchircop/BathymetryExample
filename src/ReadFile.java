/**
 * Created by Maximilian Chircop.
 * Date: 03/30/2020
 * Brief: Program processes GEBCO data
 */

import java.io.*;
import java.util.*;

public class ReadFile {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("\nTEST PROGRAM:\n");
        String small = "GEBCO_174bytes/gebco_2019_n40.005_s40.0_w-57.22_e-57.215.asc";
        String medium = "GEBCO_980kb/gebco_2019_n26.0_s25.0_w-22.0_e-21.0.asc";
        String large = "GEBCO_4mb/gebco_2019_n27.0_s25.0_w-22.0_e-20.0.asc";
        String extraLarge = "GEBCO_24mb/gebco_2019_n20.0_s15.0_w135.0_e140.0.asc";
        String extraExtraLarge = "GEBCO_885mb/gebco_2019_n90.0_s-90.0_w-45.0_e-40.0.asc";
        String comparison = "GEBCO_Comparison/gebco_2019_n30.0_s25.0_w130.0_e135.0.asc";

        Scanner kb = new Scanner(System.in);

        System.out.println("Choose a data set");
        System.out.println("1-174 bytes\n2-980 kb\n3-4 mb\n4-24 mb\n5-885 mb\n6-Comparison");
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
        else if(option==6){
            chosenFile=comparison;

        }
        else{

        }

        double returnLatitude = 0;
        double returnLongitude = 0;
        double returnDepth = 0;
        System.out.println("Enter a Latitude");
        double enteredLatitude = kb.nextDouble();
        System.out.println("Enter a Longitude");
        double enteredLongitude = kb.nextDouble();


        System.out.println("Processing...");


        //make here down its own method.... but that's a future problem

        File file = new File(chosenFile);//change this to try different files
        Scanner inputFile = new Scanner(file);
        
        LinkedList dataList = new LinkedList();

        Data data;

        double latitude = 25; // starting xcorner, currently set to file medium
        double longitude = -22;// starting ycorner, currently set to file medium
        double cellSize = 0.004166666667 ;
        double depth=0; //initializing

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
            if(latitude < enteredLatitude){
                returnLatitude=latitude;
                returnDepth=depth;
            }
            if(latitude > enteredLatitude){
                returnLatitude=latitude;
            }
        }

        inputFile.close();

        System.out.println(returnDepth);


        //dataList.enumerate(); // is currently printing backwards

    }// end of main

    public String findDepth(double lat, double lon,LinkedList list){
        Data data = new Data(0, 0, 0);
        for (int i = 0; i < list.size(); i++) {
        }

        return "";
    }
}
