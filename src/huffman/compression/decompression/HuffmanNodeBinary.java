/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman.compression.decompression;

/**
 *
 * @author Omar
 */
public class HuffmanNodeBinary
{
    int w;
    String data;
    HuffmanNodeBinary left;
    HuffmanNodeBinary right;

    public HuffmanNodeBinary(int w, String data)
    {  
        this.w = w;
        this.data = data;
        left = null;
        right = null;
    }

    public HuffmanNodeBinary(int w, HuffmanNodeBinary left, HuffmanNodeBinary right)
    {
        this.w = w;
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    

    public int getW()
    {
        return w;
    }

    public void setW(int w)
    {
        this.w = w;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public HuffmanNodeBinary getLeft()
    {
        return left;
    }

    public void setLeft(HuffmanNodeBinary left)
    {
        this.left = left;
    }

    public HuffmanNodeBinary getRight()
    {
        return right;
    }

    public void setRight(HuffmanNodeBinary right)
    {
        this.right = right;
    }
    
    
}
