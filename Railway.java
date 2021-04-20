package railway;

import java.util.*;

public class Railway {

    public static void main(String[] args) {

        int option, age, ticket_count = 1, rac_count = 1, waiting_count = 1;
        String name, gender, berth, cont = "y", child = "no";
        Scanner sc = new Scanner(System.in);
        Booking ob = new Booking();

        while (cont.equals("y")) {
            System.out.println(" 1.Book\n 2.prepare chart\n 3.print_available\n 4.Cancel\n 5.exit");
            option = sc.nextInt();

            switch (option) {
                case 1:

                    if (ticket_count < 65) {
                        Book b = new Book();
                        b.add();
                        ob.add_ticket(b);
                        ticket_count++;
                    } else if (ticket_count > 64 && rac_count < 19) {
                        Book b = new Book();
                        b.add();
                        ob.add_rac(b);
                        rac_count++;
                    } else if (ticket_count > 64 && rac_count > 18 && waiting_count < 11)
                    {
                        Book b = new Book();
                        b.add();
                        ob.add_waiting(b);
                        waiting_count++;
                    } else {
                        System.out.println("Booking full");
                    }

                    break;
                case 2:

                    ob.prepare_chart();
                    break;

                case 3:
                    ob.available();
                    break;
                case 4:
                    if (ticket_count > 1 && (rac_count <= 1 && waiting_count <= 1)) {
                        ob.cancel();
                        ticket_count--;
                    } else if (rac_count > 1 && waiting_count <= 1) {
                        ob.cancel();
                        rac_count--;
                    } else if (waiting_count > 1) {
                        ob.cancel();
                        waiting_count--;
                    } else {
                        System.out.println("No tickets booked");
                    }

                    break;
                case 5:
                    cont = "n";
                    break;
                default:
                    System.out.println("Enter a valid option");
                    break;
            }
        }
    }

}
