package neim;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MoveSprite extends JFrame{
	public static final int CANVAS_WIDTH=400;
	public static final int CANVAS_HEIGHT=140;
	public static final Color CANVAS_BG_COLOR=Color.cyan;
	
	private DrawCanvas canvas;
    private Sprite sprite;
    
    public MoveSprite() {
    	sprite=new Sprite(CANVAS_WIDTH/2-5,CANVAS_HEIGHT/2-40,10,80,Color.red);
    	
    	JPanel btnPanel=new JPanel(new FlowLayout());
    	JButton btnLeft=new JButton("Move Left");
    	btnPanel.add(btnLeft);
    	btnLeft.addActionListener(new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent evt) {
    			moveLeft();
    			requestFocus();
    		}
    	});
    	
     	JButton btnRight=new JButton("Move Right");
    	btnPanel.add(btnRight);
    	btnRight.addActionListener(new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent evt) {
    			moveRight();
    			requestFocus();
    		}
    	});
    	
    	canvas=new DrawCanvas();
    	canvas.setPreferredSize(new Dimension(CANVAS_WIDTH,CANVAS_HEIGHT));
    	
    	Container cp=getContentPane();
    	cp.setLayout(new BorderLayout());
    	cp.add(canvas,BorderLayout.CENTER);
    	cp.add(btnPanel,BorderLayout.SOUTH);
    	
    	addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyPressed(KeyEvent evt) {
    			switch(evt.getKeyCode()) {
    			case KeyEvent.VK_LEFT:moveLeft();break;
    			case KeyEvent.VK_RIGHT:moveRight();break;
    			}
    		}
    	});
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setTitle("Move a Sprite");
    	pack();
    	setVisible(true);
    	requestFocus();
    }
    private void moveLeft() {
    	int savedX=sprite.x;
    	sprite.x-=10;
    	canvas.repaint(savedX,sprite.y,sprite.width,sprite.height);
    	canvas.repaint(sprite.x,sprite.y,sprite.width,sprite.height);
    }
    private void moveRight() {
    	int savedX=sprite.x;
    	sprite.x+=10;
    	canvas.repaint(savedX,sprite.y,sprite.width,sprite.height);
    	canvas.repaint(sprite.x,sprite.y,sprite.width,sprite.height);
    }
    
    
    class DrawCanvas extends JPanel{
    	@Override
    	public void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		setBackground(CANVAS_BG_COLOR);
    		sprite.paint(g);
    	}
    }
    
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(new Runnable() {
    		@Override
    		public void run() {
    			new MoveSprite();
    		}
    	});
    	
    }
}
