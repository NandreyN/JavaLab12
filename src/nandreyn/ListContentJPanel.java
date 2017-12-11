package nandreyn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

class JListModelGroup extends ArrayList<DefaultListModel>
{}

class JListGroup extends ArrayList<JList>
{}


public class ListContentJPanel extends JPanel {
    private JList<String> leftList, rightList;
    private DefaultListModel<String> leftModel;
    private DefaultListModel<String> rightModel;
    private JListModelGroup listModelGroup;
    private JListGroup listGroup;

    private JButton upperButton, lowerButton;

    static final int LIST_SIZE = 35;

    public ListContentJPanel() {
        seedLists();
        configureInterface();
    }

    private void seedLists() {
        listModelGroup = new JListModelGroup();

        leftModel = new DefaultListModel<String>();
        rightModel = new DefaultListModel<String>();
        listModelGroup.add(leftModel);
        listModelGroup.add(rightModel);

        for (int i = 0; i < LIST_SIZE; i++) {
            for(DefaultListModel lst: listModelGroup)
                lst.addElement(String.valueOf(i));
        }

        leftList = new JList<String>(leftModel);
        rightList = new JList<String>(rightModel);
        listGroup = new JListGroup();
        listGroup.add(leftList);
        listGroup.add(rightList);
    }

    private void configureInterface() {
        for (JList lst : listGroup)
        {
            lst.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            lst.setLayoutOrientation(JList.VERTICAL);
            lst.setVisibleRowCount(-1);
        }

        JScrollPane leftScroller = new JScrollPane(leftList);
        Dimension d = leftList.getPreferredSize();
        d.width *= 5;

        leftScroller.setPreferredSize(d);

        JScrollPane rightScroller = new JScrollPane(rightList);
        rightScroller.setPreferredSize(d);

        this.setLayout(new BorderLayout());
        this.add(leftScroller, BorderLayout.WEST);
        this.add(rightScroller, BorderLayout.EAST);

        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BorderLayout());

        upperButton = new JButton(">");
        upperButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (leftList.isSelectionEmpty())
                    return;
                ArrayList<String> toTransfer = (ArrayList<String>) leftList.getSelectedValuesList();

                for (String s : toTransfer) {
                    leftModel.removeElement(s);
                    rightModel.addElement(s);
                }
            }
        });

        lowerButton = new JButton("<");
        lowerButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rightList.isSelectionEmpty())
                    return;
                ArrayList<String> toTransfer = (ArrayList<String>) rightList.getSelectedValuesList();

                for (String s : toTransfer) {
                    rightModel.removeElement(s);
                    leftModel.addElement(s);
                }
            }
        });
        centralPanel.add(upperButton, BorderLayout.NORTH);
        centralPanel.add(lowerButton, BorderLayout.SOUTH);
        this.add(centralPanel, BorderLayout.CENTER);
    }
}
