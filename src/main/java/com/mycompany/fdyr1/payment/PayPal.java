/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fdyr1.payment;

/**
 *
 * @author Student
 */
public class PayPal implements ProcessPayment {

    @Override
    public boolean payment(Payment payment) throws Exception {
        return true; // if payment was successful 
    }
    
}
