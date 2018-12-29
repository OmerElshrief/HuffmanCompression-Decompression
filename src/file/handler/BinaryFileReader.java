package file.handler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BinaryFileReader
{

    public BinaryFileReader()
    {

    }

    /**
     * Read the given binary file, and return its contents as a byte array.
     */
    public byte[] read(String inputFileName) throws IOException
    {

        File file = new File(inputFileName);
        byte[] result = new byte[(int) file.length()];

        int totalBytesRead = 0;
        InputStream input = new BufferedInputStream(new FileInputStream(file));
        while (totalBytesRead < result.length)
        {
            int bytesRemaining = result.length - totalBytesRead;
            //input.read() returns -1, 0, or more :
            int bytesRead = input.read(result, totalBytesRead, bytesRemaining);

            if (bytesRead > 0)
            {
                totalBytesRead = totalBytesRead + bytesRead;
            }
               

               
        }
           
         input.close();
        return result;
    }
    
    
    
    public void write(byte[] input, String outputFileName) throws FileNotFoundException, IOException
    {
        
                      
               OutputStream output = new BufferedOutputStream(new FileOutputStream(outputFileName));
                output.write(input);
           
                output.close();
            
       
    }
    
}

   