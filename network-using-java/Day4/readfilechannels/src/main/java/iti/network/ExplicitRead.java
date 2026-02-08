package iti.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExplicitRead {

    public static void main(String[] args) {
        int count;
        Path filePath = null;
        try{
            filePath = Paths.get("test.txt");
            
        }
        catch(InvalidPathException e){
            e.printStackTrace();
            return;
        }
        try(SeekableByteChannel channel = Files.newByteChannel(filePath)){
            ByteBuffer buffer = ByteBuffer.allocate(128);
            do{
                count = channel.read(buffer);
                if(count != -1){
                    buffer.rewind();
                    for(int i=0; i<count; i++){
                        System.out.print((char)buffer.get());
                    }
                    System.out.println();
                }
            }while(count!=-1);
        }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
