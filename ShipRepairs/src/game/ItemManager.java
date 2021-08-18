package game;

import java.util.HashMap;
import java.util.Map;

import fixtures.Interactable;

public class ItemManager {
	static Map<String, Interactable> itemList = new HashMap<String, Interactable>();
	static void initializeItems() {
		Interactable bed = new Interactable("Bed", "Your bed is hard, uncomfortable, "
											+ "and there’s nowhere you’d rather be right now. \n"
											+ "Unfortunately, you’ve got more important things to "
											+ "deal with right now, but you’ll be back soon enough.", 
											"You’ve got more important things to do than sleep right now");
		itemList.put("bed", bed);
		
		Interactable bedConsole = new Interactable("Console", "Your message console is old, and it looks it. "
																+ "The two-tone screen can’t display anything but text, "
																+ "and the keyboard sticks every few strokes. \n"
																+ "You keep meaning to upgrade it, but the price is never right.", 
																"A message is displayed on the screen: \n"
																+ "\"Major issue detected. Please report to the cockpit immediately.\" \n"
																+ "Well, that doesn’t sound good.");
		itemList.put("bedConsole", bedConsole);
		
		Interactable bedConsoleFirstTime = new Interactable("Console", "Your message console is old, and it looks it. "
																+ "The two-tone screen can’t display anything but text, "
																+ "and the keyboard sticks every few strokes. \n"
																+ "You keep meaning to upgrade it, but the price is never right.\n"
																+ "A green light is flashing on and off in the corner, "
																+ "indicating a new message has been received.", 
																"A message is displayed on the screen: \n"
																+ "\"Major issue detected. Please report to the cockpit immediately.\" \n"
																+ "Well, that doesn’t sound good.");
		itemList.put("bedConsoleFirstTime", bedConsoleFirstTime);
		
		Interactable door = new Interactable("Door", "The metal door to the hallway is plain and simple. "
														+ "Like all the doors on the ship, "
														+ "it opens automatically if you walk toward it.",
														"Use door: should never display");
		itemList.put("door", door);
		
		Interactable wcDoor = new Interactable("WC", "The plain door to the bathroom looks like all the others, "
																	+ "except for the sign marking it. "
																	+ "Luckily, you don't need to use it right now. ", 
																	"You’ve got more pressing matters, and besides, "
																	+ "you don’t have to go right now.");
		itemList.put("wcDoor", wcDoor);
		
		Interactable cockpitConsole = new Interactable("Console", "The most up-to-date screen on the ship, "
																	+ "this console has a full-color display. "
																	+ "It handles navigation, long-range communications, "
																	+ "status reports, and pretty much everything else "
																	+ "you might need to fly a ship as small as this one.", 
																	"A message is displayed on the screen: "
																	+ "\"Situation Report: Critical error detected with the engine. "
																	+ "Please correct immediately to resume normal flight. "
																	+ "Recommend use of standard multitool "
																	+ "from the toolbox in the cargo hold.\"");
		itemList.put("cockpitConsole", cockpitConsole);
		
		Interactable window = new Interactable("Window", "It doesn’t matter how long you spend out here, "
															+ "the views of space never fail to impress. "
															+ "Out the window, you can see a blue-green gas giant, "
															+ "sitting in front of a brilliant starfield. "
															+ "You take a moment to take it all in, before getting back to work.", 
															"It doesn’t matter how long you spend out here, "
															+ "the views of space never fail to impress. "
															+ "Out the window, you can see a blue-green gas giant, "
															+ "sitting in front of a brilliant starfield. "
															+ "You take a moment to take it all in, before getting back to work.");
		itemList.put("window", window);
		
		Interactable toolbox = new Interactable("Toolbox", "A simple red toolbox sits on the workbench. "
															+ "You’ve had it with you since you first went into space, "
															+ "and it’s never let you down yet.", 
															"You grab your trusty multitool out of the toolbox. "
															+ "Now you’re ready to fix whatever’s broken.");
		itemList.put("toolbox", toolbox);
		
		Interactable emptyToolbox = new Interactable("Toolbox", "A simple red toolbox sits on the workbench. "
																+ "You’ve had it with you since you first went into space, "
																+ "and it’s never let you down yet.", 
																"You’ve already got your multitool, "
																+ "so you don’t need anything else out of here.");
		itemList.put("emptyToolbox", emptyToolbox);
		
		Interactable crate = new Interactable("Crate", "As always, you don’t have any idea what’s in your cargo, "
														+ "and you’ll never get to find out. "
														+ "The anti-grav unit built into every crate makes whatever "
														+ "it is light enough to move when you need to, "
														+ "and all you need to know is that you’ll get paid once you deliver it.", 
														"You activate the crate’s anti-grav unit and "
														+ "lift it back into place on the stack. "
														+ "Turning the anti-grav off, the crate falls into place with a heavy thud, "
														+ "and you triple-check the restraints before getting back to work.");
		itemList.put("crate", crate);
		
		Interactable movedCrate = new Interactable("Crate", "As always, you don’t have any idea what’s in your cargo, "
															+ "and you’ll never get to find out. "
															+ "The anti-grav unit built into every crate makes whatever "
															+ "it is light enough to move when you need to, "
															+ "and all you need to know is that you’ll get paid once you deliver it.", 
															"The crate is already back in place, "
															+ "and there’s no way it’s going anywhere this time. "
															+ "Nothing else to do here.");
		itemList.put("movedCrate", movedCrate);
		
		Interactable blockedHatch = new Interactable("Hatch", "The hatch to the engine room is blocked by the crate. "
																+ "It’ll have to be moved before you can access the hatch.", 
																"You need to move the crate before you can get at it.");
		itemList.put("blockedHatch", blockedHatch);
		
		Interactable hatch = new Interactable("Hatch", "The hatch down to the engine room is now unblocked, "
														+ "and you can get up and down whenever you want.", 
														"Hatch use text, should never display");
		itemList.put("hatch", hatch);
		
		Interactable engine = new Interactable("Engine", "What should be the beating heart of the ship "
															+ "is just a cold mass of metal. Your FTL drive, "
															+ "once the height of modern invention, is so old "
															+ "that it breaks down at least once a year. "
															+ "Sooner or later, it’s going to give out completely, "
															+ "leaving you stranded in space. You should really make "
															+ "a note to look into a new one the next time you’re in port.", 
															"With a bit of effort, you manage to fix the engine with the multitool. "
															+ "As it roars back to life, you give a sigh of relief. "
															+ "You head back to your bunk to get back to sleep. "
															+ "Only six more months to your destination. "
															+ "Hopefully it’ll be smooth sailing the rest of the way.");
		itemList.put("engine", engine);
		
		Interactable engineNoMulti = new Interactable("Engine", "What should be the beating heart of the ship "
															+ "is just a cold mass of metal. Your FTL drive, "
															+ "once the height of modern invention, is so old "
															+ "that it breaks down at least once a year. "
															+ "Sooner or later, it’s going to give out completely, "
															+ "leaving you stranded in space. You should really make "
															+ "a note to look into a new one the next time you’re in port.",
															"This is definitely the problem, but you forgot to grab your multitool. "
															+ "You’ll have to go back up and get it before you can do any repairs.");
		itemList.put("engineNoMulti", engineNoMulti);
		
		Interactable ladder = new Interactable("Ladder", "The ladder leads back up to the cargo hold, "
															+ "and beyond it, the rest of the ship.", 
															"Ladder use text, should never display");
		itemList.put("ladder", ladder);
	}
}
