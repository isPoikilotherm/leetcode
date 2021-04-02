import java.util.Stack;

public class Volume_of_Histogram_LCCI {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[stack.peek()] < height[i]) {
                if (stack.size()==1){
                    stack.pop();
                    stack.push(i);
                }else {
                    int bottom = height[stack.pop()];
                    ans = ans + (Math.min(height[stack.peek()], height[i]) - bottom) * (i - stack.peek() - 1);
                }

            }
            if (stack.empty() || height[stack.peek()] > height[i]) {
                stack.push(i);
            } else if (height[stack.peek()] == height[i]) {
                stack.pop();
                stack.push(i);
            }
        }
        return ans;

    }




}
