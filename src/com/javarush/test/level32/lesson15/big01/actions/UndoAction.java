package com.javarush.test.level32.lesson15.big01.actions;

import com.javarush.test.level32.lesson15.big01.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.AbstractList;

public class UndoAction extends AbstractAction
{
    private View view;

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

    public UndoAction(View view)
    {

        this.view = view;
    }
}
