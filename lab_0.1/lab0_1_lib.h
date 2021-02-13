#include <iostream>

void choice_a(void);
void choice_b(void);
void choice_c(void);

void choice_a(){
    for (int i = 0; i < 6; i++){
        std::cout << i + 1 << ". a.\n";
    }
}

void choice_b(){
    std::cout << "Your choice is b.\n";
}

void chioce_c(){
    std::cout << "Never choose c, please.\n";
}