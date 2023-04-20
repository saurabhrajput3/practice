import services.ServicesImp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ServicesImp servicesImp=new ServicesImp();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter car type-");
        String car=sc.nextLine();
        System.out.println("Enter services code-");
        String serType=sc.nextLine();

        String[] n=serType.split(", ");
        servicesImp.startService(car,n);
    }
}