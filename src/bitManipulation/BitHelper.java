package bitManipulation;

public class BitHelper {
    /*
        This method shifts 1 over by i bits (from right to left), creating
        a value that looks like 00010000. By performing an AND operation 
        with num, it clears all the bits except for the bit at position i.
        Finally, we compare that value to 0. If the result is not 0, then
        we have a 1 at position i. Otherwise, we have a 0 at i.
    */
    public static boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }
    /*
        setBit shifts 1 over by i bits, creating a value that looks like
        00010000. By performing an OR with num, all bits in num
        stay unchanged, except for the bit at position i. That
        bit will be set to 1. (If you think about truth tables, 1 | 0
        is 1, and 1 | 1 is 1).
    */
    public static int setBit(int num, int i) {
        return num | (1 << i);
    }
    /*
        clearBit shifts 1 over by i, creating a value that looks like
        00010000 and then negates it. This creates a value like:
        11101111. By performing an AND operation with num, this will
        clear the Ith bit and leave everything else unchanged.
        
        If you had a num = 10011111 and you called clearBit with i
        = 5, mask would be 11101111. Performing an AND with num,
        you would get: 10001111. (Which is what you would expect,
        calling clearBit at position 5.
    */
    public static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }
    
    public static int clearBitsMSBthroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    public static int clearBitsIthrough0(int num, int i) {
        int mask = (-1 << (i + 1));
        return num & mask;
    }
    /*



    */
    public static int updateBit(int num, int i, boolean bitIs1) {
        int value = bitIs1 ? 1 : 0;
        int mask = ~(1 << i);
        return (num & mask) | (value << 1);
    }


}