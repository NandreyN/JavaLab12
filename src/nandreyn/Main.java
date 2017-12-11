package nandreyn;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

class TabbedFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel taskPanel1, taskPanel2, taskPanel3;

    public TabbedFrame(String painting) {
        initFirstTaskPanel();
        initSecondTaskPanel();
        initThirdTaskPanel();
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Task1", taskPanel1);
        tabbedPane.addTab("Task2", taskPanel2);
        tabbedPane.addTab("Task3", taskPanel3);
        this.setLayout(new BorderLayout());
        this.add(tabbedPane, BorderLayout.CENTER);
    }

    private void initFirstTaskPanel() {
        taskPanel1 = new JPanel();
        taskPanel1.setLayout(new BorderLayout());
        JPanel t1 = new ListContentJPanel();
        t1.setPreferredSize(taskPanel1.getPreferredSize());
        taskPanel1.add(t1, BorderLayout.CENTER);
    }

    private void initSecondTaskPanel() {
        taskPanel2 = new JPanel();
        taskPanel2.setLayout(new BorderLayout());
        JPanel t = new MouseGridJPanel();
        t.setPreferredSize(taskPanel2.getPreferredSize());
        taskPanel2.add(t, BorderLayout.CENTER);
    }

    private void initThirdTaskPanel() {
        taskPanel3 = new JPanel();
        taskPanel3.setLayout(new BorderLayout());
        JPanel t = new RadioButtonPanel();
        t.setPreferredSize(taskPanel3.getPreferredSize());
        taskPanel3.add(t, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        TabbedFrame tabbedFrame = new TabbedFrame("Application");
        tabbedFrame.setBounds(100, 100, 500, 500);
        tabbedFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        tabbedFrame.setVisible(true);
    }
}