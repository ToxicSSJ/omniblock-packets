package net.omniblock.packets.object.external;

public enum Kind {

	DEFAULT,
	NORMAL,
	RARE,
	SEASON,
	VIP;

	public static Kind getTypeByName(String name) {

		try {

			Kind type = valueOf(name);
			return type;

		} catch(Exception e) { return null; }
	}
}
