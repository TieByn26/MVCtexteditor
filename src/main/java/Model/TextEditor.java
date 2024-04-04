package Model;

import Views.ViewEditor;

import javax.swing.*;
import java.io.*;

public class TextEditor {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public TextEditor() {
    }
    public void getFile(ViewEditor viewEditor) {
        JFileChooser fileChooser = new JFileChooser("D:\\filetxt");
        int result = fileChooser.showOpenDialog(viewEditor);
        if (result == JFileChooser.APPROVE_OPTION){
            try {
                File selectedFile = fileChooser.getSelectedFile();
                setPath(selectedFile.getAbsolutePath());
                BufferedReader reader = new BufferedReader(new FileReader(getPath().replace("\\", "\\\\")));
                //lamda va phuong thuc cua Stream ne=DDD
                reader.lines().forEach(line -> viewEditor.getjTextArea().append(line + "\n"));
                reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public void newFile(ViewEditor viewEditor){
        setPath(null);
        viewEditor.getjTextArea().setText(null);
    }
    public void saveFile(ViewEditor viewEditor){
        if (getPath() != null){
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(getPath()));
                writer.write(viewEditor.getjTextArea().getText());
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            saveAsFile(viewEditor);
        }
    }
    public void saveAsFile(ViewEditor viewEditor){
        JFileChooser jFileChooser = new JFileChooser("D:\\filetxt");
        int result = jFileChooser.showSaveDialog(viewEditor);
        if (result == JFileChooser.APPROVE_OPTION){
            try{
                File file = jFileChooser.getSelectedFile();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(viewEditor.getjTextArea().getText());
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public void newWindow(){
        new ViewEditor();
    }
}
