package test;

import Matrix.ZerosOnesMultiply;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class OnesZerosMatrices {
    @Test
    public void multiplyMatrices(){
        ZerosOnesMultiply zeroOne = new ZerosOnesMultiply();
        int[][] arr1 = {{1,1},{1,1},{1,1}};
        int[][] arr2 = {{0,0,0},{0,0,0}};
        int[][] actual = {{0,0,0},{0,0,0},{0,0,0}};

        int[][] expected = zeroOne.resultMatrix(arr1,arr2);
        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void multiplyLargeSize(){

    }
}
