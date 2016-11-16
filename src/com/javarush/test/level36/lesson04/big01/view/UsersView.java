package com.javarush.test.level36.lesson04.big01.view;


import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

public class UsersView implements View
{

    Controller controller;

    public void fireEventShowAllUsers()
    {
        controller.onShowAllUsers();
    }

    @Override
    public void refresh(ModelData modelData)
    {
        System.out.println("All users:");
        for(User u : modelData.getUsers())
        {
            System.out.println(String.format("\t%s", u.toString()));
        }
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }
}
