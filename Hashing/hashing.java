package Hashing;

import java.util.LinkedList;

class BankAccount {
    int accountNumber;
    String accountHolderName;
    double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }
}

class HashTableWithChaining {
    private LinkedList<BankAccount>[] hashTable;
    private int size;

    public HashTableWithChaining(int size) {
        this.size = size;
        hashTable = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int accountNumber) {
        return accountNumber % size;
    }

    public void insert(BankAccount account) {
        int index = hashFunction(account.accountNumber);
        hashTable[index].add(account);
    }

    public BankAccount find(int accountNumber) {
        int index = hashFunction(accountNumber);
        LinkedList<BankAccount> list = hashTable[index];
        for (BankAccount account : list) {
            if (account.accountNumber == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void delete(int accountNumber) {
        int index = hashFunction(accountNumber);
        LinkedList<BankAccount> list = hashTable[index];
        list.removeIf(account -> account.accountNumber == accountNumber);
    }

    public void displayHashTable() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            LinkedList<BankAccount> list = hashTable[i];
            for (BankAccount account : list) {
                System.out.print(account.accountNumber + " -> ");
            }
            System.out.println("null");
        }
    }
}

public class hashing {
    public static void main(String[] args) {
        HashTableWithChaining hashTable = new HashTableWithChaining(10);
        hashTable.insert(new BankAccount(1001, "ram", 500.0));
        hashTable.insert(new BankAccount(1002, "sham", 1000.0));
        hashTable.insert(new BankAccount(1003, "yash", 1500.0));
        hashTable.insert(new BankAccount(2002, "anil", 1010.0));
        hashTable.insert(new BankAccount(3002, "om", 1200.0));
        hashTable.insert(new BankAccount(4002, "raj", 1700.0));

        System.out.println("Hash Table with Chaining (Without Replacement):");
        hashTable.displayHashTable();

        int accountNumberToFind = 1002;
        BankAccount foundAccount = hashTable.find(accountNumberToFind);
        if (foundAccount != null) {
            System.out.println(
                    "\nFound Account: " + foundAccount.accountHolderName + " - Balance: $" + foundAccount.balance);
        } else {
            System.out.println("Account not found.");
        }

        int accountNumberToDelete = 3002;
        hashTable.delete(accountNumberToDelete);
        System.out.println("\nAfter deleting account number " + accountNumberToDelete + ":");
        hashTable.displayHashTable();
    }
}
