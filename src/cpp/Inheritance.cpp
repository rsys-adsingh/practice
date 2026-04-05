#include <iostream>
using namespace std;

//Class Declaration
class vehicle_class
{
	long int price;   	
	public:
		int release_year;
		string brand;
		string model;	
		double speed;
	
	/* Default Constructor*/
	vehicle_class(){
		cout<<"Default Constructor Base Class" << endl;
	}	
	/*Destructur*/
	~vehicle_class(){
		cout<<"Destructor Base Class" << endl;
	}	
	void set_price(long int value){ price = value; }	
	long int get_price(){ return price; }
};

/*Inheritance*/
class car : public vehicle_class {
	string varient;
	public:
		int gears;

	void set_varient(string type){ varient = type; }
	string get_varient(){ return varient; }
	/* Default Constructor*/
	car(){
		cout<<"Default Constructor CAR Child Class" << endl;
	}
	/*Destructur*/
	~car(){
		cout<<"Destructor CAR Child Class" << endl;
	}
};

/*Multilevel Inheritance :   vehicle -> car -> sports_car*/
class sports_car : private car {
	int cylinders;
	public :
	void set_cylinders(int value){ cylinders = value; }
	int get_cylinders(){ return cylinders; }
	void get_varient() { sports_car::get_varient(); }
	void get_price() {vehicle_class::get_price(); }
	/* Default Constructor*/
	sports_car(){
		cout<<"Default Constructor SPORTS CAR Child Class" << endl;
	}
	/*Destructur*/
	~sports_car(){
		cout<<"Destructor SPORTS CAR Child Class" << endl;
	}
};


class flying_feature {
	long int max_height;
	public:
		int wings;
		int chamber;
	void set_height(long int height) { max_height = height; }
	long int get_height() { return max_height; }
	/* Default Constructor*/
	flying_feature(){
		cout<<"Default Constructor FLY base Class" << endl;
	}
	/*Destructur*/
	~flying_feature(){
		cout<<"Destructor FLY base Class" << endl;
	}
	/* friend class can access private and protected members of other classes in which it is declared as a friend*/
	friend class aeroplane;
};

/*Multiple Inheritance :   vehicle,flying_feature -> Aeroplane*/
class aeroplane : public vehicle_class , private flying_feature {
	public:
		int number_of_engine;
	
	/*Accessing the Private member of friend*/	
	void set_height(flying_feature& f, long int h){ f.max_height = h;}
	/* Default Constructor*/
	aeroplane(){
		cout<<"Default Constructor Aeroplane Child Class" << endl;
	}
	/*Destructur*/
	~aeroplane(){
		cout<<"Destructor Aeroplane Child Class" << endl;
	}
};

int main(){
	
	vehicle_class v1;   // Object of Base class         
	car v2;            //Object of Child Class will call Constructor and Destructor of both Base and Child Class
	sports_car v3;       
	v2.release_year = 2021, v2.brand = "BMW", v2.model= "R8",  v2.speed = 185.5;  
	
	cout << "Brand:" << v2.brand << "  Model:" << v2.model << "  Launched in:" << v2.release_year << "  with top Speed of:" << v2.speed << endl; 
	v2.set_price(2300000);
	v2.set_varient("Base");
	cout << "Price is:" << v2.get_price() << " for " << v2.get_varient() << " Varient" << endl;
	
	flying_feature f;
	aeroplane a1; 
	a1.set_height(f,10000);
	cout << "Accessing the Private member using Friend class object:" << f.get_height() << endl;                     
	return 0;
}

