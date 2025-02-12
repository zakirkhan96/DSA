package Array;

public class FindingSumOfIndexArray {

    public static void findTarget(int[] arr , int target){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("The Sum of " + target + " element in array is: " + arr[i] + " and " + arr[j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0 , 3 , 4 , 5 , 9};

        findTarget(arr , 9);
    }
}