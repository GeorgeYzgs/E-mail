/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3email;

import classes.Email;

/**
 *
 * @author George.Giazitzis
 */
public class Week3email {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Email e1 = new Email("Jack","Black");
        System.out.println(e1);
        e1.setPassword();
    }
    
}
