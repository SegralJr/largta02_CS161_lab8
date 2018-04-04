package largta02_CS161_lab8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
* Taylor Large
* CS161
* Spring 2018
* Lab 8
*/

@SuppressWarnings("serial")
public class Sliders extends JFrame implements ChangeListener, ActionListener {
	
	protected JSlider R, G, B;
	protected int RValue, GValue, BValue;
	protected JPanel north, south, east, west, center;
	protected JPanel colorPicker, selection, slidersPanel;
	protected JLabel blendTitle, checkingYourChoice;
	protected JButton thisIsIt, restart;
	
	public static void main(String[] args) {
		
	}
	
	public Sliders() {
		super("Color the panel!");
		
		setSize(800,450);
		setLocation(25,15);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setVisible(true);
	}
	
	public void buildWindow() {
		R = new JSlider(JSlider.VERTICAL, 0, 255, 255);
		G = new JSlider(JSlider.VERTICAL, 0, 255, 255);
		B = new JSlider(JSlider.VERTICAL, 0, 255, 255);
		
		makeSlider(R);
		makeSlider(G);
		makeSlider(B);
		
		R.addChangeListener(this);
		G.addChangeListener(this);
		B.addChangeListener(this);
		
		north = new JPanel();
		south = new JPanel();
		east = new JPanel();
		west = new JPanel();
		center = new JPanel();
		
		colorPicker = new JPanel();
		colorPicker.setBackground(Color.RED);
		selection = new JPanel();
		selection.setBackground(Color.RED);
		
		slidersPanel = new JPanel();
		
		blendTitle = new JLabel("Blend your color here!");
		blendTitle.setBackground(Color.GREEN);
		blendTitle.setOpaque(true);
		
		thisIsIt = new JButton("This is it!");
		restart = new JButton("Re-start!");
		
		checkingYourChoice = new JLabel("Checking your choice");
		
		north.add(blendTitle);
		west.add(checkingYourChoice);
		south.add(thisIsIt);
		south.add(restart);
		center.add(colorPicker);
		west.add(selection);
		east.add(slidersPanel);
		slidersPanel.add(R);
		slidersPanel.add(G);
		slidersPanel.add(B);
		
		add(north, BorderLayout.NORTH);
		add(east, BorderLayout.EAST);
		add(south, BorderLayout.SOUTH);
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public void makeSlider(JSlider slider) {
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(5);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == R) {
			RValue = R.getValue();
		}
		else if(e.getSource() == G) {
			GValue = G.getValue();
		}
		else if(e.getSource() == B) {
			BValue = B.getValue();
		}
		colorPicker.setBackground(new Color(RValue,GValue,BValue));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == "This is it!") {
			selection.setBackground(new Color(RValue,GValue,BValue));
		}
		else if(e.getSource() == "Re-start!") {
			//R.setValue(R.getMaximum());
		}
	}

}
