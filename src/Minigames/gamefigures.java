package Minigames;

// PROJECT: Leider hattet ihr ja Probleme mit der Abgabe, daher habe ich jetzt mal diesen Teil hier korrigiert.
// Vielleicht ist es ja hilfreich...

// SUMMARY: Das sieht sehr gut aus, ihr scheint das Information Hiding gut umzusetzen.

// STYLE: Klassennamen immer im CamelCase schreiben (GameFigure), und Singular benutzen
public class gamefigures {

	// STYLE: Attributnamen immer klein schreiben
	private int Movements;
	private int hitbox;
	         				//Attribute(Beschreibungen von Klasse) definieren, die man nicht ausversehen verwenden kann
	public int getMovements() {
		return Movements;
	}
	public void setMovements(int movements) {
		Movements = movements;
	}
	public int getHitbox() {
		return hitbox;
	}
	public void setHitbox(int hitbox) {
		this.hitbox = hitbox;
	}
		

}


