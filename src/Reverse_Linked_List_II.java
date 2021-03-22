import java.util.List;
import java.util.Stack;

public class Reverse_Linked_List_II {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        Stack<Integer> temp=new Stack<>();
        ListNode newhead=new ListNode(-1,head);
        ListNode start=head;
        ListNode le=null;
        ListNode ri=null;

        for (int i = 1; start!=null; i++,start=start.next) {
            if (left==i){
                le=start;
            }
            if (right==i){
                ri=start;
            }
            if (le!=null&&ri==null){
                temp.push(start.val);
            }
        }
        temp.push(ri.val);
        while (le!=ri.next){
            le.val=temp.pop();
            le=le.next;
        }

        return newhead.next;

    }


}
