package IntroToHashMaps;

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class LogSearch implements ActionListener {
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	static HashMap<Integer, String> map = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton();
	JButton search = new JButton();
	JButton view = new JButton();
	JButton remove = new JButton();
	
	public void createUI() {
		frame.add(panel);
		panel.add(add);
		panel.add(search);
		panel.add(view);
		panel.add(remove);
		add.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		add.setText("Add Name and ID");
		search.setText("Search");
		view.setText("View Names");
		remove.setText("Remove a student");
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		LogSearch log = new LogSearch();
		log.createUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == add) {
			map.put(Integer.parseInt(JOptionPane.showInputDialog("Enter an ID")), JOptionPane.showInputDialog("Enter a name for the student"));
		}
		if(e.getSource() == search) {
			int s = Integer.parseInt(JOptionPane.showInputDialog("Enter an ID to search for."));
			if(map.containsKey(s)) {
				JOptionPane.showMessageDialog(null, "The name belonging to that ID is " + map.get(s));
			}
			else {
				JOptionPane.showMessageDialog(null, "Sorry that ID is not registered to anyone.");
			}
		}
		if(e.getSource() == view) {
			String output = "";
			for (int x: map.keySet()) {
				output += ("ID: " + x + " " + "Name: " + map.get(x) + "\n");
			}
			JOptionPane.showMessageDialog(null, output);
		}
		if(e.getSource() == remove) {
			int r = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the student you would like to remove"));
			if(map.containsKey(r)) {
				JOptionPane.showMessageDialog(null, map.get(r) + " was removed.");
				map.remove(r);
			}
			else {
				JOptionPane.showMessageDialog(null, "Sorry that ID is not registered to anyone.");
			}
		}
	}
	
}
