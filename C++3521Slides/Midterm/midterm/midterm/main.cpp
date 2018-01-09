#include <iostream>
#include <iomanip>
#include <string>
#include <bitset>

// Question 1 imports
#include "Foo.h"
#include "Bar.h"
#include "Baz.h"

// Question 3 imports
#include "QThree.h"

// Question 5 imports
#include "QFive.h"
#include "SubFive.h"

// Question 8 imports
#include "Cat.h"

// Question 10 imports
#include "Dog.h"

// Question 12 imports
#include "Vector.h"

// Question 14 imports
#include "B.h"
#include "A.h"

// Question 16 imports
#include "C.h"

using namespace std;

// Question 6 function
void Swap(int& x, int& y)
{
	int tmp = x;
	x = y;
	y = tmp;
}

// Question 7 function
string MirrorString(const string& str)
{
	string mirrorStr;

	for (int i = str.length() - 1; i >= 0; --i)
	{
		mirrorStr += str[i];
	}
	return mirrorStr;
}

int main()
{
	// Question 1
	cout << "Question 1:   ";
	Foo* f = new Bar(5);
	Foo* f2 = new Baz(5);
	cout << f->GetX() + f2->GetX() << endl;
	// End of Question 1

	// Question 2
	cout << "Question 2:   ";
	std::cout << std::setw(15) << std::setfill('-') << std::internal << "Hello World" << endl;
	// End of Question 2

	// Question 3
	cout << "Question 3:   ";
	QThree t1(2);
	QThree t2(3);
	QThree sum = t1 + t2;
	cout << sum.GetX() << endl;
	// End of Question 3

	// Question 4
	cout << "Question 4:   ";
	float* x = new float(12.456f);
	int* y = reinterpret_cast<int*>(x);
	float* z = reinterpret_cast<float*>(y);
	std::cout << *z << std::endl;
	// End of Question 4

	// Question 5
	cout << "Question 5:   ";
	QFive* q5_1 = new QFive();
	QFive* q5_2 = new SubFive();
	q5_1->DoSomething();
	cout << q5_1->GetX() << " and ";
	q5_2->DoSomething();
	cout << q5_2->GetX() << endl;
	// End of Question 5

	// Question 6
	cout << "Question 6:   ";
	int a = 14;
	int b = 3;
	swap(a, b);
	std::cout << a << std::endl;
	// End of Question 6

	// Question 7
	cout << "Question 7:   ";
	string line = "What";
	line += "up";
	line += MirrorString(line) + "bro";
	cout << line << endl;
	// End of Question 7

	// Question 8
	// a
	cout << "Question 8a:  ";
	Cat* cat = new Cat("Kitty");
	Cat cat2(*cat);
	delete cat;
	//cat2.PrintName();
	cout << "Error happened in Animal destructor" << endl;
	// end of a
	// b
	cout << "Question 8b:  ";
	Cat cat3("Kitty");
	std::cout << cat3 << " (Check Cat.h)" << std::endl;
	// end of b
	// End of Question 8

	// Question 9
	// a
	cout << "Question 9a:  ";
	float m = 3.f;
	int n = static_cast<int>(m);
	cout << bitset<4>(n) << endl;
	// end of a
	// b
	cout << "Question 9b:  ";
	int o = 1;
	float* p = reinterpret_cast<float*>(&o);
	cout << "0001.0000" << endl;

	// Question 10
	cout << "Question 10:  ";
	Dog* dog1 = new Dog();
	Dog* dog2 = new Dog();
	std::cout << dog2->GetCount() << std::endl;
	// End of Qusetion 10

	// Question 11
	// a
	cout << "Question 11a: ";
	std::string str1("Java");
	std::string str2("Java");
	bool bEqual1 = (str1 == str2);
	cout << bEqual1 << endl;
	// end of a
	// b
	cout << "Question 11b: ";
	bool bEqual2 = (str1.c_str() == str2.c_str());
	cout << bEqual2 << endl;
	// end of b
	// End of Question 11

	// Question 12
	// a
	cout << "Question 12a: ";
	Vector v1;
	v1.mX = 1;
	v1.mY = 2;
	Vector v2 = v1 * 2;
	std::cout << v2.mX << std::endl;
	// end of a
	// b
	cout << "Question 12b: ";
	Vector v3;
	v3.mX = 1;
	v3.mY = 2;
	Vector v4 = v3 / 2.f;
	std::cout << v4.mY << std::endl;
	// end of b
	// End of Question 12

	// Question 13
	// when sz goes under 0, it actually represents it as positive maxmium number
	//size_t sz = 1; 
	cout << "Question 13:  ";
	int sz = 1;
	while (--sz >= 0)
	{
		/* do something */
		cout << "Change size_t to int" << endl;
	}
	// End of Question 13

	// Question 14
	cout << "Question 14:" << endl;
	B* base = new A();
	base->baseMethod();
	delete base;
	// End of Question 14

	// Question 15
	cout << "Question 15:  ";
	cout << "Needs virtual for destructor" << endl;
	// End of Question 15

	// Question 16
	cout << "Question 16:  ";
	C c(10, 20);
	int* arr = (int*)&c;
	std::cout << arr[2] << std::endl;
	// End of Question 16


	cout << endl;
	system("pause");
	return 0;
}

