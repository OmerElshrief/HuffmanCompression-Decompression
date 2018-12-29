/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman.compression.decompression.filefactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Omar
 */
public class FileWriter
{
    private FileOutputStream writer;
    int bitsBuffer=0;
    int noOfBits=0;
    
    public FileWriter(String compressedFile) throws FileNotFoundException {
       
            writer = new FileOutputStream(compressedFile);
       
       
    }
    
    public void writeToFile() throws IOException{
        writer.write(bitsBuffer);
        noOfBits=0;
        bitsBuffer = 0;
        
    }
    
    public void writeBitTobuffer(int bit) throws IOException{
        
        bitsBuffer += bit << noOfBits++;
        
        if(noOfBits == 8) //8 is size oc a character
            writeToFile();
    }
}
