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

class Stack {
public:
    int count = 0;
    Element* first = NULL;
    Element* last = NULL;
    
    int length() {
        return count;
    }
    
    void push(int value) {
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
    
    
    void pop() {
        if (count > 0) {
            Element* neededElement = last;
            if (neededElement -> previous != nullptr) {
                last = neededElement -> previous;
                last -> next = nullptr;
            } else {
                first = nullptr;
                last = nullptr;
            }
            
            count--;
            delete(neededElement);
        }
    }
    
    Element* peek() {
        if (last != nullptr) {
            return last;
        }
        
        return NULL;
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
    Stack stack = Stack();
    
    stack.pop();
    
    for (int i = 3; i < 9; i++) {
        stack.push(i);
    }
    
    stack.show(); 
    cout << stack.peek() -> value << endl; 
    
    stack.show(); 
    
    stack.pop();
    stack.show(); 
    
}
