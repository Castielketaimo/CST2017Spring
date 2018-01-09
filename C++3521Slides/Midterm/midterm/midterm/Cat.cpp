// Question 8 Cat.cpp
#include "Cat.h"
#include <iostream>
Cat::Cat(const char* name)
	: Animal(name)
{
}
Cat::~Cat()
{
}
void Cat::PrintName() const
{
	std::cout << "I'm a cat named " << mName << std::endl;
}
