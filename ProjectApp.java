import java.util.Scanner;

public class ProjectApp {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        Date a = new Date(2022, 1, 1);
        a = a.addDays(40);
        System.out.println(a);

        Project one = new Project("Sys-Renew", "Upgrade payroll system and hardware", "2022-5-22", "2022-6-21");
        Project two = new Project("LAB-IMPLEMENT", "Update Lab Results Reports" , "2023-5-22", "2023-9-30");

        System.out.println("*****PROJECT 1*****");
        System.out.println(one.toString());
        
        
        
    }
}
