package com.example.geektrust;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Runner runner=new Runner(new HashMap<>(),null,null);
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                String inputLine = sc.nextLine();
                String[] inputs = inputLine.split(" ");
                switch (inputs[0]) {
                    case "START_SUBSCRIPTION":
                        runner.startSubscription(inputs[1]);
                        break;
                    case "ADD_SUBSCRIPTION":
                        runner.addSubscription(inputs[1], inputs[2]);
                        break;
                    case "ADD_TOPUP":
                        runner.addTopUp(inputs[1], Integer.parseInt(inputs[2]));
                        break;
                    case"PRINT_RENEWAL_DETAILS":
                        runner.printRenewalDetails();
                        break;
                }
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("EXCEPTION_OCCURRED");
        }
    }
}
