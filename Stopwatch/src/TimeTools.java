import java.util.concurrent.TimeUnit;

public class TimeTools {
	
	long diff; //Time difference in milis.
	
	TimeTools(long startTime) {
		diff = System.currentTimeMillis() - startTime;
	}
	
	public long getMinutes() {
		return TimeUnit.MILLISECONDS.toMinutes(diff);
	}
	
	public long getSeconds() {
		long x = diff;
		
		x = x - getMinutes() * 60000;
		
		return TimeUnit.MILLISECONDS.toSeconds(x);
	}
	
	public long getMilis() {
		long x = diff;
		
		x = x - getMinutes() * 60000;
		x = x - getSeconds() * 1000;
		return x;
	}
}