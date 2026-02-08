package iti.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExplicitWrite{

    public static void main(String[] args) {
        Path filePath = null;
        try{
            filePath = Paths.get("test.txt");
        }
        catch(InvalidPathException e){
            e.printStackTrace();
            return;
        }
        try(FileChannel channel = (FileChannel) Files.newByteChannel(filePath,StandardOpenOption.CREATE,
            StandardOpenOption.WRITE,StandardOpenOption.APPEND))
        {
            ByteBuffer buffer = ByteBuffer.allocate(24);
            for(int i=0; i<24 ;i++){
                buffer.put((byte)('A'+i));
            }
            buffer.rewind();
            channel.write(buffer);
        }
        catch(IOException e){
                e.printStackTrace();
            }
        }
    }
