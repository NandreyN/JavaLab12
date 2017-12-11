package nandreyn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class RadioButtonPanel extends JPanel {
    private JRadioButton usaButton, ukButton, ussrButton, germanyButton, japanButton;
    private ButtonGroup group;
    private ImageIcon defaultImage, selectedImage, pressedImage, focusImage;

    private void prepareImage(ImageIcon toPrepare) {
        Image img = toPrepare.getImage();
        Image newImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        toPrepare.setImage(newImg);
    }

    public RadioButtonPanel() {

        usaButton = new JRadioButton();
        usaButton.setText("USA");
        ukButton = new JRadioButton();
        ukButton.setText("UK");
        ussrButton = new JRadioButton();
        ussrButton.setText("USSR");
        germanyButton = new JRadioButton();
        germanyButton.setText("Germany");
        japanButton = new JRadioButton();
        japanButton.setText("Japan");

        group = new ButtonGroup();
        group.add(usaButton);
        group.add(ukButton);
        group.add(ussrButton);
        group.add(germanyButton);
        group.add(japanButton);

        defaultImage = new ImageIcon("cross2.png");
        selectedImage = new ImageIcon("ok-512.png");
        pressedImage = new ImageIcon("pressed.png");
        focusImage = new ImageIcon("focus.png");


        prepareImage(defaultImage);
        prepareImage(selectedImage);
        prepareImage(pressedImage);
        prepareImage(focusImage);

        MouseListener focusListener = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                JRadioButton rb = (JRadioButton) e.getSource();
                rb.setIcon(focusImage);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                JRadioButton rb = (JRadioButton) e.getSource();
                rb.setIcon(defaultImage);
            }
        };

        for (Iterator<AbstractButton> it = group.getElements().asIterator(); it.hasNext(); ) {
            JRadioButton b = (JRadioButton) it.next();
            b.setIcon(defaultImage);
            b.setSelectedIcon(selectedImage);
            b.setPressedIcon(pressedImage);
            b.addMouseListener(focusListener);
            this.add(b);
        }
    }
}
