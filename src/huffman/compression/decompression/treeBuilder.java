/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman.compression.decompression;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Omar
 */
public class treeBuilder
{
      LinkedHashMap<Character, Integer> charCountMap;
      HashMap<Character,String> huffmanMap ;

    public treeBuilder()
    {
       charCountMap = new LinkedHashMap<Character, Integer>();
       huffmanMap = new HashMap();
    }
    
    
    //Function to get the Frequency of each character in the File and store it in the charCountMap;
     public void getCharFrequency(String file) throws FileNotFoundException, IOException
     {
        File file1 = new File(file);
        BufferedReader in = new BufferedReader(new FileReader(file1));
        System.out.println("Letter Frequency");

        int nextChar;
        char ch;

        while ((nextChar = in.read()) != -1)
        {
            ch = ((char) nextChar);
            if (charCountMap.containsKey(ch))
            {

                // If char is present in charCountMap, 
                // incrementing it's count by 1 
                charCountMap.put(ch, charCountMap.get(ch) + 1);
            } else
            {

                // If char is not present in charCountMap, 
                // putting this char to charCountMap with 1 as it's value 
                charCountMap.put(ch, 1);
            }
        }
        in.close();
        // Printing the charCountMap 
        for (Map.Entry entry : charCountMap.entrySet())
        {
            System.out.println(entry.getKey() + "=> " + entry.getValue());
        }
     }
     
     
     //After building the tree, we may build a map to assign each character a sequence of bits
     private void getHuffmanMap(HuffmanNode root,String code)
     {
        
         if(root.left==null && root.right==null) //This is a leaf node 
              huffmanMap.put(root.getData(), code);
         else{
         getHuffmanMap(root.left , code + "0");
         getHuffmanMap(root.right , code + "1");}
         
     }
     
     public void buildHuffmantree(String file) throws IOException
     {
         
         getCharFrequency(file);
         //Minimum heap to store the Nodes and to extract minimum nodes
         PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>(charCountMap.size(), new HuffmanComparetor());
         ArrayList<Character> data = new ArrayList(charCountMap.keySet());
         ArrayList<Integer> weights = new ArrayList(charCountMap.values());
         
         //Creating a node with data and weight for each character
         for(int i=0;i<charCountMap.size();i++)
         {
             queue.add(new HuffmanNode(weights.get(i),data.get(i)));
         }
         
         HuffmanNode rootNode=null;
         
         //Building hte tree
         while(queue.size()>1)
         {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();
             
            HuffmanNode tempRootNode = new HuffmanNode(left.getW()+right.getW(),left,right);
            rootNode = tempRootNode;
             
            queue.add(tempRootNode);
           
                    
         }
         getHuffmanMap(rootNode,"");
         System.out.println(huffmanMap);
         
         
         
     }
     
     
}
