// ConsoleApplication1.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include <iostream>
using namespace std;

class Display {
public:
    Display(int type) {
        this->type = type;
    }

    Display() {}
private:
    int type = 0;
};

class Resolution {
public:
    Resolution(int weight, int height) {
        this->weight = weight;
        this->height = height;
    }

    Resolution() {}
private:
    int weight, height = 0;
};

class Size {
public:
    Size(int inches) {
        this->inches = inches;
    }

    Size () {}

private:
    int inches = 0;
};


class TV {
public:
    TV(Display display, Resolution resolution, Size size) {
        this->display = display;
        this->resolution = resolution;
        this->size = size;
    }

     TV() {}

private:
    Display display;
    Resolution resolution;
    Size size;
};



int main(int argc, const char* argv[]) {

}
