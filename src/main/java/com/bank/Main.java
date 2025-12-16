package com.bank;

import com.bank.service.AccountService;
import com.bank.service.Account;

import java.text.SimpleDateFormat;

public class Main {


        public static void main(String[] args) throws Exception {

            Account account = new Account();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            account.deposit(1000, sdf.parse("10/01/2012"));
            account.deposit(2000, sdf.parse("13/01/2012"));
            account.withdraw(500, sdf.parse("14/01/2012"));

            account.printStatement();
        }
}
