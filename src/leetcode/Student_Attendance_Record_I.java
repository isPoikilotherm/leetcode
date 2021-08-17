package leetcode;

public class Student_Attendance_Record_I {
    public boolean checkRecord(String s) {
        int acount=0,lcount=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='A'){
                acount++;
                lcount=0;
            }else if (s.charAt(i)=='L'){
                lcount++;
            }else {
                lcount=0;
            }

            if (acount>=2||lcount>=3){
                return false;
            }
        }
        return true;

    }
}
