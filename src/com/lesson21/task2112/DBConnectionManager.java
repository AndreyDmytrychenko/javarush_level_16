package com.lesson21.task2112;

public class DBConnectionManager {
    public  FakeConnection getFakeConnection() {
        return new FakeConnection();
    }
}
