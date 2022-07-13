
package com.mycompany.sampleblockchain;

import java.util.Arrays;


public class BlockChain {
    
    public static void main(String[] args) {

        /*

        BlockChain -
        Block - Hash of Previous Block + Transactions
        Chained together.

         */

        Transaction transaction1 = new Transaction("Niro", "Sanjula", 100L);
        Transaction transaction2 = new Transaction("Ashaka", "Mark", 1000L);
        Transaction transaction3 = new Transaction("Sanjula", "Ashaka", 1000L);
        Transaction transaction4 = new Transaction("Mark", "Niro", 150L);

        Block firstBlock = new Block(0, Arrays.asList(transaction1, transaction2));
        System.out.println(firstBlock.hashCode());
        Block secondBlock = new Block(firstBlock.hashCode(), Arrays.asList(transaction3));
        System.out.println(secondBlock.hashCode());
        Block thirdBlock = new Block(secondBlock.hashCode(), Arrays.asList(transaction4));
        System.out.println(thirdBlock.hashCode());

    }
    
}
