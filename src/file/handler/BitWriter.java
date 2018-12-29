package file.handler;


import java.io.*;

public class BitWriter {
    private FileOutputStream output;
    private int bitsBuffer;     // a buffer used to build up next set of digits
    private int bitsCounter;  // how many digits are currently in the buffer

    private static final int BYTE_SIZE = 8;  // digits per byte

   
    public BitWriter(String file) {
        try {
            output = new FileOutputStream(file);
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
        bitsBuffer = 0;
        bitsCounter = 0;
    }

    // post: writes given bit to output
    public void writeBit(int bit) throws IOException {
        if (bit < 0 || bit > 1)
            throw new IllegalArgumentException("Illegal bit: " + bit);
      //  System.out.print(bit);
        bitsBuffer += bit << bitsCounter;
        bitsCounter++;
        if (bitsCounter == BYTE_SIZE)
            flush();
    }

   
    public void flush() throws IOException {
        
            output.write(bitsBuffer);
              
        
        bitsBuffer = 0;
        bitsCounter = 0;
    }
    
    public void writeChar(char ch) throws IOException
    {
        output.write(ch);
     
       
    }
    public void writeByte(byte ch) throws IOException
    {
        output.write(ch);
     
       
    }

    // post: output is closed
    public void close() throws IOException {
        if (bitsCounter > 0)
            flush();
           output.close();
      
    }

    
}