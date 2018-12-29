/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman.compression.decompression;

import file.handler.BinaryFileReader;
import file.handler.BitWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringJoiner;

/**
 *
 * @author Omar
 */
public class FileCompressorBinary
{

    BitWriter writer;
    
   
    HashMap<String, String> huffmanTreeMapBinary;

    public FileCompressorBinary()
    {
        huffmanTreeMapBinary = new HashMap();
    }

    public void compress(String fileNameToBeCompressed) throws IOException
    {

        BinaryFileReader in = new BinaryFileReader();
        byte[] ch = in.read(fileNameToBeCompressed);        //Carry each character in the file as Temp variable 
       
        char[] code; //To carry the Huffman code of each character
        writer = new BitWriter(fileNameToBeCompressed + ".cmp");

        
        TreeBuilder treeBuilder = new TreeBuilder();
        HuffmanNodeBinary rootNode = treeBuilder.buildHuffmantreeBinary(fileNameToBeCompressed);
        treeBuilder.getHuffmanMapBinary(rootNode, "", huffmanTreeMapBinary);
       
             
        
        
      
        //Now writing the Huffman tree to the header of the file
        System.out.println("Writing Tree");
        writeHuffmanTree(rootNode);
        System.out.println("Finished Wrting Tree");
       // After writing the huffmanTree Bits, we write 2 extra flagg bits to indicated the End of huffman tree.
        writer.writeBit(1);
        writer.writeBit(1);
        
       // System.out.print("\n");
       

        for(int i=0;i<ch.length;i++)
        {
            
            code = huffmanTreeMapBinary.get(ch[i]).toCharArray();

            for (char bit : code)
            {
                if (bit == '1')
                {
                    writer.writeBit(1);
                } else
                {
                    writer.writeBit(0);
                }
            }

        }

        writer.close();
        
       // long ratio;
      //  MainForm.getInstance().setCompressionRatio(new File(fileNameToBeCompressed+ ".cmp").length()*100 / new File(fileNameToBeCompressed ).length() );
    }

    /*
    Function to Write the Huffman tree in the header of the file
     */
    private void writeHuffmanTree(HuffmanNodeBinary node) throws IOException
    {

        // Write HuffMane tree in a postOrder traversal
        if (node.left == null && node.right == null) //leaf node
        {
            writer.writeBit(1);
            //System.out.print("1");  //checking purposes
            writer.flush();
            writer.writeByte(Byte.decode(node.getData()) );
          //  System.out.print("-"+node.getData()+"- ");  //checking purposes
        } else
        {
            writer.writeBit(0);
            //System.out.print("0");  //checking purposes
            writeHuffmanTree(node.left);
            writeHuffmanTree(node.right);
        }

        //writing two consecutive 1s to indicate the end on the HuffMan tree header
         
}
}
