Tech 1:
- The big O of tech 1 is 0(n^2)
- I used a double nested loop for the implementation. I make the second string shorter and shorter every time it 
  Finds a match at first string. Then the length of second string to 0
- It took 34 secs to run

Tech 2:
- The big O of tech 1 is 0(nlogn)
- I used bubble sort method to sort both array and compared them at the end
- It took 23 secs to run

Tech 3:
- The big O of tech 1 is 0(n)
- I create an int array have size of 128 have initial value of 0s. Increase the index that matchs each char AXCII
  in the first array and decrease the indexs mach AXCII table. In the end I check if the whole array only contains 0s.
- It took 12 secs to run