package kinyi.hmbbs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 27.19.74.143 - - [30/May/2013:17:38:20 +0800] "GET /static/image/common/faq.gif HTTP/1.1" 200 1127
 * @author martin
 */
public class LogParser {
	
	public String[] parse(String record){
		String ip = parseIp(record);
		String date = parseDate(record);
		String url = parseUrl(record);
		String status = parseStatus(record);
		String traffic = parseTraffic(record);
		String[] result = new String[]{ip,date,url,status,traffic};
		return result;
	}
	
	private String parseIp(String record){
		String[] split = record.split("-");
		String ip = split[0].trim();
		return ip;
	}
	
	private String parseDate(String record){
		int nextIndex = record.indexOf("+");
		int indexOf = record.indexOf("[");
		String stringDate = record.substring(indexOf+1,nextIndex).trim();
		Date parseStringDate = parseStringDate(stringDate);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = simpleDateFormat.format(parseStringDate);
		return date;
	}
	
	private String parseUrl(String record){
		String[] split = record.split("\"");
		String url = split[1];
		return url;
	}
	
	private String parseStatus(String record){
		int lastIndexOf = record.lastIndexOf("/");
		String subString = record.substring(lastIndexOf+1);
		String[] split = subString.split("\\s");
		String status = split[1];
		return status;
	}

	private String parseTraffic(String record){
		int lastIndexOf = record.lastIndexOf("/");
		String subString = record.substring(lastIndexOf+1);
		String[] split = subString.split("\\s");
		String traffic = split[2];
		return traffic;
	}
	
	private Date parseStringDate(String date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", Locale.ENGLISH);
		Date parse = null;
		try {
			parse = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parse;
	}
	
	/*public static void main(String[] args) {
		String record = "27.19.74.143 - - [30/May/2013:17:38:20 +0800] \"GET /static/image/common/faq.gif HTTP/1.1\" 200 1127";
		String[] parse = new LogParser().parse(record);
		System.out.println(parse[0]+"\n"+parse[1]+"\n"+parse[2]+"\n"+parse[3]+"\n"+parse[4]);
	}*/

}
