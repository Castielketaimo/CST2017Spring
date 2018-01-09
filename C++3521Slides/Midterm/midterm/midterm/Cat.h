#pragma once
// Question 8 Cat.h
#include <iostream>
#include "Animal.h"

class Animal;
class Cat : public Animal
{
	// Question 8b answer
	friend std::ostream& operator<<(std::ostream& os, const Cat& c)
	{
		return os << "I am cat named " << c.mName;
	}

public:
	Cat(const char* name);
	~Cat();
	void PrintName() const;
};
