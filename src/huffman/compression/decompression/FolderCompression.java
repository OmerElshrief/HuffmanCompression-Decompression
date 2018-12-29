/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman.compression.decompression;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author Omar
 */
public class FolderCompression
{
    private class someException extends IOException {
    
}

    public void FolderCompression() throws IOException 
    {
        Path output = Paths.get("merged.txt");
        Path directory = Paths.get("texts");
        Stream<Path> filesToProcess = Files.list(directory);

        // Iterate all files
        filesToProcess.forEach(path -> {
             try
             {
                 // Get all lines of that file
                 Stream<String> lines = Files.lines(path);
                 // Iterate all lines
                 lines.forEach(line -> {
                     // Append the line separator
                     String lineToWrite = line ;
                     
                     try
                     {
                         // Write every line to the output file
                         Files.write(output, lineToWrite.getBytes(StandardCharsets.UTF_8));
                     } catch (IOException ex)
                     {
                         Logger.getLogger(FolderCompression.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 });
             } catch (IOException ex)
             {
                 Logger.getLogger(FolderCompression.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
    }

}
