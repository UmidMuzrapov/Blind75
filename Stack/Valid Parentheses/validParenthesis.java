class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        String bracketsO = "({[";

        for (char character: s.toCharArray()){
            if (character == ' ') return false;
            if (bracketsO.contains(String.valueOf(character))){
                stack.push(character);
            } else {
                if(stack.empty()){
                    return false;
                } else {
                    char lastCharacter = stack.peek();
                    if ((lastCharacter=='(' && character == ')') ||
                     (lastCharacter=='[' && character == ']')
                     || (lastCharacter=='{' && character == '}')){
                         stack.pop();
                     } else {
                         return false;
                     }
                }
            }
        }

        return stack.empty();
    }
}
