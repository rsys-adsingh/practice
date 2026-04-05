#include <iostream>
using namespace std;

//Class Declaration
class vehicle_class
{
	long int price;
	string varient;   //base,mid,top
	
	public:
		int release_year;
		string brand;
		string model;	
		double speed;
	
	/* Default Constructor inside Class*/
	/*Constructors can be made private. This means that no external code can directly create an object of that class.
	  If no constructor is specified, C++ compiler generates a default constructor for object by itself
	  We can have more than one constructor in a class. It is called Constructor Overloading.*/
	vehicle_class(){
		cout<<"Default Constructor inside Class" << endl;
	}
	
	/*Destructur*/
	/*it cannot be declared static or const.
	  Automatically called when an object goes out of scope and release the memory.
	  We can't have more than one destructor in a class.
	*/
	~vehicle_class(){
		cout<<"Destructor inside Class" << endl;
	}
	
	void set_price(long int value){
		price = value;
	}
	
	long int get_price(){
		return price;
	}
	
	/*declaring prototype of member function and define outside class using scope resolution operator */
	void set_varient(string type);
	string get_varient();  
};

	void vehicle_class::set_varient(string type){
		varient = type;
	}
	string vehicle_class::get_varient(){
		return varient;
	}

int main(){
	
	vehicle_class v1;     /*Object of vehicle_class and constructor gets called automatically as soon as the object of the class is declared*/     
	vehicle_class v2;     v2.release_year = 2021, v2.brand = "BMW", v2.model= "R8",  v2.speed = 185.5; 
	
	cout << "Brand:" << v2.brand << "  Model:" << v2.model << "  Launched in:" << v2.release_year << "  with top Speed of:" << v2.speed << endl; 
	v2.set_price(2300000);
	v2.set_varient("Base");
	cout << "Price is:" << v2.get_price() << " for " << v2.get_varient() << " Varient" << endl;
	
	                      
	return 0;
}









/*
Class                                                          Structure

Members of a class are private by default.                     Members of a structure are public by default.
It is normally used for data abstraction and inheritance.      It is normally used for the grouping of different datatypes.
*/