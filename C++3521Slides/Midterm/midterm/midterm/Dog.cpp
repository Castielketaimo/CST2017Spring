// Question 10 Dog.cpp
#include "Dog.h"

int Dog::mCount = 11;
Dog::Dog()
{
	mCount++;
}

int Dog::GetCount() const
{
	return mCount / 3;
}
