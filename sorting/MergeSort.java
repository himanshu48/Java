// Merge Sort
// Time Complexity O(nlogn)
// Space Complexity O(n)

import java.util.Arrays;
class MergeSort{

    void merge(int[] arr, int start, int mid, int end){
        int l = mid-start+1;
        int r = end-mid;
        int[] leftArray = new int[l];
        int[] rightArray = new int[r];

        for(int i=0; i<l; i++){
            leftArray[i] = arr[start+i];
        }
        for (int i=0; i<r; i++){
            rightArray[i] = arr[mid+i+1];
        }

        int i=0, j=0;
        int k = start;
        while (i<l && j<r){
            if (leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            } else{
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i<l){
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j<r){
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    void sort(int[] arr, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void main(String args[]){
        int arr[] = {90,23,101,45,65,23,67,89,34,23};
        MergeSort obj = new MergeSort();
        obj.sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
