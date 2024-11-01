package com.example.menuManagement.algoTest;

public class Bubble {

    public static void main(String[] args) {
        //Each pass compares elements from the beginning of the array up to the unsorted portion.
        //The i variable does not dictate the starting point; it controls how many elements
        // are excluded from comparisons because they are already sorted:

        // outer loop controls the reduction in the number of inner loop iterations,
        // and how the sorting progresses with each pass.
        int[] arr = {9,1,8,2,7,3,6,4,5};

        bubbleSort(arr);

        for (int a : arr){
            System.out.print(a + " ");
        }

    }

    //j < ar.length-i-1 = j < 9-0-1; i.e j < 8
    //j < 9-1-1; i.e j < 7
    //j < 9-2-1; i.e j < 6
    public static void bubbleSort (int[] ar){
        //Nested forloop
        for (int i = 0; i<= ar.length-1;++i){
            for (int j = 0; j< ar.length-i-1;++j){
                if(ar[j] > ar[j+1]){
                    int temp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = temp;
                }
            }
        }
    }

    //Here is my understanding: the outer loop will be iteated ar.length-1 times, while for each outer loop
    //iteration, the inner loop also iterates but for ar.length-i-1 times.
    //so with int[] arr = {9,1,8,2,7,3,6,4,5};, the outer loop starts from index zero which has the element 9
    //The inner loop also begins from index zero, which holds element 9. A condition is set to check if
    //index 0 is less than ar.length-i-1 (9-0-1 =8).And 0 passes the condition. Now we check if 9 is greater than
    //1 and the necessary swaps are made. So we have {1,9,8,2,7,3,6,4,5}.

    //Next the index j increases by 1 so j becomes index 1.So we compare the element 9 at index 1 with 8 at index
    //ar[j+1]. Also at this point i remains at index 0. Thus ar.length-0-1 (9-0-1). Result {1,8,9,2,7,3,6,4,5}.

    //Next the index j increases by 1, so j becomes index 2.We check if 2< (9-0-1), and the condition executes
    //to true. Result {1,8,2,9,7,3,6,4,5}. This continues until We carryout a linear comparison
    //of the element 9 against each element in the array. When result is {1,8,2,7,3,6,4,5,9}

    //Now we go to the outer loop and increment it by 1, taking it from index 0 to index 1. With i at
    //index 1, the element at index i  is 8. So we begin comparison of element at index j which starts at index 0
    //against the elememt at index j++. Element at index j when j is at index 0 is 1. And the element at j++, is 8
    //The condition  (9-1-1) returns 7. There will be no swap because 1 is lesser than 8. Result {1,8,2,7,3,6,4,5,9}
    //
    // Next, the index j increases from 0 to 1. 8 which is the element at index 1 is compared with 2 which is the
    //element at index j++. Result {1,2,8,7,3,6,4,5,9}

    //1.Is my explanation correct. 2.


}
