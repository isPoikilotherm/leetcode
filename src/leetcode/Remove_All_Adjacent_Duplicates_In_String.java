package leetcode;

public class Remove_All_Adjacent_Duplicates_In_String {


    public ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null||k==0){
            return head;
        }
        int count=1;
        ListNode tag=head;
        while (head.next!=null){
            count++;
            head=head.next;
        }
        head.next=tag;
        int n=count-k%count;
        for (int i = 0; i < n-1; i++) {
            tag=tag.next;
        }
        ListNode newhead=tag.next;
        tag.next=null;
        return newhead;
    }



    public static void main(String[] args) {
        int[][] a={{1,2},{3,5},{6,7},{8,10},{12,16}};


    }




}
