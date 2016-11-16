package com.javarush.test.level36.lesson04.model;


import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.List;

public class ModelData
{
    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }

    private List<User> users;
}
