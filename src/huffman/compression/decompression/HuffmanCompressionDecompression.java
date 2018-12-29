///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package huffman.compression.decompression;
//
//import file.handler.BitWriter;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.BitSet;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.stream.Stream;
//
///**
// *
// * @author Omar
// */
//public class HuffmanCompressionDecompression
//{
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) throws FileNotFoundException, IOException
//    {
//        
//        Path output = Paths.get("merged.txt");
//        Path directory = Paths.get("texts");
//        Stream<Path> filesToProcess = Files.list(directory);
//
//        // Iterate all files
//        filesToProcess.forEach(path -> {
//             try
//             {
//                 // Get all lines of that file
//                 Stream<String> lines = Files.lines(path);
//                 // Iterate all lines
//                 lines.forEach(line -> {
//                     // Append the line separator
//                     String lineToWrite = line ;
//                     
//                     try
//                     {
//                         // Write every line to the output file
//                         Files.write(output, lineToWrite.getBytes(StandardCharsets.UTF_8));
//                     } catch (IOException ex)
//                     {
//                         Logger.getLogger(FolderCompression.class.getName()).log(Level.SEVERE, null, ex);
//                     }
//                 });
//             } catch (IOException ex)
//             {
//                 Logger.getLogger(FolderCompression.class.getName()).log(Level.SEVERE, null, ex);
//             }
//        });
//        
//        
//        
//    }
////          FileCompressor compressor = new FileCompressor();
////            compressor.compress("gpa.png");
////
////        File f = new File("gpa.png");
////        FileInputStream fis = new FileInputStream(f);
////        byte[] bytes = new byte[(int) f.length()];
////        
////        for (int i = 0; i < bytes.length; i++)
////        {
////            String bin = Integer.toBinaryString(0xFF & fis.read() | 0x100).substring(1);
////            System.out.println(bin);
////        }
////
////        System.out.println("\nDecompression");
////        System.out.println("\n Reading");
////        FileDecompressor deCompressor = new FileDecompressor("gpa.png.cmp");
////        deCompressor.readHuffmantree();
////    }
//
//}
