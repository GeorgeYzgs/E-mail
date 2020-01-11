/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author George.Giazitzis
 */
public class Email {

    private final Scanner sc = new Scanner(System.in);
    private final String firstName;
    private final String lastName;
    private String password;
    private String department;
    private String companyEmail;
    private static int mailboxCapacity = 300;
    private static final int defaultPwdLength = 16;
    private String alternateEmail;
    private static final String companySuffix = "realcompany.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.companyEmail = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department + "." + this.companySuffix;
        this.password = randomPassword(defaultPwdLength);
    }

    private String setDepartment() {
        System.out.println("Insert the department they are in? \n1 for Accounting \n2 for Sales\n3 for Development");
        String choice;
        loop:
        do {
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    choice = "accounting";
                    break loop;
                case "2":
                    choice = "sales";
                    break loop;
                case "3":
                    choice = "development";
                    break loop;
                default:
                    System.out.println("Invalid input, please try again!");
            }
        } while (true);
        return choice;
    }

    private String randomPassword(int length) {
        String tempPass = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
        Random rnd = new Random();
        char[] pwd = new char[length];
        for (int i = 0; i < length; i++) {
            pwd[i] = tempPass.charAt(rnd.nextInt(tempPass.length()));
        }
        return new String(pwd);
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;

    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void setPassword() {
        String newPassword;
        String newPasswordValidation;
        do {
            System.out.println("Enter your new password:\nYour password must be 8 to 16 characters long and must contain at least 1 uppercase letter, 1 lowercase letter & 1 digit.");
            newPassword = sc.nextLine();
            System.out.println("Please Re-Enter your new password.");
            newPasswordValidation = sc.nextLine();
            if (newPassword.equals(this.password)) {
                System.out.println("Your new password cannot match your old password!");
            } else if (!newPasswordValidation.equals(newPassword)) {
                System.out.println("Your passwords do not match!");
            } else if (!isValid(newPassword)) {
                System.out.println("That is an incorrect password!");
            }
        } while (!newPasswordValidation.equals(newPassword) || !isValid(newPassword) || newPassword.equals(this.password));
        System.out.println("Your password has been changed.");
        this.password = newPassword;
    }

    private boolean isValid(String password) {
        boolean atleastOneUpper = false;
        boolean atleastOneLower = false;
        boolean atleastOneDigit = false;
        boolean passwordLength = false;

        if (password.length() >= 8 && password.length() <= 16) {
            passwordLength = true;
        }
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                atleastOneUpper = true;
            } else if (Character.isLowerCase(password.charAt(i))) {
                atleastOneLower = true;
            } else if (Character.isDigit(password.charAt(i))) {
                atleastOneDigit = true;
            }
        }
        return (atleastOneUpper && atleastOneLower && atleastOneDigit && passwordLength);
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Name: " + this.firstName + " " + this.lastName
                + "\ntheir company email is: " + this.companyEmail
                + "\nwith a mailbox capacity of: " + this.mailboxCapacity + "mb"
                + "\ntheir password is: " + this.password;
    }
}
