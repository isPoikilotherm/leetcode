package leetcode;

import java.util.List;

public class Employee_Importance {

    public int getImportance(List<Employee> employees, int id) {
        int ans=0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).id==id){
                Employee em=new Employee();
                em=employees.get(i);
                if (em.subordinates.size()==0){
                    return em.importance;
                }else {
                    ans+=em.importance;
                    for (int j = 0; j <em.subordinates.size(); j++) {
                        ans+=getImportance(employees,em.subordinates.get(i));
                    }
                }
                break;
            }
        }
        return ans;

    }


}
