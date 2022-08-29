package d2tc.problemdomain;

public class Buff {
	private int buffValue;
	private String buffName;
	private String buffDescription;
	
	public Buff(String buffName, int buffValue, String buffDescription) {
		this.buffDescription = buffDescription;
		this.buffName = buffName;
		this.buffValue = buffValue;
	}
	
	public int getBuffValue() {
		return buffValue;
	}
	public void setBuffValue(int buffValue) {
		this.buffValue = buffValue;
	}
	public String getBuffName() {
		return buffName;
	}
	public void setBuffName(String buffName) {
		this.buffName = buffName;
	}

	public String getBuffDescription() {
		return buffDescription;
	}

	public void setBuffDescription(String buffDescription) {
		this.buffDescription = buffDescription;
	}
	
	
}
