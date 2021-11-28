package com.lesson36.task3608.model;

public interface Model {

    ModelData getModelData();

    void loadUsers();

    void loadDeletedUsers();

    void loadUserById(long userId);

    void deletedUserById(long id);
    void changeUserData(String name, long id, int level);



}
