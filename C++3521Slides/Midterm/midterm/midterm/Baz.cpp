// Question 1 Baz.cpp
#include "Baz.h"

Baz::Baz(int x)
	: Foo(x)
{
}

Baz::~Baz()
{
}

int Baz::GetX() const
{
	return *mX * 2;
}
