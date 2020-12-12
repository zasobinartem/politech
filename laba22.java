package com.company;

class Main2 {

    public static void main(String[] args) {

        Vampire vampire = new Vampire();
        vampire.completeArray();

    }
}

class Vampire{
    Vampire(){
    }
    int arrayOfThousands[] = new int[10000];
    int a[] = new int[12];
    int numOfThousands, numOfHundreds, numOfDozens, numOfUnits;

    void completeArray(){
        for(int i = 1000, j = 0; i < 10000; i++, j++) {

            arrayOfThousands[j] = i;
        }
        for (int x : arrayOfThousands) {
            int numberOfNulls = 0;
            numOfThousands = x / 1000;
            numOfHundreds = (x - 1000*numOfThousands)/100;
            numOfDozens = (x - 1000*numOfThousands - 100*numOfHundreds)/10;
            numOfUnits = x - 1000*numOfThousands - 100*numOfHundreds - 10*numOfDozens;

            if (numOfHundreds == 0){
                numberOfNulls++;
            }

            if (numOfDozens == 0) {
                numberOfNulls++;

            }

            if (numOfUnits == 0) {
                numberOfNulls++;

            }

            if (numberOfNulls > 1){
                continue;
            } else {
                a[0]=(numOfUnits*10+numOfDozens)*(numOfHundreds*10+numOfThousands);
                a[1]=(numOfUnits*10+numOfDozens)*(numOfThousands*10+numOfHundreds);
                a[2]=(numOfDozens*10+numOfUnits)*(numOfHundreds*10+numOfThousands);
                a[3]=(numOfDozens*10+numOfUnits)*(numOfThousands*10+numOfHundreds);
                a[4]=(numOfUnits*10+numOfHundreds)*(numOfDozens*10+numOfThousands);
                a[5]=(numOfUnits*10+numOfHundreds)*(numOfThousands*10+numOfDozens);
                a[6]=(numOfHundreds*10+numOfUnits)*(numOfDozens*10+numOfThousands);
                a[7]=(numOfHundreds*10+numOfUnits)*(numOfThousands*10+numOfDozens);
                a[8]=(numOfUnits*10+numOfThousands)*(numOfDozens*10+numOfHundreds);
                a[9]=(numOfUnits*10+numOfThousands)*(numOfHundreds*10+numOfDozens);
                a[10]=(numOfThousands*10+numOfUnits)*(numOfDozens*10+numOfHundreds);
                a[11]=(numOfThousands*10+numOfUnits)*(numOfHundreds*10+numOfDozens);

                if(x==a[0]||x==a[1]||x==a[2]||x==a[3]||x==a[4]||x==a[5]||x==a[6]||x==a[7]||x==a[8]||x==a[9]||x==a[10]||x==a[11]){
                    System.out.println(x);
                }
            }
        }
    }
}