package com.lesson36.task3608;

import com.lesson36.task3608.controller.Controller;
import com.lesson36.task3608.model.MainModel;
import com.lesson36.task3608.model.Model;
import com.lesson36.task3608.view.EditUserView;
import com.lesson36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        editUserView.setController(controller);

        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUsersEditForm(126L);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("New name", 126L, 73);
        usersView.fireEventShowDeletedUsers();
    }
}
