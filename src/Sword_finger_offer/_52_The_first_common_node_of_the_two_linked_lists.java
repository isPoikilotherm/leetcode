package Sword_finger_offer;

import leetcode.ListNode;

import java.util.LinkedHashSet;
import java.util.Set;

public class _52_The_first_common_node_of_the_two_linked_lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set=new LinkedHashSet<>();
        while (headA!=null){
            set.add(headA);
            headA=headA.next;
        }

        while (headB!=null){
            if (set.contains(headB)){
                return headB;
            }
            headB=headB.next;
        }
        return null;

    }
}
