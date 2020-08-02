import java.util.HashMap;
import java.util.Map;
import java.util.*;
class Test1

{
    public static void count_occur(ArrayList<String> List)
    {
        Map<String, Integer> m = new HashMap<String, Integer>();
        for (String i : List) {
            Integer j = m.get(i);
            m.put(i, (j == null) ? 1 : j + 1);
        }   
        for (Map.Entry<String,Integer> entry : m.entrySet())  
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    
	public static void main(String[] args) {
		
        ArrayList<String> Lists = new ArrayList<String>();
        Lists.add("umar");
        Lists.add("w");
        Lists.add("umar");
        Lists.add("x");
        Lists.add("d");
        Lists.add("a");
        Lists.add("umar");
        Lists.add("r");
       
        count_occur(Lists);
	}
}