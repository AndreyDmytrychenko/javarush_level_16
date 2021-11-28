package com.lesson32.task3209.listeners;

import com.lesson32.task3209.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//Этот класс будет слушать и обрабатывать изменения состояния панели вкладок.

public class TabbedPaneChangeListener implements ChangeListener {


    private View view;

    public TabbedPaneChangeListener(View view) {
        this.view = view;
    }



    @Override
    public void stateChanged(ChangeEvent e) {
        view.selectedTabChanged();
    }
}