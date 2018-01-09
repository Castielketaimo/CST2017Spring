#pragma once
#include "Foo.h"

// Question 1 Bar.h
class Bar : public Foo
{
public:
	Bar(int x);
	virtual ~Bar();
	int GetX() const;
};
