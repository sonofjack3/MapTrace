//*********************************************************************************
// TraceDriver.java							            	Author: Evan Jackson
//
// Creates the main frame for the tracing program.
//*********************************************************************************

import java.awt.*;
import javax.swing.*;

public class TraceDriver
{
	//----------------------------------------------------------
	// Creates the main program frame.
	//----------------------------------------------------------
	public static void main (String[] args)
	{
		JFrame frame = new JFrame("Trace the map!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new TracePanel());
		frame.pack();
		frame.setVisible(true);
	}
}