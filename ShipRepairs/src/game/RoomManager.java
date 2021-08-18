package game;

import java.util.HashMap;
import java.util.Map;

import fixtures.Room;

public class RoomManager {
	static Room startingRoom;
	static Map<String, Room> roomList = new HashMap<String, Room>();
	
	static void initializeRooms() {
		Room bedroom = new Room("Bedroom", "Your room is small, clean, and bare. "
									+ "There’s no decorations on the metal bulkheads, "
									+ "and the only furnishings are your BED, your message CONSOLE, "
									+ "and the DOOR on the Starboard wall.");
		startingRoom = bedroom;
		
		bedroom.addItem("bed", ItemManager.itemList.get("bed"));
		bedroom.addItem("console", ItemManager.itemList.get("bedConsole"));
		bedroom.addItem("consoleFirstTime", ItemManager.itemList.get("bedConsoleFirstTime"));
		bedroom.addItem("door", ItemManager.itemList.get("door"));
		
		roomList.put("bedroom", bedroom);
		
		Room hall = new Room("Hallway", "You’re standing in the hall that connects the different rooms of the ship. "
											+ "It stretches Forward to the cockpit and Aft to the cargo bay. "
											+ "In the middle of the hall are two doors. "
											+ "The one on the Port side is marked with your name, "
											+ "while the one on the Starboard says WC.");
		
		bedroom.addItem("door", ItemManager.itemList.get("wcDoor"));
		
		roomList.put("hall", hall);
		
		Room cockpit = new Room("Cockpit", "The cockpit has always been your favorite room on the ship. "
											+ "Above the CONSOLE’s small screen is "
											+ "the fantastic view of space out the WINDOW. "
											+ "To the Aft is the door back to the hallway.");
		
		cockpit.addItem("console", ItemManager.itemList.get("cockpitConsole"));
		cockpit.addItem("window", ItemManager.itemList.get("window"));
		
		roomList.put("cockpit", cockpit);
		
		Room cargo = new Room("Cargo Bay", "The cargo bay looks almost exactly as you left it: "
											+ "tall stacks of crates along the aft wall, "
											+ "and your TOOLBOX on the workbench along the port wall.");
		
		cargo.addItem("toolbox", ItemManager.itemList.get("toolbox"));
		cargo.addItem("emptyToolbox", ItemManager.itemList.get("emptyToolbox"));
		cargo.addItem("crate", ItemManager.itemList.get("crate"));
		cargo.addItem("movedCrate", ItemManager.itemList.get("movedCrate"));
		cargo.addItem("hatch", ItemManager.itemList.get("hatch"));
		cargo.addItem("blockedHatch", ItemManager.itemList.get("blockedHatch"));
		
		roomList.put("cargo", cargo);
		
		Room engine = new Room("Engine Room", "The normally noisy engine room is eerily quiet. "
												+ "The ENGINE itself lays still, and vapor rises from it. "
												+ "There’s no question about it, the ENGINE needs to be fixed. "
												+ "The good news is that everything seems to be intact, "
												+ "so the multitool should be enough to fix it. "
												+ "The LADDER leads back up to the cargo hold.");
		
		engine.addItem("engine", ItemManager.itemList.get("engine"));
		engine.addItem("engineNoMulti", ItemManager.itemList.get("engineNoMulti"));
		engine.addItem("ladder", ItemManager.itemList.get("ladder"));
		
		roomList.put("engine", engine);
		
		bedroom.addAdjecentRoom("hall", hall);
		cockpit.addAdjecentRoom("hall", hall);
		cargo.addAdjecentRoom("hall", hall);
		cargo.addAdjecentRoom("engine", engine);
		engine.addAdjecentRoom("cargo", cargo);
		hall.addAdjecentRoom("bedroom", bedroom);
		hall.addAdjecentRoom("cockpit", cockpit);
		hall.addAdjecentRoom("cargo", cargo);
	}
}
