package game;

import java.util.Arrays;
import java.util.Scanner;

import fixtures.Interactable;
import fixtures.Room;

public class GameManager {
	private static boolean gameOver;
	private static boolean checkedMessage;
	private static boolean movedCrate;
	private static boolean haveTool;

	private static Room currentRoom;

	static Scanner scan = new Scanner(System.in);

	public static void init() {
		ItemManager.initializeItems();
		RoomManager.initializeRooms();
		PlayerManager.setCurrentRoom(RoomManager.startingRoom);
		gameOver = false;
		checkedMessage = false;
		movedCrate = false;
		haveTool = false;

		gameLoop();
	}

	private static void gameLoop() {
		do {
			currentRoom = PlayerManager.getCurrentRoom();
			displayRoomInfo();
			String[] command = parseInput(getInput());
			//TODO: Delete debug
			System.out.println(command[0] + " " + command[1]);
			if (Arrays.asList(command).contains("INVALID")) {
				cantParse();
			} else {
				runCommand(command);
			}
			System.out.println();
		} while (!gameOver);
	}

	private static String getInput() {
		return scan.nextLine();
	}

	private static String[] parseInput(String input) {
		String[] output = new String[2];
		String[] temp = input.toLowerCase().split(" ");
		//TODO: Delete debug
		System.out.println(temp[0] + " " + temp[1]);
		if (temp[0].equals("look") || temp[0].equals("use")) {
			output[0] = temp[0];
			if (currentRoom.getName() == "Bedroom" && temp[1] == "console" && !checkedMessage) {
				output[1] = "consoleFirstTime";
				checkedMessage = true;
			} else if (currentRoom.getName() == "Cargo Bay") {
				if (temp[1] == "toolbox" && haveTool) {
					output[1] = "emptyToolbox";
				} else if (temp[1] == "toolbox" && !haveTool) {
					output[1] = temp[1];
					haveTool = true;
				} else if (temp[1] == "crate" && !movedCrate) {
					output[1] = temp[1];
					movedCrate = true;
				} else if (temp[1] == "hatch" && movedCrate) {
					output[1] = "movedCrate";
				} else if (temp[1] == "hatch" && !movedCrate) {
					output[1] = "blockedHatch";
				}
			} else if (currentRoom.validItem(temp[1])) {
				output[1] = temp[1];
			} else {
				output[1] = "INVALID";
			}
		} else if (temp[0].equals("go")) {
			output[0] = temp[0];
			switch (temp[1]) {
			case "forward":
			case "fore":
			case "f":
				output[1] = "forward";
				break;
			case "aft":
			case "a":
				output[1] = "aft";
				break;
			case "port":
			case "p":
				output[1] = "port";
				break;
			case "starboard":
			case "s":
				output[1] = "starboard";
				break;
			default:
				output[1] = parseDirection(temp[1]);
			}
		} else {
			output[0] = "INVALID";
			output[1] = "INVALID";
		}

		return output;
	}

	private static String parseDirection(String input) {
		String output = "INVALID";

		if (input == "hall" && currentRoom.getName() != "Hallway" && currentRoom.getName() != "Engine Room") {
			output = "hall";
		} else if (currentRoom.getName() == "Hallway" && input == "cockpit" || input == "bedroom"
				|| input == "engine") {
			output = input;
		} else if (currentRoom.getName() == "Cargo Bay" && input == "ladder" || input == "hatch" || input == "down") {
			output = "engine";
		} else if (currentRoom.getName() == "Engine Room" && input == "ladder" || input == "hatch" || input == "up") {
			output = "cargo";
		}

		return output;
	}

	private static Room parseRoom(String input) {
		if (input == "port" || input == "starboard" || input == "forward" || input == "aft") {
			if (currentRoom.getName() == "Hallway") {
				switch (input) {
				case "port":
					return currentRoom.getAdjacentRoom("bedroom");
				case "starboard":
					useItem(currentRoom.getItem("door"));
					return currentRoom;
				case "forward":
					return currentRoom.getAdjacentRoom("cockpit");
				case "aft":
					return currentRoom.getAdjacentRoom("cargo");
				}
			} else if (currentRoom.getName() == "Bedroom" && input == "starboard") {
				return currentRoom.getAdjacentRoom("hall");
			} else if (currentRoom.getName() == "Cockpit" && input == "aft") {
				return currentRoom.getAdjacentRoom("hall");
			} else if (currentRoom.getName() == "Cargo Bay" && input == "forward") {
				return currentRoom.getAdjacentRoom("hall");
			}
		} else {
			Room temp = currentRoom.getAdjacentRoom(input);
			if (temp == null)
				return currentRoom;
			else
				return temp;
		}
		return currentRoom;
	}

	private static void runCommand(String[] command) {
		switch (command[0]) {
		case "look":
			lookAtItem(currentRoom.getItem(command[1]));
			break;
		case "use":
			useItem(currentRoom.getItem(command[1]));
			break;
		case "go":
			moveToRoom(parseRoom(command[1]));
			break;
		}
	}

	private static void displayRoomInfo() {
		System.out.print(currentRoom.getName() + ": ");
		System.out.println(currentRoom.getDescription());
	}

	private static void lookAtItem(Interactable item) {
		System.out.print("LOOK " + item.getName().toUpperCase() + ": ");
		System.out.println(item.getLookText());
	}

	private static void moveToRoom(Room room) {
		PlayerManager.setCurrentRoom(room);
	}

	private static void useItem(Interactable item) {
		if (item.getName() == "door" && currentRoom.getName() == "Bedroom") {
			moveToRoom(currentRoom.getAdjacentRoom("hall"));
		} else if (item.getName() == "hatch") {
			moveToRoom(currentRoom.getAdjacentRoom("engine"));
		} else if (item.getName() == "ladder") {
			moveToRoom(currentRoom.getAdjacentRoom("cargo"));
		} else {
			System.out.print("USE" + item.getName().toUpperCase() + ": ");
			System.out.println(item.getUseText());
			if (item.getName() == "engine" && haveTool) {
				gameOver = true;
			}
		}
	}

	private static void cantParse() {
		System.out.println("Sorry, I didn't understand that. Please only use keywords "
				+ "\"USE,\" \"LOOK,\" and \"GO,\" followed by the item or " + "direction you want to interact with.");
	}
}
