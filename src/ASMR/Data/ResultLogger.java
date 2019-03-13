package ASMR.Data;

public interface ResultLogger {
	
	/**
	 * record a test subject responding "yes"
	 * @param ans string containing correct response
	 */
	public abstract void Log_Yes(String ans);
	
	/**
	 * record a test subject responding "no"
	 * @param ans string containing correct response
	 */
	public abstract void Log_No(String ans);
}
