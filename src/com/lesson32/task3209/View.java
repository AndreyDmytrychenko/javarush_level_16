package com.lesson32.task3209;

import com.lesson32.task3209.listeners.FrameListener;
import com.lesson32.task3209.listeners.TabbedPaneChangeListener;
import com.lesson32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane(); //панель с двумя вкладками
    private JTextPane htmlTextPane = new JTextPane(); //компонент для визуального редактирования
    private JEditorPane plainTextPane = new JEditorPane(); //компонент для редактирования html в виде текста,
    // он будет отображать код html (теги и их содержимое).

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
                break;

        }
    }

    public void init() {
        initGui();


        //Добавляет указанный оконный слушатель для получения оконных событий из этого окна.
        addWindowListener(new FrameListener(this));
        //Показывает или скрывает это окно в зависимости от значения параметра
        setVisible(true);

    }

    public void exit() {
        controller.exit();
    }

    //Эти методы будут отвечать за инициализацию меню и панелей редактора.
    public void initMenuBar() {

        JMenuBar menuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, menuBar);
        MenuHelper.initEditMenu(this, menuBar);
        MenuHelper.initStyleMenu(this, menuBar);
        MenuHelper.initAlignMenu(this, menuBar);
        MenuHelper.initColorMenu(this, menuBar);
        MenuHelper.initFontMenu(this, menuBar);
        MenuHelper.initHelpMenu(this, menuBar);
        getContentPane().add(menuBar, BorderLayout.NORTH);

    }

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane scrollPane1 = new JScrollPane(htmlTextPane);
        tabbedPane.addTab("HTML", scrollPane1);
        JScrollPane scrollPane2 = new JScrollPane(plainTextPane);
        tabbedPane.addTab("Текст", scrollPane2);
        tabbedPane.setPreferredSize(new Dimension(300, 300));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

    }

    public void selectedTabChanged() {
        if (tabbedPane.getSelectedIndex() == 0) {
            controller.setPlainText(plainTextPane.getText());
        } else if (tabbedPane.getSelectedIndex() == 1) {
            plainTextPane.setText(controller.getPlainText());
        }

        resetUndo();

    }

    //Метод будет инициализировать графический интерфейс.
    public void initGui() {
        initMenuBar();
        initEditor();
//Заставляет это окно иметь размер, соответствующий предпочтительному размеру и макету его под компонентов.
        pack();
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void undo() {
        try {
            undoManager.undo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected() {
        boolean isResult;
        return isResult = tabbedPane.getSelectedIndex() == 0 ? true : false;
    }

    public void selectedHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update() {
        HTMLDocument document = controller.getDocument();
        htmlTextPane.setDocument(document);
    }

    public void showAbout() {
        JOptionPane.showMessageDialog(this, "Лучший HTML редактор", "О программе", JOptionPane.INFORMATION_MESSAGE);
    }

    public void selectHtmlTab() {

    }

}
