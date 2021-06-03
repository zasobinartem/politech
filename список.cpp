#include <iostream>
using namespace std;

class Element {
public:
    int value = 0;
    Element* next = NULL;
    Element* previous = NULL;
    
    Element(int value) {
        this -> value = value;
    }
};

class List {
public:
    int count = 0;
    Element* first = NULL;
    Element* last = NULL;
    
    int length() {
        return count;
    }
    
    void add(int value) {
        Element* elem = new Element(value);
        
        if (first == NULL) {
            first = elem;
            last = elem;
        } else {
            last -> next = elem;
            elem -> previous = last;
            last = elem;
        }
        
        count++;
    }
    
    Element* getAtIndex(int index) {
        if (index < count && index >= 0) {
            int counter = 0;
            Element* nowElement = first;
            
            while (counter != index) {
                nowElement = nowElement -> next;
                counter++;
            }
            
            return nowElement;
        }
        
        exit(1);
    }
    
    void deleteAtIndex(int index) {
        if (index < count) {
            Element* neededElement = getAtIndex(index);
            Element* next = neededElement -> next;
            
            if (index != 0) {
                neededElement -> previous -> next = next;
            } else {
                first = next;
            }
            
            if (index == count - 1) {
                last = neededElement -> previous;
            }
            
            count--;
            delete(neededElement);
        }
    }
    
    void show() {
        int counter = 0;
        if (first != nullptr) {
            Element* nowElement = first;
            
            while (counter != count) {
                cout << counter << ": " << nowElement -> value << " ";
                nowElement = nowElement -> next;
                counter++;
            }
            
            cout << endl;
        }
    }
    
};

int main(){
    List list = List();
   
    for (int i = 3; i < 9; i++) {
        list.add(i);
    }
    
    list.show(); 
    
    list.deleteAtIndex(0);
    list.show(); 
    
    cout << list.getAtIndex(1) -> value << endl; 
}
