public class Merge_k_Sorted_Lists {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0){
            return null;
        }
        if (lists.length==1){
            return lists[0];
        }
        ListNode res=lists[0];
        for (int i = 1; i < lists.length; i++) {
            res=merge(res,lists[i]);
        }
        return res;

    }

    public ListNode merge(ListNode a,ListNode b){
        ListNode res= new ListNode(0,null);
        ListNode tag=res;
        while (a!=null&&b!=null){
            if (a.val<b.val){
                tag.next=a;
                tag=tag.next;
                a=a.next;
            }else {
                tag.next=b;
                tag=tag.next;
                b=b.next;
            }
        }
        if (a==null){
            tag.next=b;
        }else {
            tag.next=a;
        }
        return res.next;
    }
}
