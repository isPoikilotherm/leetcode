import java.util.Stack;

public class Reverse_Nodes_in_kGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null||head.next==null||k==1){
            return head;
        }

        Stack<ListNode> stack=new Stack<>();
        ListNode newhead=new ListNode(0,null);
        ListNode rs=newhead;
        while (head!=null){
            int i=0;
            ListNode temphead=head;
            ListNode temp=null;
            while (head!=null&&i<k){
                stack.push(head);
                head=head.next;
                i++;
            }
            if (i==k){
               while (!stack.empty()){
                   temp=stack.pop();
                   temp.next=null;
                   rs.next=temp;
                   rs=rs.next;

               }
            }else {
                rs.next=temphead;
            }
        }
        return newhead.next;

    }
}
