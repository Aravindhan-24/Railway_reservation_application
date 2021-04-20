package railway;

import java.util.*;

public class Booking extends Railway {

    Book set[] = new Book[64];
    Book set_rac[] = new Book[18];
    Book set_waiting[] = new Book[10];

    public static int count = 0, rac_count = 0, waiting_count = 0, berth_counter = 0;

    Scanner sc = new Scanner(System.in);
    //Booking Ticket
    public void add_ticket(Book b) {

        System.out.println("Ticket Confirmed");
        if (count <= 63) {
            set[count] = b;
            count++;
        } else {
            for (int i = 0; i < count; i++) {
                if (set[i].name.equals("cancelled") || set[i].age == 999) {
                    set[i] = b;
                }
            }
        }
    }
    //booking under waiting
    public void add_waiting(Book b) {

        System.out.println("Ticket booked under rac");
        if (waiting_count <= 9) {
            set_waiting[waiting_count] = b;

            waiting_count++;
        } else {
            for (int i = 0; i < waiting_count; i++) {
                if (set_waiting[i].name.equals("cancelled") || set_waiting[i].age == 999) {
                    set_waiting[i] = b;

                }
            }
        }
    }
    //Booking under RAC
    public void add_rac(Book b) {

        System.out.println("Ticket booked under rac");

        if (rac_count <= 17) {
            set_rac[rac_count] = b;
            if (berth_counter < 9) {
                set_rac[rac_count].berth = "side lower berth";
                berth_counter++;
            } else {
                set_rac[rac_count].berth = "No berth guarenteed";
            }
            rac_count++;
        } else {
            for (int i = 0; i < rac_count; i++) {
                if (set_rac[i].name.equals("cancelled") || set_rac[i].age == 999) {
                    set_rac[i] = b;
                    if (berth_counter < 9) {
                        set_rac[rac_count].berth = "side lower berth";
                        berth_counter++;
                    } else {
                        set_rac[rac_count].berth = "No berth guarenteed";
                    }
                }
            }
        }

        System.out.println("Rac count " + rac_count);

    }

    public void prepare_chart() {
        System.out.println("Tickets under Confirmed List");
        for (int i = 0; i < count; i++) {

            if (set[i].name.equals("cancelled") && set[i].age == 999) {

                continue;
            } else {
                System.out.println(i + 1 + " " + set[i].name + "\t " + set[i].age + "\t " + set[i].gender + "\t " + set[i].berth);
            }
        }
        System.out.println("Tickets under RAC List");
        for (int i = 0; i < rac_count; i++) {

            if (set_rac[i].name.equals("cancelled") && set_rac[i].age == 999) {

                continue;
            } else {
                System.out.println(i + 1 + " " + set_rac[i].name + "\t " + set_rac[i].age + "\t " + set_rac[i].gender + "\t " + set_rac[i].berth);
            }
        }
        System.out.println("Tickets under WAITING List");
        for (int i = 0; i < waiting_count; i++) {

            if (set_waiting[i].name.equals("cancelled") && set_waiting[i].age == 999) {

                continue;
            } else {
                System.out.println(i + 1 + " " + set_waiting[i].name + "\t " + set_waiting[i].age + "\t " + set_waiting[i].gender + "\t " + set_waiting[i].berth);
            }
        }

    }

    public void cancel() {
        int age;
        String name;
        System.out.println("Enter your First name");
        name = sc.nextLine();
        System.out.println("Enter your age");
        age = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            if ((set[i].name.equals(name)) && (set[i].age == age)) {

                if (rac_count <= 0) {
                    set[i].name = "cancelled";
                    set[i].age = 999;
                    set[i].gender = "cancelled";
                    set[i].berth = "cancelled";
                } else {

                    set[i].name = set_rac[0].name;
                    set[i].age = set_rac[0].age;
                    set[i].gender = set_rac[0].gender;

                    for (int j = 0; j < rac_count; j++) {

                        try {

                            set_rac[j].name = set_rac[j + 1].name;
                            set_rac[j].age = set_rac[j + 1].age;
                            set_rac[j].gender = set_rac[j + 1].gender;

                        } catch (Exception e) {
                            try {
                                set_rac[j].name = set_waiting[0].name;
                                set_rac[j].age = set_waiting[0].age;
                                set_rac[j].gender = set_waiting[0].gender;

                                for (int k = 0; k < waiting_count; k++) {
                                    try {
                                        set_waiting[k].name = set_waiting[k + 1].name;
                                        set_waiting[k].age = set_waiting[k + 1].age;
                                        set_waiting[k].gender = set_waiting[k + 1].gender;
                                    } catch (Exception err) {
                                        set_waiting[k].name = "cancelled";
                                        set_waiting[k].age = 999;
                                        set_waiting[k].gender = "cancelled";
                                        set_waiting[k].berth = "cancelled";
                                    }
                                }
                            } catch (Exception er) {
                                set_rac[j].name = "cancelled";
                                set_rac[j].age = 999;
                                set_rac[j].gender = "cancelled";
                                set_rac[j].berth = "cancelled";
                            }
                        }
                    }

                }
                break;
            }

        }//cancellation for confirmation
        for (int i = 0; i < rac_count; i++) {

            if ((set_rac[i].name.equals(name)) && (set_rac[i].age == age)) {
                if (waiting_count <= 0) {
                    set_rac[i].name = "cancelled";
                    set_rac[i].age = 999;
                    set_rac[i].gender = "cancelled";
                    set_rac[i].berth = "cancelled";
                } else {

                    set_rac[i].name = set_waiting[0].name;
                    set_rac[i].age = set_waiting[0].age;
                    set_rac[i].gender = set_waiting[0].gender;

                    for (int j = 0; j < waiting_count; j++) {

                        try {

                            set_waiting[j].name = set_waiting[j + 1].name;
                            set_waiting[j].age = set_waiting[j + 1].age;
                            set_waiting[j].gender = set_waiting[j + 1].gender;

                        } catch (Exception e) {
                            set_waiting[j].name = "cancelled";
                            set_waiting[j].age = 999;
                            set_waiting[j].gender = "cancelled";
                            set_waiting[j].berth = "cancelled";
                        }
                    }

                }
                break;
            }

        }//cancellation for rac
        for (int i = 0; i < waiting_count; i++) {

            if ((set_waiting[i].name.equals(name)) && (set_waiting[i].age == age)) {
                set_waiting[i].name = "cancelled";
                set_waiting[i].age = 999;
                set_waiting[i].gender = "cancelled";
                set_waiting[i].berth = "cancelled";
            }

        }
    }

    //print available tickets total and available
    public void available() {
        int available = 63 - count;
        int rac_available = 17 - rac_count;
        int waiting_available = 9 - waiting_count;

        if (rac_count >= 17) {
            for (int i = 0; i < rac_count; i++) {
                if (set_rac[i].name.equals("cancelled") && set_rac[i].age == 999) {
                    rac_available++;
                }
            }

        }
        if (waiting_count >= 9) {
            for (int i = 0; i < waiting_count; i++) {
                if (set_waiting[i].name.equals("cancelled") && set_waiting[i].age == 999) {
                    waiting_available++;
                }
            }

        }
        System.out.println("Confirm available " + available + " RAC available " + rac_available + " Waiting available " + waiting_available);

    }

}
