package iti.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MapChannelRead {

    public static void main(String[] args) {

        try(FileChannel channel =(FileChannel) Files.newByteChannel(Paths.get("test.txt"))){

            long fileSize = channel.size();
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY,0,fileSize);
            for(int i=0;i<fileSize;i++){
                System.out.print((char)buffer.get());
            }
            System.out.println();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
