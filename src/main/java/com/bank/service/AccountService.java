package com.bank.service;

import java.util.Date;

public interface AccountService {

        void deposit(int amount);
        void withdraw(int amount);
        void printStatement();


}
