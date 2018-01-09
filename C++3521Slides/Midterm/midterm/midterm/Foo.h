#pragma once
// Question 1 Foo.h

class Foo
{
public:
	Foo(int x);
	virtual ~Foo();
	virtual int GetX() const = 0;

protected:
	int* mX;
};

