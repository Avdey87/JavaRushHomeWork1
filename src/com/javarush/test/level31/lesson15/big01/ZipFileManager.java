package com.javarush.test.level31.lesson15.big01;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager
{
    private Path zipFile;

    public ZipFileManager(Path zipFile)
    {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception{
        try ( ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile)))
        {
            try( InputStream inputStream = Files.newInputStream(source))
            {
                ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
                zipOutputStream.putNextEntry(zipEntry);
                byte[] buf = new byte[1024];
                while (inputStream.available() > 0) {
                    int size = inputStream.read(buf);
                    zipOutputStream.write(buf, 0, size);
                }
                zipOutputStream.closeEntry();
            }
        }
    }
}
