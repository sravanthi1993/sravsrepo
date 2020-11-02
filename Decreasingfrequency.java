package chinni;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;

import static java.util.Map.Entry.*;

public class Decreasingfrequency {

	static <K, V> void orderByValue(
	        LinkedHashMap<K, V> m, final Comparator<? super V> c) {
	    List<Map.Entry<K, V>> entries = new ArrayList<>(m.entrySet());

	    Collections.sort(entries, new Comparator<Map.Entry<K, V>>() {
	        @Override
	        public int compare(Map.Entry<K, V> lhs, Map.Entry<K, V> rhs) {
	            return c.compare(lhs.getValue(), rhs.getValue());
	        }
	    });

	    m.clear();
	    for(Map.Entry<K, V> e : entries) {
	        m.put(e.getKey(), e.getValue());
	    }
	}
	
	static void printDecreasingFrequency(int []a)
	{
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		for(int i = 0; i< a.length; i++)
		{
			if(h.containsKey(a[i]))
			{ //h.keySet().iterator().next()
				h.put(a[i], h.get(a[i])+1);
			}
			else
				h.put(a[i], 1);
		}
		LinkedHashMap<Integer, Integer> l = h.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.collect(toMap(
                Map.Entry::getKey, 
                Map.Entry::getValue, 
                (x,y)-> {throw new AssertionError();},
                LinkedHashMap::new
        ));

		int i = 0;
		for (Entry<Integer, Integer> entry : l.entrySet())
		{
				int x = entry.getKey();
				int frequency = entry.getValue();
				//System.out.println(frequency);
				for(int j= 0;j <frequency; j++)
				{
					a[i] = x;
					i++;
					System.out.print(x + " ");
				}
			}
	}
		
		/*h = h.entrySet()
		        .stream()
		        .sorted(Map.Entry.comparingByValue())
		        .forEachOrdered(e -> l.put(e.getKey(), e.getValue());*/
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {2,5,2,8,5,6,8,8};
		printDecreasingFrequency(a);
	}

}
