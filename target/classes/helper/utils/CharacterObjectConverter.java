package helper.utils;

import helper.entities.CharacterObject;
import javafx.util.StringConverter;

public class CharacterObjectConverter {
	public static StringConverter<CharacterObject> characterNameConverter(String placeholder) {
		return new StringConverter<CharacterObject>() {
			@Override
			public String toString(CharacterObject character) {
				if (character == null) {
					return placeholder;
				} else {
					return character.getName();
				}
			}

			@Override
			public CharacterObject fromString(String string) {
				return null;
			}
		};
	}

	public static StringConverter<CharacterObject> characterManaConverter() {
		return new StringConverter<CharacterObject>() {
			@Override
			public String toString(CharacterObject character) {
				if (character == null) {
					return "-";
				} else {
					return character.getMana().intValue() + "";
				}
			}

			@Override
			public CharacterObject fromString(String string) {
				return null;
			}
		};
	}

	public static StringConverter<CharacterObject> characterAttackConverter() {
		return new StringConverter<CharacterObject>() {
			@Override
			public String toString(CharacterObject character) {
				if (character == null) {
					return "-";
				} else {
					return character.getAttack().intValue() + "";
				}
			}

			@Override
			public CharacterObject fromString(String string) {
				return null;
			}
		};
	}

	public static StringConverter<CharacterObject> characterDefenceConverter() {
		return new StringConverter<CharacterObject>() {
			@Override
			public String toString(CharacterObject character) {
				if (character == null) {
					return "-";
				} else {
					return character.getDefence().intValue() + "";
				}
			}

			@Override
			public CharacterObject fromString(String string) {
				return null;
			}
		};
	}

	public static StringConverter<CharacterObject> characterHitpointsConverter() {
		return new StringConverter<CharacterObject>() {
			@Override
			public String toString(CharacterObject character) {
				if (character == null) {
					return "-";
				} else {
					return character.getHitpoints().intValue() + "";
				}
			}

			@Override
			public CharacterObject fromString(String string) {
				return null;
			}
		};
	}
}
