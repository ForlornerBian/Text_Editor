import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Override;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.JMenu;

public class GUI implements ActionListener {
    JFrame window;

    // text area
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;

    //top menu bar
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColour;

    //file menu
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

    //edit menu
    JMenuItem iUndoLastItem, iRedo;
    JMenu menuUndo;

    //format menu
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
    JMenu menuFont, menuFontSize;

    //colour menu
    JMenuItem iColour1, iColour2, iColour3;

    


    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);
    Function_Colour colour = new Function_Colour(this);
    Function_Edit edit = new Function_Edit(this);

    UndoManager um = new UndoManager();

    public static void main(String[] args) {

        new GUI();

    }

    public GUI() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        createColourMenu();

        //default
        format.selectedFont = "Arial";
        format.createFont(16);
        format.wordWrap();
        colour.changeColour("White");
        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(1024, 768);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void createTextArea() {
        textArea = new JTextArea();

        textArea.getDocument().addUndoableEditListener(
            new UndoableEditListener(){
                @Override
                public void undoableEditHappened(UndoableEditEvent e) {
                    um.addEdit(e.getEdit());
                    
                }
            }
        );
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
        

    }

    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColour = new JMenu("Colour");
        menuBar.add(menuColour);
    }

    public void createFileMenu() {

        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save As");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }

    public void createEditMenu() {

        menuUndo = new JMenu("Undo");
        menuEdit.add(menuUndo);

        iUndoLastItem = new JMenuItem("Undo Last Item");
        iUndoLastItem.addActionListener(this);
        iUndoLastItem.setActionCommand("Undo Last Item");
        menuUndo.add(iUndoLastItem);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);

    }

    public void createFormatMenu() {

        iWrap = new JMenuItem("Word Wrap: OFF");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);
        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);
        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);
        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);
        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);
        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFontSize.add(iFontSize20);
        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFontSize.add(iFontSize24);
        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("size28");
        menuFontSize.add(iFontSize28);
    }

    public void createColourMenu() {

        iColour1 = new JMenuItem("White");
        iColour1.addActionListener(this);
        iColour1.setActionCommand("White");
        menuColour.add(iColour1);
        iColour2 = new JMenuItem("Black");
        iColour2.addActionListener(this);
        iColour2.setActionCommand("Black");
        menuColour.add(iColour2);
        iColour3 = new JMenuItem("Blue");
        iColour3.addActionListener(this);
        iColour3.setActionCommand("Blue");
        menuColour.add(iColour3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch(command) {
            case "New": file.newFile(); break;
            case "Open": file.open(); break;
            case "Save": file.save(); break;
            case "Save As": file.saveAs(); break;
            case "Exit": file.exit(); break;
            case "Undo Last Item": edit.undo(); break;
            case "Redo": edit.redo(); break;
            case "Word Wrap": format.wordWrap(); break;
            case "Arial": format.setFont("Arial"); break;
            case "Comic Sans MS": format.setFont("Comic Sans MS"); break;
            case "Times New Roman": format.setFont("Times New Roman"); break;
            case "size8": format.createFont(8); break;
            case "size12": format.createFont(12); break;
            case "size16": format.createFont(16); break;
            case "size20": format.createFont(20); break;
            case "size24": format.createFont(24); break;
            case "size28": format.createFont(28); break;
            case "White": colour.changeColour(command); break;
            case "Black": colour.changeColour(command); break;
            case "Blue": colour.changeColour(command); break;
        }
    }
}
