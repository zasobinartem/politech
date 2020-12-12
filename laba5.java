package com.company;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;




class Main6 {
    public static String reverseText(String str){
        char[] charArray = str.toCharArray();
        String line = " ";
        for (int i = charArray.length - 1; i >= 0; i--){
            line += charArray[i];
        }
        return line;
    }

    public static void main(String[] args) {

        String firstFile = "first.txt";
        String secondFile = "second.txt";
        String noTextF1 = "";
        String noTextF2 = "";

        Scanner sc = new Scanner(System.in);


        File f1 = new File(firstFile);
        File f2 = new File(secondFile);

        try {

            Scanner openF1 = new Scanner(f1);
            Scanner openF2 = new Scanner(f2);

            while(openF1.hasNextLine()){
                noTextF1+=openF1.nextLine();
            }

            while(openF2.hasNextLine()){
                noTextF2+=openF2.nextLine();
            }

            PrintWriter pwrite = new PrintWriter(f2);
            pwrite.print(reverseText(noTextF1));

            PrintWriter second = new PrintWriter(f1);
            second.print(reverseText(noTextF2));

            pwrite.close();
            second.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }



}
