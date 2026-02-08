package iti.network;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample1 {

    public static void main(String[] args) {
        String originalPath = "d:\\data\\projects\\a-project\\..\\another-project";
        Path path = Paths.get("c:\\data\\myfile.txt");
        Path path1 = Paths.get(originalPath);
        System.out.println("path = " + path);
        System.out.println("path1 = " + path1);
        Path path2 = path1.normalize();
        System.out.println("path2 = " + path2);
    }}
