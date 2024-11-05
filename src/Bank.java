import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int uniqueIDAccounts = 0;

    private int uniqueIDClient = 0;
    private List<Client> clients;
    private Client currentClient = null;

    public Bank() {
        /***
         Constructor
         ***/
        this.clients = new ArrayList<>();
    }

    public void addNewClient(Client client, int pin) {
        /***
         Add clients to the bank. What do you do when a client has already been added to the bank?
         ***/
        if (this.clients.contains(client)) {
            System.out.println("Client is already in the bank");
            return;
        }
        client.addBankID(this.uniqueIDClient++);
        client.setPin(pin);
        this.clients.add(client);
    }

    public void logOut() {
        /***
         Log the current user out of the bank
         ***/
        if (this.currentClient != null) {
            this.currentClient = null;
            return;
        }
        System.out.println("Logout incorrect");
    }

    public void logIn(int id, int pin) {
        /***
         Log the current user in to the bank. What happens is someone is already logged in?
         How do you validate if the user is indeed who they claim to be?
         If the user is unable to provide the correct information, the following sentence should be displayed:
         "This user is not know to the bank, please check if you gave the correct ID and PIN!"
         ***/
        for (Client client : this.clients) {
            if (client.getBankID() == id && client.getPin() == pin) {
                if (this.currentClient != null) {
                    logOut();
                }
                this.currentClient = client;
                return;
            }
        }
        System.out.println("This user is not know to the bank, please check if you gave the correct ID and PIN!");

    }

    public void addAccount(Client client, double amount) {
        /***
         Add an account, if all input valid in this method?
         ***/
        if (amount < 0) {
            System.out.println("Amount cannot be negative");
            return;
        }
        client.addAccount(new BankAccount(this.uniqueIDAccounts++, amount));
    }

    public void removeAccount(BankAccount toRemove, BankAccount transferAccount) {
        /***
         Remove an account, the user can transfer the money in the 'toRemove' account to the 'transferAccount'.
         ***/
        if (this.currentClient == null) {
            System.out.println("Client isn't logged in");
            return;
        }
        if (!this.currentClient.getAccounts().contains(toRemove)) {
            System.out.println("Account doesn't belongs to client");
            return;
        }
        if (transferAccount != null) {
            transferAccount.addToBalance(toRemove.getBalance());
        }
        this.currentClient.removeAccount(toRemove);
    }


    public void transfer(BankAccount transferFrom, BankAccount transferTo, double amount) {
        /***
         Transfer from 'transferFrom' to 'TransferTo' with a given ammount?
         Can anyone transfer, what with people that are not part of the bank?
         ***/

        Client deductfromClient = null;
        Client toClient = null;

        for (Client client : clients) {
            if (client.getAccounts().contains(transferFrom)) {
                deductfromClient = client;
            }
            if (client.getAccounts().contains(transferTo)) {
                toClient = client;
            }
        }

//        if (this.currentClient == null) {
//            System.out.println("Client isn't logged in");
//            return;
//        }
        if (deductfromClient == null || toClient == null) {
            System.out.println("Account doesn't belongs to client");
            return;
        }
        if (transferFrom.canBeRemovedFromBalance(amount)) {
            transferFrom.removeFromBalance(amount);
            transferTo.addToBalance(amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void displayAccounts() {
        /***
         Give a display to the user what accounts are associated with them.
         Give info abouth the index (for easy access), the ID and the amount.
         ***/
        if (this.currentClient == null) {
            return;
        }
        List<BankAccount> accounts = this.currentClient.getAccounts();
        if (!accounts.isEmpty()) {
            for (int i = 0; i < accounts.size(); i++) {
                BankAccount accountInfo = accounts.get(i);
                System.out.printf("Index: %d, ID: %d, Balance: %.2f\n", i, accountInfo.getID(), accountInfo.getBalance());
            }
        } else {
            System.out.println("Client has no accounts");
        }
    }

    public int maxIDClient() {
        /***
         Getter
         ***/
        return this.uniqueIDClient;
    }

    public Client getCurrentClient() {
        /***
         Getter
         ***/
        return this.currentClient;
    }

    public List<Client> getClients() {
        /***
         Getter
         ***/
        return this.clients;
    }

}
