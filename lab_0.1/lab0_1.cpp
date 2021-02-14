#include <iostream>
#include "lab0_1_lib.h"

using namespace std;

int main(){
    cout << "Choose...\n";
    cout << "a) 6 times 'a'    b) everything is simple\n";
    cout << "c) don't choose   q) quit\n";
    char choice;
    while (cin >> choice && choice != 'q'){
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