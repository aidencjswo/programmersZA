package com.aiden.zoe;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class 제일작은수제거하기 {
    public static void main(String[] args) {
        Solve s = new Solve();

        int[] arr = {4,3,2,1};

        System.out.println("answer :: "+ s.method1(arr));
    }
}

class Solve{
    public int[] method1(int[] arr){
        int[] answer;


        if(arr.length == 1){
            answer = new int[] {-1};
            return answer;
        }else{
            // arr 배열에서 가장 작은 수 채번
            int num = Arrays.stream(arr).min().getAsInt();

            System.out.println(num);

            OptionalInt index = IntStream.range(0, arr.length)
                    .filter(i -> arr[i] == num)
                    .findFirst();

            System.out.println(index);

            if(index.getAsInt() == arr.length-1){
                answer =  new int[1];
                answer = Arrays.copyOfRange(arr,0,arr.length-2);
                int[] arr1 = Arrays.copyOfRange(arr,0,index.getAsInt());
                int[] arr2 = Arrays.copyOfRange(arr,index.getAsInt()+1,arr.length);
                return answer = arr1;

            }else if(index.getAsInt() == 0){
                answer =  new int[1];
            }else{
                int[] arr1 = Arrays.copyOfRange(arr,0,index.getAsInt());
                int[] arr2 = Arrays.copyOfRange(arr,index.getAsInt()+1,arr.length);

                answer = new int[arr1.length+arr2.length];

                System.arraycopy(arr1,0,answer,0,arr1.length);
                System.arraycopy(arr2,0,answer,arr1.length,arr2.length);

            }
            return answer;
        }
    }
}
