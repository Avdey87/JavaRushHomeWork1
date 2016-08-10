package com.javarush.test.level25.lesson16.big01;

/**
 * Created by aavdeev on 08.08.2016.
 */
public class Ufo extends BaseObject
{
    @Override
    public void move()
    {
        super.move();
    }

    @Override
    public void draw(Canvas canvas)
    {
        super.draw(canvas);
    }

    public void fire()
    {

    }

    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1},
    };
    public Ufo(double x, double y, double radius)
    {
        super(x, y, radius);
    }
}
