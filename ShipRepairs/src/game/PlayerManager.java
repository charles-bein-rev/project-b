package game;

import fixtures.Room;

public class PlayerManager {
	private static Room currentRoom;
	
	static void setCurrentRoom(Room room) {
		currentRoom = room;
	}
	
	static Room getCurrentRoom() {
		return currentRoom;
	}
}
