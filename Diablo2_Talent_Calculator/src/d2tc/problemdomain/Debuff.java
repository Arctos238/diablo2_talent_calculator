package d2tc.problemdomain;

public class Debuff {
	private int debuffValue;
	private String debuffName;
	private String debuffDescription;
	
	public Debuff(String debuffName, int debuffValue, String debuffDescription) {
		this.debuffDescription = debuffDescription;
		this.debuffName = debuffName;
		this.debuffValue = debuffValue;
	}
	
	public int getDebuffValue() {
		return debuffValue;
	}
	public void setDebuffValue(int debuffValue) {
		this.debuffValue = debuffValue;
	}
	public String getDebuffName() {
		return debuffName;
	}
	public void setDebuffName(String debuffName) {
		this.debuffName = debuffName;
	}
	public String getDebuffDescription() {
		return debuffDescription;
	}
	public void setDebuffDescription(String debuffDescription) {
		this.debuffDescription = debuffDescription;
	}
	
	
}
