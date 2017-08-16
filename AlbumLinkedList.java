
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;


public class AlbumLinkedList extends LinkedList<Album> {
	private int totalSecond;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8201011851978595503L;
	
	@Override
	public boolean add(Album e) {
		totalSecond += parseTime(e.totalTime);
		return super.add(e);
	}

	@Override
	public Album remove(int index) {
		totalSecond -= parseTime(get(index).totalTime);
		return super.remove(index);
	}
	private int parseTime(String totalTime) {
		String fields[] = totalTime.split(":");
		int hour = Integer.parseInt(fields[0]);
		int min = Integer.parseInt(fields[1]);
		int sec = Integer.parseInt(fields[2]);
		return (hour*3600)+(min*60)+sec;
	}
	
	public String getTotalTime(){
		TimeZone tz = TimeZone.getTimeZone("UTC");
	    SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
	    df.setTimeZone(tz);
	    return df.format(new Date(totalSecond*1000));
	}
}
