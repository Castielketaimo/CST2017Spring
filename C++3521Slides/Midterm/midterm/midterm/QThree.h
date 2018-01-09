#pragma once
// Question 3 QThree

class QThree
{
public:
	QThree(int x);
	virtual ~QThree();
	QThree operator+(const QThree& other);

	// for output
	int GetX();

private:
	int mX;
};
