package leetcode;

public class Remove_Duplicates_from_Sorted_List_II {

    public ListNode deleteDuplicates(ListNode head) {

        if (head==null||head.next==null){
            return head;
        }

        ListNode newhead=new ListNode(101,head);

        ListNode start=newhead;
        ListNode font=head;
        ListNode back=head.next;
        while (font!=null&&back!=null){
            if (font.val!=back.val){
                start.next=font;
                start=start.next;
                font=font.next;
                back=back.next;
            }else {
                while (back!=null&&font.val==back.val){
                    back=back.next;
                }
                if (back==null){
                    start.next=back;
                    return newhead.next;
                }else {
                    font=back;
                    back=back.next;
                }
            }
        }
        start.next=font;

        return newhead.next;


    }
}
