## Intuition 
Go over characters. If it is an opening bracket, add it to the stack. If it is a closing bracket, pop from the stack. After going over characters, check is stack is empty. If there was a closing bracket for each opening bracket, stack should be empty.

## Analysis
Space: O(1)
Time: O(n)