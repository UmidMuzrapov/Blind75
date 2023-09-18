## Intuition
We could use a map to story groups of anagrams. If {ate, eat, tea} is one group and value in a map, what could be they key? The key could be a sorted word -> aet. Once we are done mapping, map values contain all possible anagram groups.

## Pseudocode
  String -> string => anagramDict
      for word in strs
        copy word => copy
        sor copy
        if anagramDict jas key copy:
            add to the bucket.
        else
            create bucket
            add to the bucket

## Analysis 
Runtime: O(Nklogk) where is N is size of input and k the largest anagram group.
Size: O(N) 

