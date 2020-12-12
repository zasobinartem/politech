package com.company;
import java.util.Scanner;

class Main4 {

    public static void main(String[] args) {

        Money m1 = new Money(MoneyTypes.USD, "США");
        System.out.println("Валютой из "+m1.country+" является " + m1.type);

        switch(m1.type){
            case RUB:
                System.out.println("Рубль");
                break;
            case EUR:
                System.out.println("Евро");
                break;
            case USD:
                System.out.println("Доллар");
                break;
            case CNY:
                System.out.println("Юань");
                break;
            case BRL:
                System.out.println("Реал");
                break;
            case MXN:
                System.out.println("Песо");

        }

    }
}

class Money{


    String country;
    MoneyTypes type;

    Money(MoneyTypes type, String country){

        this.type = type;
        this.country = country;

    }
}


enum MoneyTypes {
    RUB, USD, EUR, CNY, BRL , MXN

}

