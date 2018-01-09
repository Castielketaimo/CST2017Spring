// Question 1 Foo.cpp
#include "Foo.h"

Foo::Foo(int x)
{
	mX = new int(x);
}

Foo::~Foo()
{
	delete mX;
}
