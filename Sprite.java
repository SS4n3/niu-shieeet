package neim;

import java.awt.*;

public class Sprite {

	int x,y,width,height;
	Color color=Color.red;
	
	public Sprite(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 100, 100);
	}
}
