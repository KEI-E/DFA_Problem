#include <stdio.h>

int isIdentifier(char str[]){
    int state = 0, j = 0, input = 0;
    int table[3][4] = {{1,1,2,2},{1,1,1,2},{2,2,2,2}};
    
    while(str[j] != '\0'){
        
        
        if(str[j] == '_') //underscore
            input = 0;
        else if((str[j] >= 'a' && str[j] <= 'z') || (str[j] >= 'A' && str[j] <= 'Z')) // alphabet
            input = 1;
        else if((str[j] >= '0' && str[j] <= '9')) // digit
            input = 2;
        else 
            input = 3; // others
    
    state = table[state][input];
    j++;
    if(state == 2)break;        
    }
    return state == 1; // valid or not
}

int isInteger(char str[]){
    int state = 0, j = 0, input = 0;
    int table[4][3] = {{1,3,2},{2,3,2},{2,2,2},{2,3,2}};
    
    while(str[j] != '\0'){ 
    
        if(str[j] == '+' || str[j] == '-') //sign
            input = 0;
        else if((str[j] >= '0' && str[j] <= '9')) //digit
            input = 1;
        else 
            input = 2; // others
    
    state = table[state][input];
    j++;
    if(state == 3) break;
    }
    return state == 1;
}

int isFloatReal(char str[]){
    int state = 0, j = 0, input = 0;
    int table[6][4] = {{4,3,1,5},{2,5,1,5},{5,5,2,5},{4,5,1,5},{5,5,2,5},{5,5,5,5}};
    
    while(str[j] != '\0'){
    
        if(str[j] == '.')// dot
            input = 0;
        else if(str[j] == '+' || str[j] == '-') // sign
            input = 1;
        else if((str[j] >= '0' && str[j] <= '9')) // digit
            input = 2; 
        else
            input = 3; // others
    
    state = table[state][input];
    j++;
    if(state == 1 || state == 2)break;
    }
    return state = 1; // valid or not
}
