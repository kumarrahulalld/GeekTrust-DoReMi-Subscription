package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Runner runner=new Runner();
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                String inputLine= sc.nextLine();
                String[] inputs=inputLine.split(" ");
                if(inputs[0].equals("START_SUBSCRIPTION"))
                {
                    runner.startSubscription(inputs[1]);
                }
                else if(inputs[0].equals("ADD_SUBSCRIPTION"))
                {
                    runner.addSubscription(inputs[1],inputs[2]);
                }
                else if(inputs[0].equals("ADD_TOPUP"))
                {
                    runner.addTopUp(inputs[1],Integer.parseInt(inputs[2]));
                }
                else if(inputs[0].equals("PRINT_RENEWAL_DETAILS"))
                    runner.printRenewalDetails();
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("EXCEPTION_OCCURRED");
        }
    }
}
