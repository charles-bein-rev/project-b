package fixtures;

public abstract class Fixture {
	protected String name;
	protected String description;

	public Fixture(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
