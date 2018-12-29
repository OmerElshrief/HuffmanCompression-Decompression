/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman.compression.decompression;

import java.util.Comparator;

/**
 *
 * @author Omar
 */
class HuffmanComparetorBinary implements Comparator<HuffmanNodeBinary> { 
    @Override
    public int compare(HuffmanNodeBinary x, HuffmanNodeBinary y) 
    { 
  
        return x.getW()- y.getW(); 
    } 
} 