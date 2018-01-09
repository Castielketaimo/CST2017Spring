#pragma once
// Question 14 B.h
#include <iostream>
class B
{
	virtual void method() { std::cout << "              from Base" << std::endl; }

public:
	virtual ~B() { method(); }
	void baseMethod() { method(); }
};
