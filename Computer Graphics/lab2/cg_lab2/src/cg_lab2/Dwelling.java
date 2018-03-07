package cg_lab2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Dwelling extends JPanel implements ActionListener {
	private static int maxWidth;
	private static int maxHeight;
	
	// the roof coords
	double points[][] = {
			{ -96, -25 }, { 96, -25 }, { 0, -80 },
			};
	
	Timer timer;
	
	// for scale animation
	private double scale = 1;
	private double deltaScale = 0.04;
	
	// for movement animation
	private double tx = 1;
	private double ty = 0;
	private double deltaX = 1;
	private int radius = 200;
	private int radiusExtention = 110;
	
	public Dwelling() {
		timer = new Timer(10, this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
				rh.put(RenderingHints.KEY_RENDERING,
				RenderingHints.VALUE_RENDER_QUALITY);
				g2d.setRenderingHints(rh);
		
		// the background color setting
		g2d.setBackground(new Color(25,25,112));
		g2d.clearRect(0, 0, maxWidth, maxHeight);
		
		// set the origin to the center
		g2d.translate(maxWidth/2, maxHeight/2);
		
		BasicStroke bs2 = new BasicStroke(16, BasicStroke.CAP_ROUND, 
				BasicStroke.JOIN_MITER);
				g2d.setStroke(bs2);
				g2d.drawRect(-(radius + radiusExtention), -(radius + radiusExtention),
						(radius + radiusExtention)*2, (radius + radiusExtention)*2);
		
		// the movement transformation
		g2d.translate(tx, ty);
		
		// the roof triangle setting
		GeneralPath roof = new GeneralPath();
		roof.moveTo(points[0][0], points[0][1]);
		for (int k = 1; k < points.length; k++)
			roof.lineTo(points[k][0], points[k][1]);
		roof.closePath();
		
		// the scale transformation
		g2d.scale(scale, 0.99);
		
		// the roof drawing
		g2d.setColor(Color.gray);
		g2d.fill(roof);
		
		// the dwelling body drawing
		g2d.setColor(new Color(139, 69, 19));
		g2d.fillRect(-90, -25, 180, 115);
		
		// the windows drawing
		g2d.setColor(Color.yellow);
		g2d.fillRect(-70, 0, 30, 30);
		g2d.fillRect(40, 0, 30, 30);
		
		// the stars drawing
		g2d.setColor(Color.white);
		g2d.fillRect(-70, -60, 10, 10);
		g2d.fillRect(-40, -90, 10, 10);
		g2d.fillRect(60, -60, 10, 10);
		g2d.fillRect(30, -90, 10, 10);
		
		// the door drawing
		GradientPaint gp = new GradientPaint(5, 25, 
			    new Color(119,136,153), 20, 2, Color.black, true);
	    g2d.setPaint(gp);
	    g2d.fillRect(-20, -10, 40, 100);
	    
	    // the grass drawing
	    g2d.setColor(new Color(0, 100, 0));
	    BasicStroke bs = new BasicStroke(8, BasicStroke.CAP_ROUND, 
	    		BasicStroke.JOIN_BEVEL);
	    g2d.setStroke(bs);
	    g2d.drawLine(-90, 90, 90, 90);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Java 2D - one love!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(new Dwelling());
		
		frame.setVisible(true);
		
		Dimension size = frame.getSize();
		Insets insets = frame.getInsets();
		maxWidth = size.width - insets.left - insets.right - 1;
		maxHeight = size.height - insets.top - insets.bottom - 1;
	}
	
	public void actionPerformed(ActionEvent e) {
		// scaling
		if ( scale < 0.01 ) {
			deltaScale = -deltaScale;
		} else if (scale > 0.99) {
			deltaScale = -deltaScale;
		}
		scale += deltaScale;
		
		// movement
		double radiusInSquare = Math.pow(radius, 2);
		if (tx <= 0 && ty < 0){
			tx -= deltaX;
			ty = (-1) * Math.abs(Math.sqrt(radiusInSquare - Math.pow(tx, 2)));
		}else if(tx > 0 && ty <= 0){
			tx -= deltaX;
			ty = (-1) * Math.abs(Math.sqrt(radiusInSquare - Math.pow(tx, 2)));
		}else if(tx >= 0 && ty > 0){
			tx += deltaX;
			ty = Math.abs(Math.sqrt(radiusInSquare - Math.pow(tx, 2)));
		}else if(tx < 0 && ty >= 0){
			tx += deltaX;
			ty = Math.abs(Math.sqrt(radiusInSquare - Math.pow(tx, 2)));
		}
		
		repaint();
	}
}
