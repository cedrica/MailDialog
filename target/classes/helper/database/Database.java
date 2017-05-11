package helper.database;

import java.util.ArrayList;
import java.util.List;

import helper.entities.CharacterObject;
import javafx.scene.image.Image;

public class Database {

	public static List<CharacterObject> getAllCharacters() {
		List<CharacterObject> characterList = new ArrayList<>();
		characterList.add(new CharacterObject("Lisa", new Image("/images/characterobject/Char1.png"), 100, 50, 10, 8));
		characterList.add(new CharacterObject("Maria", new Image("/images/characterobject/Char2.png"), 80, 20, 30, 15));
		characterList.add(new CharacterObject("Tom", new Image("/images/characterobject/Char3.png"), 200, 10, 5, 20));
		characterList.add(new CharacterObject("Pete", new Image("/images/characterobject/Char4.png"), 30, 100, 40, 40));
		return characterList;
	}

	public static List<String> getAllNames() {
		List<String> allNames = new ArrayList<>();
		List<CharacterObject> allCharacters = getAllCharacters();
		for (CharacterObject characterObject : allCharacters) {
			allNames.add(characterObject.getName());
		}
		return allNames;
	}
}
