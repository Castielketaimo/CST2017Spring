// Question 1 Bar.cpp
#include "Bar.h"

Bar::Bar(int x)
	: Foo(x)
{
}

Bar::~Bar()
{
}

int Bar::GetX() const
{
	return *mX;
}
