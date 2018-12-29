/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman.compression.decompression;

import file.handler.BitReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Omar
 */
public class FileDecompressor
{

    private static final int BYTE_SIZE = 8;  // digits per byte
    BitReader reader;
    BufferedWriter out;
    TreeBuilder treeBuilder;
    int bitCounter = 0;
    int counter = 0;
    char ch;

    public FileDecompressor(String fileName) throws IOException
    {
        reader = new BitReader(fileName);
        out = new BufferedWriter(new FileWriter("textuncom.txt"));
        treeBuilder = new TreeBuilder();
        // int size = reader.readChar();
        HuffmanNode node = readHuffmantree();
        HashMap<Character, String> huffmanMap = new HashMap();
        treeBuilder.getHuffmanMap(node, "", huffmanMap);
      //  System.out.println(huffmanMap);
        // We have to read (flush) thw twon indication bits 
        reader.readBit();
        reader.readBit();
        decompress(node);

    }

    public HuffmanNode readHuffmantree() throws IOException
    {

        HuffmanNode root = null;

        //Phase 1.1 Read from the file the size of the Huffman tree
        int bit = reader.readBit();

        if (bit == 1)
        {
               System.out.print(bit);
            if (reader.nextBitCheck() == 1)
            {
                //reader.readBit();
                //reader.readBit();
                return root;
            }
            ch = reader.readChar();
            System.out.print(ch);
            bitCounter = 0;
            root = new HuffmanNode(1, ch);
        } else
        {
             System.out.print("0");
            root = new HuffmanNode(1, '-');
            root.left = readHuffmantree();
            root.right = readHuffmantree();
        }
        return root;

    }

    public void decompress(HuffmanNode treeRoot) throws IOException
    {
        HuffmanNode node = treeRoot;
        int bit;
        while (true)
        {
            if (node.left == null && node.right == null)
            {
                out.append(node.getData());
              //  System.out.println(node.getData());
                node = treeRoot;
            } else
            {
                bit = reader.readBit();
                //  System.out.println(bit);
                if ((int) bit == -1)
                {
                    System.err.println("EOF");
                    break;
                }

                if (bit == 0)
                {
                    node = node.left;
                } else
                {
                    node = node.right;
                }
            }
        }
        out.close();
    }
    
    private static String removeCompresses(String str) {
    return str.substring(0, str.length() - 4);
}
}
