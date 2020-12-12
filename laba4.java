package com.company;


import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Мы в отеле. Отель незаселен. В нём может остановиться 25 человек. Введите число гостей:");
        int sizeOfArray = sc.nextInt();
        if (sizeOfArray > 25){
            System.out.println("Вы ввели число больще 25. В отеле нет мест.");
            sizeOfArray = 25;
        }
        ArrayList<User> users = new ArrayList<>();
        int k =0;
        int n =0;
        System.out.println("Давайте заполним информацию о госте: ");
        while (n != sizeOfArray){
            System.out.println("Введи имя "+(k+1)+" гостя: ");
            String name  = sc.next();
            if(users.isEmpty()){
                System.out.println("Введи возраст "+(k+1)+" гостя: ");
                int age = sc.nextInt();
                int id = k+1;

                users.add(new User(name, age, id));

                System.out.println(users.size());
                n++;
                k++;
                addguest (users.get(0));
                continue;
            }
            for (Iterator<User> it = users.iterator(); it.hasNext(); ) {
                User user = it.next();
                if (!user.nameOfUser.equals(name)){

                    System.out.println("Введи возраст "+(k+1)+" гостя: ");
                    int age = sc.nextInt();
                    int id = k+1;

                    users.add(new User(name, age, id));

                    addguest (users.get(k));
                    n++;
                    k++;
                }else{
                    addguest(user);
                }
            }
        }

        for (int i = 0; i< users.size(); i++){
            System.out.println("Все гости: ");
            users.get(i).printInfoAboutUser();
        }
        boolean choice = true;
        while (choice){
            System.out.println("Мы заселили отель ! Что вы хотите теперь? 1-Показать информацию о госте, 2-Удалить гостя, 3-заселить в номер другого гостя, 4 - Выйти");
            int num = sc.nextInt();
            switch (num) {
                case 1:

                    System.out.println("Вы выбрали показать информацию о конкретном госте. Введи номер гостя:");
                    int numOfUser = sc.nextInt();

                    users.get(numOfUser - 1).printInfoAboutUser();
                    break;
                case 2:
                    System.out.println("Вы выбрали удалить гостя. Введи Id гостя: ");
                    int numOfDeletedCar = sc.nextInt();

                    users.remove(numOfDeletedCar-1);


                    for (int i = 0; i < users.size(); i++) {

                        users.get(i).printInfoAboutUser();

                    }
                    break;
                case 3:
                    System.out.println("Вы выбрали заселить в номер другого гостя. Введи id гостя");
                    int numOfNewOwner = sc.nextInt();

                    System.out.println(" Введи новое имя гостя и его возраст: ");
                    users.get(numOfNewOwner-1).nameOfUser = sc.next();
                    users.get(numOfNewOwner-1).number = sc.nextInt();

                    System.out.println("Вот и обновленная информация: ");

                    users.get(numOfNewOwner-1).printInfoAboutUser();

                    break;
                case 4:
                    choice = false;
                    break;
            }
        }
    }
    public static void addguest(User user){
        Scanner sc = new Scanner(System.in);

        System.out.println(user.nameOfUser);
        System.out.println("Введи информацию о госте: ");
        System.out.println("Имя: ");
        String name = sc.next();
        System.out.println("Страна: ");
        String country = sc.next();
        System.out.println("Дата заезда: ");
        int date = sc.nextInt();
        System.out.println("Возраст: ");
        int age = sc.nextInt();
        user.guestroom.add(new guest(name, country , date, age));
    }
}

class guest{
    String name;
    String country;
    int date;
    int age;
    guest (){
        name = "NoName";
        country = "NoModel";
        date = 0;
        age = 0;
    }
    guest (String name, String model, int cost, int weight){
        this.name =  name;
        this.country =  model;
        this.date = cost;
        this.age = weight;

    }
    guest (String name, int cost, int weight){
        this.name =  name;
        this.date =  cost;
        this.age = weight;
    }

    public void printInfo(){
        System.out.println("Имя: "+name);
        System.out.println("Страна: "+country);
        System.out.println("Дата заезда: "+date);
        System.out.println("Возраст: "+age);
    }
}

class User{
    ArrayList<guest>  guestroom;
    String nameOfUser;
    int number;
    User(){
        guestroom = new ArrayList<>();
        nameOfUser = "NoName";
        number = 20;
    }
    User(String name, int age, int id){
        this.nameOfUser = name;
        this.number = id;
        this.guestroom = new ArrayList<>();
    }
    User(guest guest, String name, int age, int id){
        this.nameOfUser = name;
        this.number = id;
        this.guestroom.add(guest);
    }
    public void printInfoAboutUser(){
        System.out.println("------------------------");
        System.out.println("Номер комнаты: "+number);
        for (guest c: guestroom) {
            System.out.println("Имя: " + c.name);
            System.out.println("Страна: " + c.country);
            System.out.println("Дата заезда: " + c.date);
            System.out.println("Возраст: " + c.age);
            System.out.println("------------------------");
        }
    }

}