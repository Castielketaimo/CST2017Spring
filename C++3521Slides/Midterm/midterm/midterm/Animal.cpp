// Question 8 Animal.cpp
#include "Animal.h"
Animal::Animal(const char* name)
	: mName(name)
{
}
Animal::~Animal()
{
	// error
	//delete mName;
}
