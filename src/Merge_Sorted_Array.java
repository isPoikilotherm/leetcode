public class Merge_Sorted_Array {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m-1; i >=0; i--) {
            nums1[n+i]=nums1[i];
        }
        int i=n,j=0,tag=0;
        while (i<m+n&&j<n){
            if (nums1[i]<nums2[j]){
                nums1[tag]=nums1[i];
                i++;
            }else {
                nums1[tag]=nums2[j];
                j++;
            }
            tag++;
        }
        while (j<n){
            nums1[tag]=nums2[j];
            j++;
            tag++;
        }
        while (i<m+n){
            nums1[tag]=nums1[i];
            i++;
            tag++;
        }

    }

    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }

}
