## My original solution

### Intuition

e.g. [3, 2, 4], target = 6

Create a list that contains a tuple of value and index => list
{{3, 0}, {2, 1}, {4, 2}}

Sort list by value
{{2,1}, {3, 0}, {4, 2}}

Using left and right pointers, find the two values whose sum is equal to the target and return their indices.
{1, 2}

### Analysis
Time complexity: O(NlogN)
Space complexity: O(N)


## Secondary Solution

### Intuition
Initialize dictorionary of values and indices -> elementIndex;
When we are going over elements, we could find the difference between the element and target => target
Check if elementIndex map has it. If so, we are done. The result is {current element's index, index from the dictionary}
It is also important to mention that we should be put an entry in the map only after visiting the values. The reason is to avoid 
the visiting the element itself twice if doubling the current element would be equal to the target.

### Pseudocode
map<Integer, Integer> => elementToIndex;
for elem in nums
	target - elem => difference
	if difference in elementToIndex:
		return {index of elem, elementToIndex [difference]}		
	put (elem, elem index) in elementToIndex
 
### Analysis
Time complexity: O(N)
Space complexity: O(N)
