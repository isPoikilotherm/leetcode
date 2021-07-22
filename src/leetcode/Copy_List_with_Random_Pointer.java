package leetcode;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {
        if (head==null){
            return null;
        }
        Node newhead=new Node(head.val);
        Map<Node,Node> map=new HashMap<>();
        map.put(head,newhead);
        Node head1=head;
        Node newhead1=newhead;
        while (head1.next!=null){
            head1=head1.next;
            Node nextnode=new Node(head1.val);
            newhead1.next=nextnode;
            newhead1=newhead1.next;
            map.put(head1,newhead1);
        }
        head1=head;
        newhead1=newhead;
        while (head1!=null){
           if (head1.random==null){
               newhead1.random=null;
           }else {
               newhead1.random=map.get(head1.random);
           }
           head1=head1.next;
           newhead1=newhead1.next;
        }

        return newhead;

    }
}
