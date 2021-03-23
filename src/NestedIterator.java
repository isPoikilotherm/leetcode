//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Stack;
//
//public class NestedIterator implements Iterator<Iterator> {
//
//    private Stack<NestedInteger> stack=new Stack<>();
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        for (int i = nestedList.size()-1; i >=0 ; i--) {
//            stack.push(nestedList.get(i));
//        }
//
//    }
//
//    @Override
//    public Integer next() {
//        return stack.pop().getInteger();
//
//    }
//
//    @Override
//    public boolean hasNext() {
//
//        while (!stack.empty()){
//            if (stack.peek().isInteger()){
//                return true;
//            }else {
//                List<NestedInteger> temp=stack.pop().getList();
//                for (int i = temp.size()-1; i >=0 ; i--) {
//                    stack.push(temp.get(i));
//                }
//            }
//
//        }
//        return false;
//
//    }
//
//
//}
