package IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();

	Stack s = new Stack();

	public void createUI() {
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		TextUndoRedo t = new TextUndoRedo();
		t.createUI();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (!(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) && !(e.getKeyCode() == KeyEvent.VK_CONTROL)) {
			label.setText(label.getText() + "" + e.getKeyChar());
		}
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && label.getText().length() > 0) {
			s.push(label.getText().substring(label.getText().length() - 1, label.getText().length()));
			label.setText(label.getText().substring(0, label.getText().length() - 1));

		}
		if (e.getKeyCode() == KeyEvent.VK_CONTROL && !(s.isEmpty())) {
			label.setText(label.getText() + s.pop());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
