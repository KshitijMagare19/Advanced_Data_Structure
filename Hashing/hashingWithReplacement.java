package Hashing;
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

class HashTableWithLinearProbing {
    private BankAccount[] hashTable;
    private int size;

    public HashTableWithLinearProbing(int size) {
        this.size = size;
        hashTable = new BankAccount[size];
    }

    private int hashFunction(int accountNumber) {
        return accountNumber % size;
    }

    public void insert(BankAccount account) {
        int index = hashFunction(account.accountNumber);
        while (hashTable[index] != null) {
            index = (index + 1) % size; // Linear probing: move to the next slot
        }
        hashTable[index] = account;
    }

    public BankAccount find(int accountNumber) {
        int index = hashFunction(accountNumber);
        while (hashTable[index] != null) {
            if (hashTable[index].accountNumber == accountNumber) {
                return hashTable[index];
            }
            index = (index + 1) % size; // Linear probing: move to the next slot
        }
        return null;
    }

    public void delete(int accountNumber) {
        int index = hashFunction(accountNumber);
        while (hashTable[index] != null) {
            if (hashTable[index].accountNumber == accountNumber) {
                hashTable[index] = null;
                rehash(); // Optional: Rehash to maintain a compact table
                return;
            }
            index = (index + 1) % size; // Linear probing: move to the next slot
        }
    }

    private void rehash() {
        // Optional: Implement rehashing logic if needed
        // This can be used to maintain a compact table after deletions
    }

    public void displayHashTable() {
        for (int i = 0; i < size; i++) {
            if (hashTable[i] != null) {
                System.out.println("Index " + i + ": " + hashTable[i].accountNumber);
            } else {
                System.out.println("Index " + i + ": null");
            }
        }
    }
}

public class hashingWithReplacement{
    public static void main(String[] args) {
        HashTableWithLinearProbing hashTable = new HashTableWithLinearProbing(10);
        hashTable.insert(new BankAccount(1001, "ram", 500.0));
        hashTable.insert(new BankAccount(1002, "sham", 1000.0));
        hashTable.insert(new BankAccount(1003, "yash", 1500.0));
        hashTable.insert(new BankAccount(2002, "anil", 1010.0));
        hashTable.insert(new BankAccount(3002, "om", 1200.0));
        hashTable.insert(new BankAccount(4002, "raj", 1700.0));

        System.out.println("Hash Table with Linear Probing:");
        hashTable.displayHashTable();

        int accountNumberToFind = 1002;
        BankAccount foundAccount = hashTable.find(accountNumberToFind);
        if (foundAccount != null) {
            System.out.println("\nFound Account: " + foundAccount.accountHolderName + " - Balance: $" + foundAccount.balance);
        } else {
            System.out.println("Account not found.");
        }

        int accountNumberToDelete = 3002;
        hashTable.delete(accountNumberToDelete);
        System.out.println("\nAfter deleting account number " + accountNumberToDelete + ":");
        hashTable.displayHashTable();
    }
}
