#pragma once
#include "Foo.h"

// Question 1 Baz.h
class Baz : public Foo
{
public:
	Baz(int x);
	virtual ~Baz();
	int GetX() const;
};