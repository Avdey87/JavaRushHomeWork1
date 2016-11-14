package com.javarush.test.level34.lesson15.big01.model;


import java.awt.*;

public class Wall extends CollisionObject
{
    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.DARK_GRAY);
        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;

        graphics.drawRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
        graphics.fillRect(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
    }

    public Wall(int x, int y)
    {
        super(x, y);
    }
}
