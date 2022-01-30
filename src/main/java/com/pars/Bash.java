package com.pars;

import java.util.Scanner;

public class Bash {

    public static void main(String[] args) throws Exception {
        String reset = "Y";
        run(reset);
    }

    private static void run(String reset) throws Exception {
        Scanner scan = new Scanner(System.in);
        while (reset.equalsIgnoreCase("Y")) {
            try {
                System.out.println("Please, enter the mode of parser\n Mode 1 - Input the number of page and select the sort \n Mode 2 - enter the ID of quote");
                int var = scan.nextInt();
                if (var < 1 || var > 2)
                    throw new IllegalArgumentException("Mode must be 1 or 2");
                System.out.println(var);
                if (var == 1) {
                    System.out.print("Please enter the number of page (or will be enter - '0'(zero) for default page) - ");
                    int page = scan.nextInt();
                    System.out.print("Please select the mode of sort\n Sort by: 0-none_sort | 1-vote_up | 2-vote_down | 3-id_up | 4-id_down | 5-date_up | 6-date_down - ");
                    int choise = scan.nextInt();
                    GetCont getcont = new GetCont(page, choise);
                    getcont.parsing();
                } else if (var == 2) {
                    System.out.print("Input the ID of quote - ");
                    int idquote = scan.nextInt();
                    GetContentById getcontentbyid = new GetContentById(idquote);
                    getcontentbyid.ParsingQuote();
                }
            } catch (IllegalArgumentException i) {
                System.out.print("You enter the wrong number of mode, want continue? Enter - 'Y' - (continue)  or 'n' to exit - ");
                reset = scan.next();
                if (reset.equalsIgnoreCase("Y")) {
                    run(reset);
                }
            }
        }
    }
}