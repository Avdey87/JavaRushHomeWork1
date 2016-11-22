package com.javarush.test.level36.lesson04.big01.model;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model
{
    private ModelData modelData = new ModelData();
    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    public ModelData getModelData()
    {
        return null;
    }

    @Override
    public void loadUsers()
    {

        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
    }


}
