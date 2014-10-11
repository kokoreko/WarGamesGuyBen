package TzukEitan.war;

import java.io.Serializable;



public class ServerStatus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public enum STATUS {Accepted,Deniend};
	private STATUS stats;
	private String details;
	public ServerStatus(STATUS s) {
			this.stats =s;
		}
	
	public String toString(){
		return stats.toString();
	}
}
