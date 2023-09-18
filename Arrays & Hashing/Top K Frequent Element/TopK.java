
class Solution 
{
    /*
        Brute force

        go over each element:
            find the element with the highest frequency.

        O(kN).
        1 1 1 1 
        map number to its (freque, elem)
        for each element:
            if (element map)
                map[element]+=1;
            else
                put element, frequency

    */
    public int[] topKFrequent(int[] nums, int k) 
    {

        HashMap<Integer, List<Integer>> elementToFrequency= new HashMap<Integer, List<Integer>>();

        for (int element: nums)
        {
            List<Integer> frequency;
            if (elementToFrequency.containsKey(element))
            {
                frequency = elementToFrequency.get(element);
                frequency.set(0, frequency.get(0) + 1);
            }

            else
            {
                frequency = new ArrayList<Integer>();
                frequency.add(1);
                frequency.add(element);
            }

            elementToFrequency.put(element, frequency);
        }


        List<List<Integer>> frequencies = new ArrayList<List<Integer>>  (elementToFrequency.values());
        Collections.sort(frequencies, Comparator.comparing( (List<Integer> list) -> list.get(0)).reversed());

        int count =0;
        int[] result = new int[k];
        for (var freq: frequencies)
        {
            if (count==k) break;

            result[count]=freq.get(1);
            count++;
        }

        return result;
    }
}