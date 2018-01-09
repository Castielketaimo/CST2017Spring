// Question 5 QFive.cpp
#include "QFive.h"

int QFive::mX = 0;

QFive::QFive()
{
}

QFive::~QFive()
{
}

void QFive::DoSomething()
{
	mX++;
}

int QFive::GetX()
{
	return mX;
}
