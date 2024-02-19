package test;

import java.io.Serializable;

public class RandomTest implements Serializable{
    int[] arr;
    private String str;

    public RandomTest(int[] arr) {
        this.arr = arr;
        this.str = arrayToString(arr);
    }

    private String arrayToString(int[] A){
        StringBuilder sb = new StringBuilder();
        if(A.length < 1){
            throw new IllegalArgumentException("Array must not be empty");
        }
        else{
            sb.append(A.length + ": [");
        }
        for(int i=0; i<A.length-1; i++){
            sb.append(A[i] + ", ");
        }
        sb.append(A[A.length-1]);
        sb.append("]\n");
        return sb.toString();
    }

    public String getString() {
        return this.str;
    }
  
}
