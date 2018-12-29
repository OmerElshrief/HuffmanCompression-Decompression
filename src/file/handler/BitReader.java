/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.handler;

// The BitOutputStream and BitInputStream classes provide the ability to
// write and read individual bits to a file in a compact form.  One major
// limitation of this approach is that the resulting file will always have
// a number of bits that is a multiple of 8.  In effect, whatever bits are
// output to the file are padded at the end with 0's to make the total
// number of bits a multiple of 8.
//
// BitInputStream has the following public methods:
//     public BitInputStream(String file)
//         opens an input stream with the given file name
//     public int readBit()
//         reads the next bit from input (-1 if at end of file)
//     public void close()
//         closes the input

import java.io.*;

public class BitReader {
    private FileInputStream input;
    private int digits;     // next set of digits (buffer)
    private int numDigits;  // how many digits from buffer have been used

    private static final int BYTE_SIZE = 8;  // digits per byte

    // pre : given file name is legal
    // post: creates a BitInputStream reading input from the file
    public BitReader(String file) {
        try {
            input = new FileInputStream(file);
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
        nextByte();
    }

    // post: reads next bit from input (-1 if at end of file)
    public int readBit() {
        // if at eof, return -1
        if (digits == -1)
            return -1;
        int result = digits % 2;
        digits /= 2;
        numDigits++;
      //  System.out.print(result);
        if (numDigits == BYTE_SIZE)
            nextByte();
        return result;
    }
    
    
    
    /*
        In header file the indication for the end of the huffmanTree is 2 consecutive 1s
        This function test the next bit in sequence without reading it.
    */
    public int nextBitCheck(){
       
        int result = digits % 2;
        return result;
    }
    
    public char readChar() throws IOException{
        nextByte();
        char ch = (char) digits;
        nextByte();
        return ch;
    }

    // post: refreshes the internal buffer with the next BYTE_SIZE bits
    public void nextByte() {
        try {
            digits = input.read();
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
        numDigits = 0;
    }
    
    public void nextByte1() {
        try {
            digits = Integer.valueOf(Integer.toBinaryString(0xFF & input.read() | 0x100).substring(1));
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
        numDigits = 0;
    }

    // post: input is closed
    public void close() {
        try {
            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e.toString());
        }
    }

    // included to ensure that the stream is closed
    protected void finalize() {
        close();
    }
}