#include <iostream>
using namespace std;

//Class Declaration
class vehicle_class
{
	long int price;
	string varient;   
	
	public:
		int release_year;
		string brand;
		string model;	
		double speed;
	
	/* Default Constructor*/
	vehicle_class(){
		cout<<"Default Constructor inside Class" << endl;
	}
	
	/*Destructur*/
	~vehicle_class(){
		cout<<"Destructor inside Class" << endl;
	}
	
	void set_price(long int value){
		price = value;
	}
	
	long int get_price(){
		return price;
	}
	
	void set_varient(string type){
		varient = type;
	}
	string get_varient(){
		return varient;	
	}
};


int main(){
	
	vehicle_class v1;          
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