package com.hsenid.reader;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

/**
 * Created by Vidushka on 17/01/17.
 */
public class ParentWindow extends JFrame {
    private final JDesktopPane desktopPane;
    public JPanel parentPanel;
    JMenuBar menu;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu booksMenu;
    JMenu usersMenu;
    JMenuItem newOpt;

    public JMenuBar createMenu() {
        menu = new JMenuBar();
        fileMenu = new JMenu("File");
        newOpt = new JMenuItem("New");
        fileMenu.add(newOpt);
        editMenu = new JMenu("Edit");
        booksMenu = new JMenu("Books");
        usersMenu = new JMenu("Users");
        menu.add(fileMenu);
        menu.add(editMenu);
        menu.add(booksMenu);
        menu.add(usersMenu);
        return menu;
    }

    JInternalFrame createInternalFrame(String tittle) {
        JInternalFrame frame = new JInternalFrame(tittle, true, true, true, true);
        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        desktopPane.add(frame);
        frame.setVisible(true);
        frame.setSize(230, 147);
        Container container = ((BasicInternalFrameUI) frame.getUI()).getNorthPane();
        container.remove(0);

        return frame;
    }

    public ParentWindow() {
        loadParentWindow();
        desktopPane = new JDesktopPane();
        add(desktopPane);
        setJMenuBar(createMenu());

        newOpt.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        createInternalFrame("New");
                    }
                }
        );

    }

    public void loadParentWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("ReaderBuddy");
        setSize(500, 250);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        parentPanel = new JPanel();
        parentPanel.setLayout(new GridBagLayout());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return parentPanel;
    }
}