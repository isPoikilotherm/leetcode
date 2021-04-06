import java.util.Map;
import java.util.Stack;

public class Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] heights) {
        int len= heights.length;
        if (len==0){
            return 0;
        }
        if (len==1){
            return heights[0];
        }
        int ans=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for (int i = 1; i < len; i++) {
            while (!stack.empty()&&heights[i]<heights[stack.peek()]){
                int temp=stack.pop();
                while (!stack.empty()&&heights[temp]==heights[stack.peek()]){
                    stack.pop();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peek() - 1;
                }
                ans=Math.max(ans,heights[temp]*curWidth);
            }
            stack.add(i);
        }

        while (!stack.empty()){
            int temp=stack.pop();
            while (!stack.empty()&&heights[temp]==heights[stack.peek()]){
                stack.pop();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peek() - 1;
            }
            ans=Math.max(ans,heights[temp]*curWidth);
        }
        return ans;



    }
}
