import java.util.Scanner;
public class Main {
    static String Jeff[][] = new String[][]{
            {"", "Mon", "Tue", "Wed", "Thu"},
            {"11-12", "X", "X", "_", "_"},
            {"12-1", "_", "X", "X", "X"},
            {"1-2", "_", "X", "X", "_"},
            {"2-3", "X", "X", "X", "_"}
    };

    static String Anna[][] = new String[][]{
            {"", "Mon", "Tue", "Wed", "Thu"},
            {"11-12", "X", "X", "_", "X"},
            {"12-1", "_", "X", "_", "X"},
            {"1-2", "X", "X", "_", "_"},
            {"2-3", "X", "_", "X", "X"}
    };
    static String individual[][] = new String[][]{
            {"", "Mon", "Tue", "Wed", "Thu"},
            {"11-12", "_", "_", "_", "_"},
            {"12-1", "_", "_", "_", "_"},
            {"1-2", "_", "_", "_", "_"},
            {"2-3", "_", "_", "_", "_"}
    };
    static String group[][] = new String[][]{
            {"", "Mon", "Tue", "Wed", "Thu"},
            {"11-12", "_", "_", "_", "_"},
            {"12-1", "_", "_", "_", "_"},
            {"1-2", "_", "_", "_", "_"},
            {"2-3", "_", "_", "_", "_"}
    };
    static int select_instructor;
    static int select_day;
    static int select_slot;
    static String letter;


    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter one of the following commands:");
        System.out.println("p- Print schedules");
        System.out.println("s- Schedule a slot");
        System.out.println("f- Free a slot");
        System.out.println("i- Show slots available for individual lessons");
        System.out.println("g- Show slots available for group lessons");
        System.out.println("q- Quit");
        letter = input.nextLine();
        while (true) {
            if (letter.equals("p")) {
                Schedules();
            } else if (letter.equals("s")) {
                Schedule_slot();

            } else if (letter.equals("f")) {
                Free_slot();
            } else if (letter.equals("i")) {
                Individual_available();
            }
            else if(letter.equals("g")){
                Group_avaliable();
            }
            else if(letter.equals("q")){
                System.exit(0);
            }
        }


    }

    public static void Schedule_slot() {
        Scanner input = new Scanner(System.in);

        System.out.print("Select instructor(1-Jeff, 2-Anna): ");
        select_instructor = input.nextInt();
        System.out.print("Select Day(1-Mon,2-Tue,3-Wed,4-Thu: ");
        select_day = input.nextInt();
        System.out.print("Select Slot(1:11-12,2:12-1,3:1-2,4:2-3): ");
        select_slot = input.nextInt();
        System.out.println();
        if (select_instructor == 1) {
            if (select_day != 0 && select_slot != 0) {
                Jeff[select_slot][select_day] = "X";
            }
        } else if (select_instructor == 2) {
            if (select_day != 0 && select_slot != 0) {
                Anna[select_day][select_slot] = "X";
            }
        }
        menu();
    }

    public static void Schedules() {
        System.out.println("Jeff: ");
        for (int i = 0; i < Jeff.length; i++) {
            for (int j = 0; j < Jeff[i].length; j++) {
                System.out.printf("%-10s", Jeff[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println("Anna: ");
        for (int i = 0; i < Anna.length; i++) {
            for (int j = 0; j < Anna[i].length; j++) {
                System.out.printf("%-10s", Anna[i][j]);
            }
            System.out.println();
        }
        menu();
    }

    public static void Free_slot() {
        Scanner input = new Scanner(System.in);
        System.out.print("Select instructor(1-Jeff, 2-Anna): ");
        select_instructor = input.nextInt();
        System.out.print("Select Day(1-Mon,2-Tue,3-Wed,4-Thu: ");
        select_day = input.nextInt();
        System.out.print("Select Slot(1:11-12,2:12-1,3:1-2,4:2-3): ");
        select_slot = input.nextInt();
        System.out.println();
        if (select_instructor == 1) {
            if (select_slot != 0 && select_day != 0) {
                Jeff[select_slot][select_day] = "_";
            }
        } else if (select_instructor == 2) {
            if (select_slot != 0 && select_day != 0) {
                Anna[select_slot][select_day] = "_";
            }
        }
        menu();
    }

    public static void individual_schedule(){
        System.out.println("Slots marked with a 'I' are available for individual lessons");
        for (int i = 0; i < individual.length; i++) {
            for (int j = 0; j < individual[i].length; j++) {
                System.out.printf("%-10s", individual[i][j]);
            }
            System.out.println();
        }
        menu();
    }

    public static void group_schedule(){
        System.out.println("Slots marked with a 'G' are available for group lessons");
        for (int i = 0; i < group.length; i++) {
            for (int j = 0; j < group[i].length; j++) {
                System.out.printf("%-10s", group[i][j]);
            }
            System.out.println();
        }
        menu();

    }

    public static void Individual_available() {
        for (int i = 0; i < individual.length; i++) {
            for (int j = 0; j < individual[i].length; j++) {
                if (Jeff[i][j].equals("_") || Anna[i][j].equals("_")) {
                    individual[i][j] = "I";
                }
            }
        }
        individual_schedule();
    }

    public static void Group_avaliable(){
        for (int i = 0; i < individual.length; i++) {
            for (int j = 0; j < individual[i].length; j++) {
                if (Jeff[i][j].equals("_") && Anna[i][j].equals("_")) {
                    group[i][j] = "G";
                }
            }
        }
        group_schedule();
    }
}





