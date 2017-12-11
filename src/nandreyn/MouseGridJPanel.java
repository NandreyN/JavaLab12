package nandreyn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseGridJPanel extends JPanel {
    static final int SIZE = 5;

    public MouseGridJPanel() {
        this.setLayout(new GridLayout(SIZE, SIZE));
        MouseListener globListener = new MouseAdapter() {
            private String textCopy;
            private Color bgColor;
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton button = (JButton)e.getSource();
                bgColor = button.getBackground();
                button.setBackground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JButton button = (JButton)e.getSource();
                button.setBackground(bgColor);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (SwingUtilities.isRightMouseButton(e))
                    return;
                JButton button = (JButton)e.getSource();
                textCopy = button.getText();
                button.setText("Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (SwingUtilities.isRightMouseButton(e))
                    return;
                JButton button = (JButton)e.getSource();
                button.setText(textCopy);
            }
        };


        for (int i = 0; i < SIZE * SIZE; i++) {
            JButton b = new JButton(String.valueOf(i+1));
            b.addMouseListener(globListener);
            b.setEnabled(false);
            this.add(b);
        }
    }
}
