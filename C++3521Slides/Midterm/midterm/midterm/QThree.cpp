// Question 3 QThree.cpp
#include "QThree.h"

QThree::QThree(int x)
	: mX(x)
{
}

QThree::~QThree()
{
}

QThree QThree::operator+(const QThree& other)
{
	int x = (mX + other.mX) * 2;
	QThree temp(x);
	return temp;
}

int QThree::GetX()
{
	return mX;
}
