package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Corporate_Flight_Bookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans=new int[n];
        for (int[] booking : bookings) {
            for (int i = booking[0]; i <= booking[1]; i++) {
                int now = ans[i-1];
                now=now+booking[2];
                ans[i-1]=now;
            }
        }
        return ans;

    }
}
