package fixtures;

import java.util.HashMap;
import java.util.Map;

public class Room extends Fixture {
	private Map<String, Room> adjacentRooms = new HashMap<String, Room>();
	private Map<String, Interactable> items = new HashMap<String, Interactable>();

	public Room(String name, String description) {
		super(name, description);
	}

	public void addAdjecentRoom(String name, Room room) {
		adjacentRooms.put(name, room);
	}

	public Room getAdjacentRoom(String name) {
		if (adjacentRooms.containsKey(name)) {
			return adjacentRooms.get(name);
		} else {
			return null;
		}
	}

	public void addItem(String name, Interactable item) {
		items.put(name, item);
	}

	public Interactable getItem(String name) {
		return items.get(name);
	}

	public boolean validItem(String item) {
		return items.containsKey(item);
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}
}
