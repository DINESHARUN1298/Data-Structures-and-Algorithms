package dev.dinesh.stub;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

    public static void populateUserLogOnInfo() {
        File file = new File("E://userlogoninfo.csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter outputFile = new FileWriter(file);

            // create CSVWriter object file writer object as parameter
            CSVWriter writer = new CSVWriter(outputFile);

            // adding header to csv
            String[] header = { "RECORD_ID", "USER_RESOURCE_ID", "COMPUTER_RESOURCE_ID", "LOGON_TIME", "LOGOFF_TIME", "LOGON_TIME_COMPONENT", "LOGOFF_TIME_COMPONENT" };
            writer.writeNext(header);

            // add data to csv
            for(int index = 1; index <= 20000000; index++) {
                String[] data = new String[7];
                for(int subIndex = 0; subIndex < 7; subIndex++) {

                    if(subIndex == 0) {
                        data[subIndex] = String.valueOf(index);
                    }

                    if(subIndex == 1) {
                        data[subIndex] = String.valueOf(3);
                    }

                    if(subIndex == 2) {
                        data[subIndex] = String.valueOf(363);
                    }

                    if(subIndex == 3 || subIndex == 4) {
                        data[subIndex] = String.valueOf(1611995773212L);
                    }

                    if(subIndex == 5 || subIndex == 6) {
                        data[subIndex] = String.valueOf(996);
                    }

                }
                writer.writeNext(data);
            }

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("Hi Donnie!");

        populateUserLogOnInfo();

        System.out.println("Bye Donnie!");

    }

}