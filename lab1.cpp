#include <iostream>
#include "lab1_lib.h"

using namespace std;

int main(){
    cout << "Choose...\n";
    cout << "a) 6 times 'a'    b) everything is simple\n";
    cout << "c) don't choose   e) exit\n";
    char choice;
    while (cin >> choice && choice != 'e'){
        switch (choice){
            case 'a':
            case 'A': choice_a();
                break;
            case 'b':
            case 'B': choice_b();
                break;
            case 'c':
            case 'C': chioce_c();
                break;
            default: cout << "Choose a, b, c or q!\n";
        }
    }
}