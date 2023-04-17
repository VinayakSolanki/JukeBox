package browser;

import beans.User;
import controller.Account;
import model.UserDetails;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Display {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        String userName;
        String password;
        User use = null;
        int repeat = 1;
        int userid = 0;


        ArrayList<User> list1 = UserDetails.user();
        System.out.println("**********  WELCOME TO JUKEBOX  **********");
        System.out.println("-------------------");
        try {
            System.out.println("Enter\n 1 : login to jukebox\n 2 : create new account ");
            option = sc.nextInt();

            switch (option) {
                case 1: {
                    int flag = 0;
                    do {
                        System.out.println("Enter User Name");
                        userName = sc.next();

                        System.out.println("Enter the password");
                        password = sc.next();

                        Iterator<User> i = list1.iterator();

                        while (i.hasNext()) {
                            use = i.next();
                            if (use.getUserName().equals(userName) && use.getPassword().equals(password)) {
                                System.out.println("welcome");
                                userid = use.getUserId();
                                flag = 1;
                            }
                        }
                        if (flag == 1) {
                            Menu.mainMenu(userid);
                        } else {
                            System.out.println("wrong credentials Enter correct details");
                            repeat = 0;

                        }
                    } while (repeat == 0);

                    break;
                }


                case 2: {
                    System.out.println("welcome in jukebox");
                    System.out.println("enter name");
                    userName = sc.next();
                    System.out.println("enter user password");
                    password = sc.next();
                    Account account = new Account();
                    if (account.createNewAccount(userName, password)) {
                        System.out.println("Successfully Account Created");
                    } else {
                        System.out.println("Sorry Try Again");
                    }

                }
                break;

            }
        } catch (InputMismatchException e) {
            System.out.println(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
