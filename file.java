import java.util.*;

public class file {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the Number of Blocks");

        int n = scn.nextInt();
        System.out.println("Enter the Names of towers");

        String[] t_name = new String[3];

        for (int i = 0; i < 3; i++) {
            t_name[i] = scn.next();
        }

        ArrayList<String> al1 = new ArrayList<>();
        ArrayList<String> al2 = new ArrayList<>();
        ArrayList<String> al3 = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            al1.add("Block " + (j + 1));
        }

        tower(n, al1, al2, al3, 1, t_name);

        for (int i = 0; i < al2.size(); i++) {
            System.out.print("           ");
            System.out.println(al2.get(i));
        }

        for (int i = 0; i < t_name.length; i++) {
            System.out.print("   " + t_name[i] + "       ");
        }

        scn.close();
    }

    public static void tower(int n, ArrayList<String> al1, ArrayList<String> al2, ArrayList<String> al3, int p, String[] t_name) {
        if (n == 0) {
            return;
        }

        tower(n - 1, al1, al3, al2, 1, t_name);

        int size1, size2, size3;

        if (p == 1) {
            size1 = al1.size();
            size2 = al3.size();
            size3 = al2.size();

            while (size1 > 0 || size2 > 0 || size3 > 0) {

                if (size1 > 0) {
                    System.out.print(al1.get(size1 - 1));
                    size1--;
                } else System.out.print("       ");

                System.out.print("     ");

                if (size2 > 0) {
                    System.out.print(al3.get(size2 - 1));
                    size2--;
                } else System.out.print("       ");

                System.out.print("     ");

                if (size3 > 0) {
                    System.out.print(al2.get(size3 - 1));
                    size3--;
                }

                System.out.println();
            }

        } else {
            size1 = al3.size();
            size2 = al2.size();
            size3 = al1.size();

            while (size1 > 0 || size2 > 0 || size3 > 0) {

                if (size1 > 0) {
                    System.out.print(al3.get(size1 - 1));
                    size1--;
                } else System.out.print("       ");

                System.out.print("     ");

                if (size2 > 0) {
                    System.out.print(al2.get(size2 - 1));
                    size2--;
                } else System.out.print("       ");

                System.out.print("     ");

                if (size3 > 0) {
                    System.out.print(al1.get(size3 - 1));
                    size3--;
                }

                System.out.println();

            }
        }

        for (int i = 0; i < t_name.length; i++) {
            System.out.print("   " + t_name[i] + "       ");
        }

        System.out.println();
        System.out.println();

        al2.add(al1.remove(al1.size() - 1));

        tower(n - 1, al3, al2, al1, 0, t_name);
    }
}



