class Solution {
    
    public int invCount(int[] arr, int left, int right){
        if(left==right){
            return 0;
        }
        // divide the array into two parts
        int mid=(left+right)/2;
        int a=invCount(arr,left,mid);
        int b=invCount(arr,mid+1,right);
        
        // merge the two parts
        int aWithb=mergeSort(arr,left,mid,right);
        return a+b+aWithb;
    }
    
    public int mergeSort(int[] arr,int left,int mid, int right){
        int count=0;
        int i=left;
        int j=mid+1;
        int k=0;
        
        int[] c=new int[right-left+1];
        while(i<=mid && j<=right){
            if((long) arr[i] > (long)2*arr[j]){
                count+=mid-i+1;
                j++;
            }
            else {
                i++;
            }
        }
        //using mergeSort to sort and update resultant array
        i=left;
        j=mid+1;
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                c[k]=arr[i];
                i++;
                k++;
            }
            else{
                c[k]=arr[j];
                j++;
                k++;
            }
        }
        while(i<=mid){
            c[k]=arr[i];
            k++;
            i++;
            
        }
        while(j<=right){
            c[k]=arr[j];
            j++;
            k++;
        }
       
        // copy back the merge elements to originL array
         k=0;
        for(int z=left;z<=right;z++){
            arr[z]=c[k];
            k++;
        }
        return count;
    }
    public int reversePairs(int[] arr) {
        return invCount(arr,0,arr.length-1);
    }
}