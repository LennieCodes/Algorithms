package treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class Permutations {
    public static ArrayList<LinkedList<Integer>> permute(int[] arr){
        ArrayList<LinkedList<Integer>> permutationList = new ArrayList<LinkedList<Integer>>();
        permuteHelper(arr, 0, permutationList);

        return permutationList;
    }
    
    private static ArrayList<LinkedList<Integer>> permuteHelper(int[] arr, int index, 
        ArrayList<LinkedList<Integer>> permutationList) {
        if(index >= arr.length - 1){ //If we are at the last element - nothing left to permute
            //System.out.println(Arrays.toString(arr));
            //Print the array
            LinkedList<Integer> permutation = new LinkedList<Integer>();
            for(int i = 0; i < arr.length; i++){
                permutation.add(arr[i]);
            }
            
            permutationList.add(permutation);

            return permutationList;
        }
    
        for (int i = index; i < arr.length; i++) { //For each index in the sub array arr[index...end]
    
            //Swap the elements at indices index and i
            int t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
    
            //Recurse on the sub array arr[index+1...end]
            permutationList = permuteHelper(arr, index+1, permutationList);
    
            //Swap the elements back
            t = arr[index];
            arr[index] = arr[i];
            arr[i] = t;
        }

        return permutationList;
    }
    
}