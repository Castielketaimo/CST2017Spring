#pragma once
#include <iostream>

class C
{
public:
	int mData[2];
	C(int x, int y) { mData[0] = x, mData[1] = y; }
	virtual void f() {}
};
