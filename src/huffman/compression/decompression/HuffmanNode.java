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
public class HuffmanNode
{
    int w;
    char data;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int w, char data)
    {
        this.w = w;
        this.data = data;
        left = null;
        right = null;
    }

    public HuffmanNode(int w, HuffmanNode left, HuffmanNode right)
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

    public char getData()
    {
        return data;
    }

    public void setData(char data)
    {
        this.data = data;
    }

    public HuffmanNode getLeft()
    {
        return left;
    }

    public void setLeft(HuffmanNode left)
    {
        this.left = left;
    }

    public HuffmanNode getRight()
    {
        return right;
    }

    public void setRight(HuffmanNode right)
    {
        this.right = right;
    }
    
    
}
