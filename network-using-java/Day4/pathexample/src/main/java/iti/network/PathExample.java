package iti.network;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

    public static void main(String[] args) {
        String originalPath = "E:\\Java\\Module-Example\\..\\src\\packt.addressbook\\";
        //Path path = Paths.get ("c:\\data\\myfile.txt");
        Path path1 = Paths.get (originalPath);
        //System.out.println ("path = " + path);
        System.out.println ("path1 = " + path1);
        Path path2 = path1.normalize ();
        System.out.println ("path2 = " + path2);

        /*// Using Files to create directories
        *//*Path path3 = Paths.get ("TestDir");

        try {
            Path newDir = Files.createDirectory (path3);
        } catch (FileAlreadyExistsException e) {*//*
// the directory already exists.
            e.printStackTrace ();
        } catch (IOException e) {
// something else went wrong
            e.printStackTrace ();
        }*/
// Copying a file from one path to another
        Path sourcePath = Paths.get ("test.txt");
        Path destinationPath = Paths.get ("logging-copy.properties");

        try {
            Files.copy (sourcePath, destinationPath);
        } catch (FileAlreadyExistsException e) {
// destination file already exists
        } catch (IOException e) {
// something else went wrong
            e.printStackTrace ();
        }

    }
}