//*********************************************************************************
// TracePanel.java								     	    Author: Evan Jackson
//
// Creates a panel on which a picture is displayed and a polygon can be drawn by
// the user by clicking the mouse.
//*********************************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class TracePanel extends JPanel
{
	private final int WIDTH = 580, HEIGHT = 300;
	private int numPoints;
	private int[] xPoints, yPoints;
	private ArrayList<Point> pointList;
	private JLabel label;

	//-----------------------------------------------------
	// Constructor which sets up the GUI.
	//-----------------------------------------------------
	public TracePanel()
	{
		addMouseListener (new TraceListener());
		addKeyListener (new EscapeListener());

		ImageIcon map = new ImageIcon("pei.gif");
		label = new JLabel(map);
		add(label);

		pointList = new ArrayList<Point>();
		numPoints = 0;

		setPreferredSize (new Dimension(WIDTH, HEIGHT));
		setBackground(Color.white);
		setFocusable(true);
	}

	//------------------------------------------------------
	// Draws the panel, including the user's Polygon and
	// the user's instructions.
	//------------------------------------------------------
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);

		xPoints = new int[numPoints];
		yPoints = new int[numPoints];

		for (int i = 0; i < numPoints; i++)
		{
			xPoints[i] = pointList.get(i).x;
			yPoints[i] = pointList.get(i).y;
		}

		page.setColor(Color.BLACK);
		page.drawString("ESC to finish", 5, 20);

		page.setColor(Color.GREEN);
		/*checks to see if the user has clicked the mouse at least once,
		  then draws a filled polygon */
		if (xPoints.length != 0 && xPoints.length != 0)
			page.fillPolygon(xPoints, yPoints, numPoints);
	}

	//****************************************************
	// Represents a listener for mouse events.
	//****************************************************
	public class TraceListener extends MouseAdapter
	{
		//----------------------------------------------
		// Listens for the mouse being clicked and adds
		// the screen point clicked to an ArrayList.
		//----------------------------------------------
		public void mouseClicked (MouseEvent event)
		{
			pointList.add(event.getPoint());
			numPoints++;
		}
	}

	//**********************************************************************
	// Represents a listener for keyboard events.
	//**********************************************************************
	public class EscapeListener implements KeyListener
	{
		//-----------------------------------------------------------------
		// When the ESC key is pressed, the map picture is removed and the
		// user's trace is displayed.
		//-----------------------------------------------------------------
		public void keyPressed(KeyEvent event)
		{
			if (event.getKeyCode() == KeyEvent.VK_ESCAPE)
			{
				remove(label);
				repaint();
			}
		}
		//-----------------------------------------------------
		// Provide empty definitions for unused event methods.
		//-----------------------------------------------------
		public void keyTyped(KeyEvent event) {}
		public void keyReleased (KeyEvent event) {}
	}
}
