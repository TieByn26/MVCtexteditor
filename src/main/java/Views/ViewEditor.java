package Views;

import Controller.ControllerTextEditor;

import javax.swing.*;
import java.awt.*;


public class ViewEditor extends JFrame {
    private ControllerTextEditor c = new ControllerTextEditor(this);
    private JTextArea jTextArea = new JTextArea();
    private JMenuBar jMenuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenu helpMenu = new JMenu("Help");
    private JMenuItem openMenuItem = new JMenuItem("Open");
    private JMenuItem saveMenuItem = new JMenuItem("Save");
    private JMenuItem saveAsMenuItem = new JMenuItem("Save as");
    private JMenuItem newMenuItem = new JMenuItem("New");
    private JMenuItem newWindowItem = new JMenuItem("NewWindow");
    private JMenuItem versionItem = new JMenuItem("Version");

    private SpringLayout springLayout = new SpringLayout();
    public ViewEditor(){
        this.setSize(new Dimension(500,400));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.init();
        this.setVisible(true);
    }
    public void init(){
        this.getContentPane().setLayout(springLayout);
        jTextArea.setPreferredSize(new Dimension(500,400));
        this.add(jTextArea);
        jMenuBar.add(fileMenu);
        jMenuBar.add(helpMenu);
        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);
        fileMenu.add(newWindowItem);
        helpMenu.add(versionItem);
        newMenuItem.addActionListener(c);
        newWindowItem.addActionListener(c);
        openMenuItem.addActionListener(c);
        saveMenuItem.addActionListener(c);
        saveAsMenuItem.addActionListener(c);
        versionItem.addActionListener(c);
        this.setJMenuBar(jMenuBar);

    }

    public JTextArea getjTextArea() {
        return jTextArea;
    }

    public void setjTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }
}
