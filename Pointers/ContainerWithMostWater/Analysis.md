## Intuition
The question falls under pointer pattern. Place one pointer to the left and the second one to the right. Calculate the area and update max area if necessary.
Next, if left height is less than the right height, to achieve the max height, we need to move left pointer to right by one. If the opposite is true,
move the right pointer to left by one.

## Analysis 
Time: O(n)
Space: O(1)
