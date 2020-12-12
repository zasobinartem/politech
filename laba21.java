package com.company;
import java.util.Scanner;

class Main1 {
    public static void main(String[] args) {
      for(int i = 1; i <= 5; i++){
          switch(i){
              case 1:
                  System.out.println("Секция номер: "+i);
              case 2:
                  System.out.println("Секция номер: "+i);
              case 3:
                  System.out.println("Секция номер: "+i);
              case 4:
                  System.out.println("Секция номер: "+i);
              case 5:
                  System.out.println("Секция номер: "+i);
          }
      }
        myFib number = new myFib();
        number.fib(10);


    }
}

class myFib{

    myFib()
    {

    }

    Scanner sc = new Scanner(System.in);
    public int [] array;

    void fib(int x){
        int [] arr = new int[x];
        arr[0]=1;
        arr[1]=1;

        for (int i = 2; i < arr.length; ++i){
            arr[i] = arr[i-1] + arr[i-2];

        }

        for (int i = 0; i< arr.length; i++){
            System.out.println(arr[i]);
        }




    }

}
