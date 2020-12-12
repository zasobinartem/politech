package com.company;
import java.text.DecimalFormat;
import java.util.Scanner;

class Main7 {
    private static final String[] tensAndMore = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] nums = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    public static void main(String[] args) {
        System.out.println("Введите число");
        Scanner sc = new Scanner(System.in);
        long ourNumber = sc.nextLong();

        System.out.println( convert(ourNumber));
    }

    public static String convertLessThanOneThousand(int number) {
        String num;
        if (number % 100 < 20){
            num = nums[number % 100];
            number /= 100;
        } else {
            num = nums[number % 10];
            number /= 10;

            num = tensAndMore[number % 10] + num;
            number /= 10;
        }
        if (number == 0) return num;
        return nums[number] + " hundred" + num;
    }

    public static String convert(long number) {

        if (number == 0) { return "zero"; }

        String snumber = Long.toString(number);


        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);


        int billions = Integer.parseInt(snumber.substring(0,3));

        int millions  = Integer.parseInt(snumber.substring(3,6));

        int hundredThousands = Integer.parseInt(snumber.substring(6,9));

        int thousands = Integer.parseInt(snumber.substring(9,12));

        String billionNum;
        switch (billions) {
            case 0:
                billionNum = "";
                break;
            case 1 :
                billionNum = convertLessThanOneThousand(billions) + " billion ";
                break;
            default :
                billionNum = convertLessThanOneThousand(billions) + " billion ";
        }
        String result =  billionNum;

        String millionNum;
        switch (millions) {
            case 0:
                millionNum = "";
                break;
            case 1 :
                millionNum = convertLessThanOneThousand(millions) + " million ";
                break;
            default :
                millionNum = convertLessThanOneThousand(millions)
                        + " million ";
        }
        result += millionNum;

        String oneHundredThousandNum;
        switch (hundredThousands) {
            case 0:
                oneHundredThousandNum = "";
                break;
            case 1 :
                oneHundredThousandNum = "one thousand ";
                break;
            default :
                oneHundredThousandNum = convertLessThanOneThousand(hundredThousands) + " thousand ";
        }
        result += oneHundredThousandNum;

        String thousandNum;
        thousandNum = convertLessThanOneThousand(thousands);
        result += thousandNum;

        // remove extra spaces!
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }
}