package com.lesson32.task3209.actions;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;
import java.awt.event.ActionEvent;

public class SuperscriptAction extends StyledEditorKit.StyledTextAction {

    public SuperscriptAction() {
        super(StyleConstants.Superscript.toString());
    }

    public void actionPerformed(ActionEvent actionEvent) {
        JEditorPane editor = getEditor(actionEvent);
        if (editor != null) {

            // MutableAttributeSet - Общий интерфейс для изменяемой коллекции уникальных атрибутов.
            // getStyledEditorKit - Получает набор редактора, связанный с панелью редактора.
            // getInputAttributes - Получает входные атрибуты для панели.
            // Когда курсор перемещается и нет выделения, входные атрибуты автоматически изменяются,
            // чтобы отразить атрибуты символа текущего местоположения курсора.
            // Стилизованные действия редактирования используют атрибуты ввода для выполнения своих действий.
            MutableAttributeSet mutableAttributeSet = getStyledEditorKit(editor).getInputAttributes();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setSuperscript(simpleAttributeSet, !StyleConstants.isSuperscript(mutableAttributeSet));
            setCharacterAttributes(editor, simpleAttributeSet, false);
        }
    }
}
