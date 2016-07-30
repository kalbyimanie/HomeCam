/*
@author craptalk_a.k.a_Kalby_Imanie
@github http://github.com/craptlk/talkycalculator
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

//additional
int add(int x,int y){
		int result;
		result = x+y;
		return result;
}

//division
int division(int x, int y){
	int result;
	result = x/y;
	return result;
}

//substraction
int sub(int x, int y){
	int result;
	result = x-y;
	return result;
}

//multiplication
int mul(int x, int y){
	int result;
	result = x*y;
	return result;
}

int main(){
	int x,y;
	int hasil;
	int count;
	int i=0;
	char choice[10];

	printf("\n\n\n\n|=============================|\n");
	printf("|=============================|\n");
	printf("|=============================|\n");
	printf("|=============================|\n");
	printf("|Welcome to Awesome Calculator|\n");
	printf("|=============================|\n");
	printf("|=============================|\n");
	printf("|=============================|\n\n\n");

    do{
		printf("Please choose your type ['add'] | ['sub'] | ['div'] | ['mul']:");
		scanf("%s",choice);fflush(stdin);		
	}while(strcasecmp(choice, "add") && strcasecmp(choice, "sub") && strcasecmp(choice, "mul") && strcasecmp(choice, "div")!= 0);

		printf("How many times you will calculate :");
		scanf("%d",&count);fflush(stdin);
		
		for(i; i<count;i++){
			if(strcmp(choice,"add") == 0){
				printf("Enter your first number:");
				scanf("%d",&x);fflush(stdin);
				printf("Enter your second number:");
				scanf("%d",&y);fflush(stdin);
				hasil = add(x,y);	
				printf("Your result is: %d\n",hasil);
			}else if(strcasecmp(choice,"sub") == 0){
				printf("Enter your first number:");
				scanf("%d",&x);fflush(stdin);
				printf("Enter your second number:");
				scanf("%d",&y);fflush(stdin);
				hasil = sub(x,y);	
				printf("Your result is: %d\n",hasil);
			}else if(strcasecmp(choice,"div") == 0){
				printf("Enter your first number:");
				scanf("%d",&x);fflush(stdin);
				printf("Enter your second number:");
				scanf("%d",&y);fflush(stdin);
				hasil = division(x,y);	
				printf("Your result is: %d\n",hasil);
			}else if(strcasecmp(choice,"mul") == 0){
				printf("Enter your first number: ");
				scanf("%d",&x);fflush(stdin);
				printf("Enter your second number: ");
				scanf("%d",&y);fflush(stdin);
				hasil = mul(x,y);	
				printf("\n\nYour result is: %d\n",hasil);
			}else{
				printf("Error\n");
			}
		}
		printf("\nYou already used this Calculator for %d times\n\n",count);
		printf("\nThank you for using this Awesome Calculator (:>D) \n");
		printf("\n\n\nSee you again!\n");		

getchar();
return 0;
}