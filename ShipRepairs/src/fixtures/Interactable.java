package fixtures;

public class Interactable extends Fixture {
	private String useText;
	
	public Interactable(String name, String lookText, String useText) {
		super(name, lookText);
		this.useText = useText;
	}
	
	public String getLookText() {
		return description;
	}
	
	public String getUseText() {
		return useText;
	}
	
	public String getName() {
		return name;
	}
}
