package com.day02.javacollectiontesting;
import com.day02.queueinterface.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueInterfaceTesting {

    //Create a method generateBinaryNumberTest to perform testing on binary number
    @Test
    public void generateBinaryNumberTest() {
        //call the method generateBinaryNumbers
        String[] binaryNumberResult = GenerateBinaryNumbers.generateBinaryNumbers(5);
        //Create an expectedString binary number
        String[] binaryNumberExpected = new String[]{"1", "10", "11", "100", "101"};
        //compare actual result and expectedResult
        Assertions.assertArrayEquals(binaryNumberExpected, binaryNumberExpected);
    }


    //Create a method testPush to perform testing on push operation of stack
    @Test
    public void testPush() {
        //Create a expected stack to store expected value
        Stack<Integer>extepecedStack=new Stack<>();
        extepecedStack.push(3);
        extepecedStack.push(2);
        extepecedStack.push(1);

        //Create an obejct of ImplementStackUsingQueues class for access their method
        ImplementStackUsingQueues stackResult = new ImplementStackUsingQueues();
        stackResult.push(1);
        stackResult.push(2);
        stackResult.push(3);

        //compare actual result and expectedResult
        assertEquals(extepecedStack, stackResult.displayStack());
    }
}
