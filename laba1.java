package com.company;
import  java.util.Scanner;



class Main {
    private static Person[] array;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Привет! Давайте создадим объекты. СКолько вы хотите их создать? Введите число");
        int personCount = sc.nextInt();
        array = new Person[personCount];
        System.out.println(array.length);
        for(int i = 0; i < personCount; i++) {
            System.out.println("Создаем номер человека" + (i+1));
            array[i] = new Person();
            array[i].createPerson();
        }
        System.out.println("Вывожу информацию обо всех пользователях: ");
        for(int i = 0; i < personCount; i++) {
            array[i].aboutPerson();
        }
        System.out.println("Мы создали пользователей! Что мы будем с ними делать? 1-Изменить номер телефона любого из людей, 2-Сравнить людей по имени, 3-Выход");
        int randomChoice = sc.nextInt();
        switch (randomChoice){
            case 1:
                System.out.println("Вы выбрали изменить номер телефона одного из людей. Чей номер будем менять? Введи номер этого человека: ");
                int ManChoice = sc.nextInt();
                switch(ManChoice){
                    case 1:
                        System.out.println("Вы выбрали "+ ManChoice +"-го человека, а точнее "+array[ManChoice-1].name + ". Введи новый номер: ");
                        String newNumber = sc.next();
                        array[ManChoice-1].numberPhoneChanger(newNumber);
                        System.out.println("Новые данные: ");
                        array[ManChoice-1].aboutPerson();
                        break;
                    case 2:
                        System.out.println("Вы выбрали "+ ManChoice +"-го человека, а точнее "+array[ManChoice-1].name + ". Введи новый номер: ");
                        String newNumber2 = sc.next();
                        array[ManChoice-1].numberPhoneChanger(newNumber2);
                        System.out.println("Новые данные: ");
                        array[ManChoice-1].aboutPerson();
                        break;
                    case 3:
                        System.out.println("Вы выбрали "+ ManChoice +"-го человека, а точнее "+array[ManChoice-1].name + ". Введи новый номер: ");
                        String newNumber3 = sc.next();
                        array[ManChoice-1].numberPhoneChanger(newNumber3);
                        System.out.println("Новые данные: ");
                        array[ManChoice-1].aboutPerson();
                        break;
                    case 4:
                        System.out.println("Вы выбрали "+ ManChoice +"-го человека, а точнее "+array[ManChoice-1].name + ". Введи новый номер: ");
                        String newNumber4 = sc.next();
                        array[ManChoice-1].numberPhoneChanger(newNumber4);
                        System.out.println("Новые данные: ");
                        array[ManChoice-1].aboutPerson();
                        break;
                    default:
                        break;
                }
            case 2:
                System.out.println("Вы выбрали сравнение по именам. Кого будем сравнивать? Введи номер этого человека: ");
                int parametr = sc.nextInt();
                System.out.println("Теперь выберите с кем будем сравнивать. Так же укажи номер челика: ");
                int parametr2 = sc.nextInt();
                if(array[parametr-1].equalss(array[parametr2-1])){
                    System.out.println("Имена одинаковы");
                }else{
                    System.out.println("Имена разные");
                }
                break;
            case 3: break;
        }
    }
}


class Person{
    String name;
    int age;
    String phone;
    String numberPhone;
    Person(){
        this.name = "none";
        this.age = 0;
        this.phone = "none";
        this.numberPhone = "none";
    }
    Person(String name, int age, String phone, String numberPhone){
        this.name = name;
        this.age =age;
        this.phone = phone;
        this.numberPhone = numberPhone;
    }
    public void numberPhoneChanger(String number){
        this.numberPhone = number;

    }
    void createPerson(){
        Scanner scc = new Scanner(System.in);
        System.out.println("Создадим нового человека");
        System.out.println("Введите имя: ");
        String name = scc.next();
        this.name = name;
        System.out.println("Введите возраст: ");
        int age = scc.nextInt();
        this.age = age;
        System.out.println("Введите модель телефона: ");
        String modelPhone = scc.next();
        this.phone = modelPhone;
        //while(checkNum() == false){
        System.out.println("Введите номер телефона: ");
        String numbrePhone = scc.next();
        this.numberPhone = numbrePhone;

    }
    public boolean checkNum() {
        if ((this.numberPhone.length() == 12) && (this.numberPhone.substring(0,1)).equals("+")) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }
    void aboutPerson(){
        System.out.println("Имя: " + this.name +","+"Возраст: " + this.age + ","+"Модель телефона: " + this.phone + ","+"Номер телефона: " + this.numberPhone);
    }
    boolean equalss(Person person){
        if(this.name.equals(person.name)){

            return true;
        }else{

            return false;
        }
    }
}