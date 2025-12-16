package com.bank.service;

import com.bank.entity.Transaction;

import java.text.SimpleDateFormat;
import java.util.*;

public class Account implements AccountService {

    private int balance;
    private List<Transaction> transactions;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }
    @Override
    public void deposit(int amount) {
        deposit(amount, new Date());
    }

    // Méthode surchargée pour les tests
    public void deposit(int amount, Date date) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant du dépôt doit etre positif");
        }
        balance += amount;
        transactions.add(new Transaction(date, amount, balance));
    }


    @Override
    public void withdraw(int amount) {
        withdraw(amount, new Date());
    }

    // Méthode surchargée pour les tests et parceque on peut pas modifié l interface
    public void withdraw(int amount, Date date) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant du retrait doit etre positif");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Solde insuffisant");
        }
        balance -= amount;
        transactions.add(new Transaction(date, -amount, balance));
    }

    @Override
    public void printStatement() {
        System.out.println("Date       || Amount || Balance");
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);
            System.out.println(DATE_FORMAT.format(t.getDate()) + " || " +
                    t.getAmount() + " || " +
                    t.getBalance());
        }
    }

}
