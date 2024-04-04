package Controller;

import Model.TextEditor;
import Views.ViewEditor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerTextEditor implements ActionListener {
    private ViewEditor viewEditor;
    private TextEditor textEditor = new TextEditor();
    public ControllerTextEditor(ViewEditor viewEditor) {
        this.viewEditor = viewEditor;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Open")){
            textEditor.getFile(viewEditor);
        } else if (src.equals("Save")){
            textEditor.saveFile(viewEditor);
        } else if (src.equals("Save as")){
            textEditor.saveAsFile(viewEditor);
        }else if (src.equals("New")){
            textEditor.newFile(viewEditor);
        } else if (src.equals("NewWindow")){
            textEditor.newWindow();
        } else if (src.equals("Version")){
            JOptionPane.showMessageDialog(viewEditor, "version beta");
        }
    }
}
