package controllers;

import java.awt.Component;

public class EnemyMovement {

	private final Component component;

	public EnemyMovement(final Component component) {
		this.component = component;

	}

	public void move(final int speed) {
		final int x = component.getX();
		final int y = component.getY();

		component.setLocation(x + speed, y);

	}
}
