package util.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {

    /**
     * @param map
     * @return
     */
    public static <K, V> Map<V, Set<K>> valueToKeys(Map<K, Set<V>> map) {
	Map<V, Set<K>> results = new HashMap<V, Set<K>>();
	for (K key : map.keySet()) {
	    Set<V> listV = map.get(key);
	    for (V value : listV) {
		Set<K> keys = results.get(value);
		if (keys == null) {
		    keys = new HashSet<K>();
		    keys.add(key);
		    results.put(value, keys);
		} else {
		    keys.add(key);
		}
	    }
	}
	return results;
    }

    
    /**
     * @param map
     * @return
     */
    public static <K, V> Map<V, Set<K>> valueToKey(Map<K, V> map) {
	Map<V, Set<K>> results = new HashMap<V, Set<K>>();
	for (K key : map.keySet()) {
	    V value = map.get(key);
	    Set<K> keys = results.get(value);
	    if (keys == null) {
		keys = new HashSet<K>();
		keys.add(key);
		results.put(value, keys);
	    } else {
		keys.add(key);
	    }
	}
	return results;
    }

}
