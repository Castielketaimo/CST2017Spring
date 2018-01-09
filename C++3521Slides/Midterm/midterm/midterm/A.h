#pragma once
#include "B.h"

class A : public B
{
	void method() { std::cout << "              from A" << std::endl; }
public:
	~A() { method(); }
};