package com.practice.coding;

/*
 ref - https://jg.gg/the-unqualified-engineer-episode-01/
 
The problem here can be stated pretty simply. Imagine that you need a 
function that can take two inputs: 1) a list of integers and 2) 
another list of integers. The first list could be thousands of 
integers long. It can contain positive and negative numbers. It’s not
 sorted in any way. Any integer could be at any position. The second 
 list is similar except that it’s equal in length to the first list 
 or shorter.

What we want to do with these lists is find where in the first list 
we could substitute the second list, integer for integer, that would 
 create the least amount of change in each integer from the original 
 list. For this problem, we consider change to be measured in number 
 line distance (i.e. absolute value). So, you can’t use some negative 
 distance to offset some positive distance. If you substitute -2 for 
 2, that’s a change of 4.

An example would be something like this:

original =    [1, 2, 3, 4, 5]
replacement = [3, 5, 3] 
In this example, the “disruption” created by each possible 
substitution looks like this:

0th position swapping
 0  1  2  3  4
---------------
[1, 2, 3, 4, 5]
[3, 5, 3] 
 2, 3, 0 -- total disruption of 5

1st position swapping
 0  1  2  3  4
---------------
[1, 2, 3, 4, 5]
   [3, 5, 3] 
    1, 2, 1 -- total disruption of 4

2nd position swapping
 0  1  2  3  4
---------------
[1, 2, 3, 4, 5]
      [3, 5, 3] 
       0, 1, 2 -- total disruption of 3
You can see from this, that the best replacement choice here would be
 the 2nd index, which would create a subrange disruption of just 3, 
 compared to all the other options.*/

/*
 * @author Ganesh Shinde
 */

public class LeastDisruptiveSubrange {

	public int getLeastDisruptiveSubrangeIndex(final int[] original, final int[] replacement) {
		if (original.length < replacement.length) {
			return -1;
		}
		int totalDisruption;
		int leastDisruption = Integer.MAX_VALUE;
		int leastDisruptionIndex = -1;

		for (int originalIndex = 0; originalIndex <= original.length - replacement.length; originalIndex++) {
			totalDisruption = 0;
			for (int replacementIndex = 0; replacementIndex < replacement.length; replacementIndex++) {
				totalDisruption += Math.abs(original[originalIndex + replacementIndex] - replacement[replacementIndex]);
			}
			if (leastDisruption > totalDisruption) {
				leastDisruption = totalDisruption;
				leastDisruptionIndex = originalIndex;
			}
		}
		return leastDisruptionIndex;
	}

}
