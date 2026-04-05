#include <iostream>
using namespace std;

//Structure Declaration
struct vehicle_structure
{
	int release_year;
	string brand;
	string model;	
	double speed;
	
	private:
		long int price;
	
	public:
	void set_price(long int value){
		price = value;
	}
	
	long int get_price(){
		return price;
	}
};


int main(){
	
	vehicle_structure v1;     /*Structure Initialization*/  vehicle_structure v_arr[10];   /*Array of structure */   
	vehicle_structure v2;     v2.release_year = 2021, v2.brand = "BMW", v2.model= "R8",  v2.speed = 185.5; 
	
	cout << "Brand:" << v2.brand << "  Model:" << v2.model << "  Launched in:" << v2.release_year << "  with top Speed of:" << v2.speed << endl; 
	v2.set_price(2300000);
	cout << "Price is:" << v2.get_price() << endl;
	                      
	return 0;
}

/*
Both in C and C++, members of the structure have public visibility by default.

C Structures                                                                             C++ Structures

Only data members are allowed, it cannot have member functions.	                         Can hold both: member functions and data members.
Cannot have static members.	                                                             Can have static members.
Cannot have a constructor inside a structure.	                                         Constructor creation is allowed.
Direct Initialization of data members is not possible.	                                 Direct Initialization of data members is possible.
Writing the ‘struct’ keyword is necessary to declare structure-type variables.	         Writing the ‘struct’ keyword is not necessary to declare structure-type variables.
Do not have access modifiers.	                                                         Supports access modifiers.
Only pointers to structs are allowed.	                                                 Can have both pointers and references to the struct.
Sizeof operator will generate 0  for an empty structure.	                             Sizeof operator will generate 1 for an empty structure.
Data Hiding is not possible.	                                                         Data Hiding is possible.

*/