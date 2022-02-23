#include <stdio.h>
#include <string.h>

int isIdentifier(char str[])
{
    int state = 0, j = 0, input;
    int table[4][3] = {{1,3,2},{1,1,3},{1,1,3},{}};
    
    while(str[j] != '\0')
	{
        if((str[j] >= 'a' && str[j] <= 'z') || (str[j] >= 'A' && str[j] <= 'Z'))	//letter
            input = 0;
        else if((str[j] >= '0' && str[j] <= '9'))	//digit
            input = 1;
        else if(str[j] >= '_')	//_
            input = 2;
    
	    state = table[state][input];
	    j++;
    
	    if(state == 1)
			break;        
    }
    
    return state; //Valid state is 1
}

int isInteger(char str[])
{
    int state = 0, j = 0, input;
    int table[4][2] = {{1,2},{3,2},{1,2},{3,3}};
    
    while(str[j] != '\0')
	{ 
        if(str[j] == '+' || str[j] == '-')	//operation
            input = 0;
        else if((str[j] >= '0' && str[j] <= '9'))	//digit
            input = 1;
    
	    state = table[state][input];
	    j++;
	    
   		if(state == 3) 
		   break;
    }
    
    return state;	//Valid state is 2
}

int isFloatOrRNum(char str[])
{
    int state = 0, j = 0, input;
    int table[4][3] = {{1,2,3},{3,2,3},{1,2,1},{3,3,3}};
    
    while(str[j] != '\0')
	{
		if(str[j] == '+' || str[j] == '-')	//sign
			input = 0;
		else if((str[j] >= '0' && str[j] <= '9'))	//digit
            input = 1; 
        else if(str[j] == '.')// dot
            input = 2;
    
	    state = table[state][input];
	    j++;
	    
    	if(state == 2)
			break;
    }
    
    return state; // Valid state is 2
}

/*int assign(char input[])
{
	int i, flag, assigned, identifier;
	char a[80];	//identifier
	char b[80];	//assign
	
	flag = assigned = identifier = 0;
	
	for(i = 0; i < n; i++)
	{
		if(input[i] = ' ')	//space
			continue;
		
		if(input[i] = '=')
		{
			flag = 1;
			continue;
		}
		
		if(flag == 0)
		{
			a[identifier] = input[i];
			identifier++;
		}
		else
		{
			b[assigned] = input[i];
			assigned++;
		}
		
		fflush(stdin);
	}
	
	printf("%s\n", a);
	printf("%s\n", b);
}*/

int input()
{	
	char string[50];
	
	printf("Input string: ");
	gets(string);

}

int main()
{
	int choice = 1;	
		
	while(choice != 0)
	{
		input();
		printf("\n\n");
		printf("Do you want to try another string? (1|0): ");
		scanf("%d", &choice);
		printf("\n\n");
	}
	
   /*// Extract the first token
   char * token = strtok(string, " = ");
   
   while(token != NULL)
	{
		printf( " %s\n", token ); //printing the token
		token = strtok(NULL, " = ");
	}
   
   return 0;*/
}
