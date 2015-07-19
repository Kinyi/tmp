package kinyi.hive;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.hadoop.hive.ql.exec.UDF;

public class WordCount_UDTF extends UDF{

	public String evaluate(String content){
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		String[] split = content.split("[ \t\n]");
		for (int i = 0; i < split.length; i++) {
			Integer time = hashMap.get(split[i]);
			if (time == null) {
				hashMap.put(split[i], 1);
			}else {
				time++;
				hashMap.put(split[i], time);
			}
		}
		String result = "";
		
		Iterator<String> iterator = hashMap.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Integer value = hashMap.get(key);
			result +=key+"\t"+value+"\n";
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String tmp = "hello	you\nhello	me";
		String result = new WordCount_UDTF().evaluate(tmp);
		System.out.println(result);
	}
}
