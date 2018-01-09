#pragma once
// Question 5 QFive.h
class QFive
{
public:
	QFive();
	virtual ~QFive();
	virtual void DoSomething();

	int GetX();

protected:
	static int mX;
};
