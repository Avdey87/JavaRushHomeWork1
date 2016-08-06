package com.javarush.test.level24.lesson14.big01;

/**
 * Created by aavdeev on 05.08.2016.
 */
public class Canvas
{
    private int width;
    private int height;
    private char matrix[][];

    public Canvas(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.matrix = new char[width][height];
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
    public char[][] getMatrix()
    {
        return matrix;
    }
    public void setPoint(double x, double y, char c){
        int ix = (int)Math.round(x), iy = (int)Math.round(y);
        if(ix >= 0 && ix < matrix[0].length && iy >= 0 && iy < matrix.length)
            matrix[iy][ix] = c;
    }
    public void drawMatrix(double x, double y, int[][] matrix, char c){
        for(int i = 0;i < matrix.length;i++)
        {
            for (int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] != 0)
                    setPoint(x+j, y+i, c);
            }
        }
    }
}
