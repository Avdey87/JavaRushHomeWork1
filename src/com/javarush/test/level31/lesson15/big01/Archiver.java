package com.javarush.test.level31.lesson15.big01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver
{
    public static void main(String[] args) throws Exception
    {
        System.out.println("Введите полный путь к файлу архива (куда будем сжимать): ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String archivePath = reader.readLine();
        ZipFileManager zipFileManager = new ZipFileManager(Paths.get(archivePath));
        System.out.println("Введите путь к файлу, который будем архивировать (что будем сжимать): ");
        BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
        String archivedFile = fileNameReader.readLine();
        zipFileManager.createZip(Paths.get(reader.readLine()));
    }
}