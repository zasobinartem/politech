package com.company;

class Main3 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Barks[] value = Barks.values();
        for(Barks bark : value){
            System.out.println(bark);
        }

    }
}

class Dog{
    String name;
    String color;
    int age;
    Dog(String name, String color, int age){
        this.name = name;
        this.color = color;
        this.age = age;
    }
    Dog(String name, String color){
        this(name, color, 0);
    }
    Dog(String name, int age){
        this(name,"browwn", age);
    }
    Dog(int age){
        this("sharik", "white", age);
    }
    Dog(){
        this("marsik", "black", 5);
    }

    void bark(){
        System.out.println("Bark-Bark");
    }

    void bark(String s){
        System.out.println(s);
    }
    void bark(Barks var){
        switch (var){
            case BARK:
                bark();
                break;
            case WOOF:
                bark("WAF-Waf wafff");
                break;
            case AUUF:
                bark("auuuufuufuf");
                break;
            case YAM:
                bark("Ummmmm....");
                break;
        }
    }
}
enum Barks{
    BARK, WOOF, AUUF, YAM
}