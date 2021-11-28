package com.lesson36.task3608.model;

import com.lesson36.task3608.bean.User;
import com.lesson36.task3608.model.service.UserService;
import com.lesson36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model{

    private ModelData modelData = new ModelData();

    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {

        List<User> users = new ArrayList<User>();
        users.add(new User("A", 1, 1));
        users.add(new User("B", 2, 1));
        getModelData().setUsers(users);
    }

    @Override
    public void loadDeletedUsers()  {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deletedUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }


}
