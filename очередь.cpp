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

class Queue {
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
            Element* neededElement = first;
            if (neededElement -> next != nullptr) {
                first = neededElement -> next;
                first -> previous = nullptr;
            } else {
                first = nullptr;
                last = nullptr;
            }
            
            count--;
            delete(neededElement);
        }
    }
    
    Element* peek() {
        if (first != nullptr) {
            return first;
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
    Queue queue = Queue();
    
    for (int i = 3; i < 9; i++) {
        queue.push(i);
    }
    
    queue.show(); 
    cout << queue.peek() -> value << endl;
    
    queue.show(); 
    
    queue.pop();
    queue.show(); 
    
}

